/* global $, Mustache, formatDuration, formatTimeMillis, jQuery, uiRoot */

var appLimit = -1;

function setAppLimit(val) {
  appLimit = val;
}

function makeIdNumeric(id) {
  var strs = id.split("_");
  if (strs.length < 3) {
    return id;
  }
  var appSeqNum = strs[2];
  var resl = strs[0] + "_" + strs[1] + "_";
  var diff = 10 - appSeqNum.length;
  while (diff > 0) {
    resl += "0"; // padding 0 before the app sequence number to make sure it has 10 characters
    diff--;
  }
  resl += appSeqNum;
  return resl;
}

function getParameterByName(name, searchString) {
  var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
    results = regex.exec(searchString);
  return results === null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
}

function removeColumnByName(columns, columnName) {
  return columns.filter(function (col) {
    return col.name != columnName
  })
}

function getColumnIndex(columns, columnName) {
  for (var i = 0; i < columns.length; i++) {
    if (columns[i].name == columnName)
      return i;
  }
  return -1;
}

function renderTable(element, template, data) {
  if (data.applications.length <= 0) {
    element.text("No applications found!")
    return
  }

  // render bodiless table (only has header)
  const table = $(Mustache.render($(template).filter("#history-summary-template").html(), data));
  let columns = [
    {
      name: "version",
      data: "version"
    },
    {
      name: "appId",
      data: "id",
      render: (id, type, row) => `<span title="${id}"><a href="${row.attemptUrl}">${id}</a></span>`
    },
    {
      name: "appName",
      data: "name"
    },
    {
      name: "attemptId",
      data: "attemptId",
      render: (attemptId, type, row) => (attemptId ? `<a href="${row.attemptUrl}">${attemptId}</a>` : "")
    },
    {
      name: "started",
      data: "startTime"
    },
    {
      name: "completed",
      data: "endTime"
    },
    {
      name: "duration",
      data: "duration",
      searchable: false,
      render: (duration, type, row) => `<span title="${row.durationMillisec}">${row.duration}</span>`
    },
    {
      name: "user",
      data: "sparkUser"
    },
    {
      name: "lastUpdated",
      data: "lastUpdated"
    },
    {
      name: "eventLog",
      data: "log",
      render: (log, type, row) => `<a href="${log}" class="btn btn-info btn-mini">Download</a>`
    },
  ]
  if (!data.hasMultipleAttempts) {
    columns = columns.filter(c => c.name !== "attemptId")
  }
  if (!data.showCompletedColumns) {
    columns = columns.filter(c => c.name !== "completed" && c.name !== "duration")
  }

  let orderCol = data.showCompletedColumns ? "completed" : "started"
  let conf = {
    data: data.applications,
    columns: columns,
    order: [[columns.findIndex(c => c.name === orderCol), "desc"]],
    autoWidth: false,
    deferRender: true
  };

  if (data.hasMultipleAttempts) {
    conf.rowsGroup = [
      "appId:name",
      "version:name",
      "appName:name"
    ];
  }

  element.html(table);
  table.DataTable(conf);
  element.find('[data-toggle="tooltip"]').tooltip();
}

function flatMapAttempts(app) {
  return app["attempts"]
    .map((attempt) => {
        const attemptPart = attempt["attemptId"] ? attempt["attemptId"] + "/" : ""
        const logUrl = `${uiRoot}/api/v1/applications/${app.id}/${attemptPart}logs`
        const attemptUrl = attempt["completed"] ?
          `${uiRoot}/history/${app.id}/${attemptPart}jobs/` :
          `${uiRoot}/proxy/${app.id}/${attemptPart}jobs/`

        return {
          ...attempt,

          startTime: formatTimeMillis(attempt["startTimeEpoch"]),
          endTime: formatTimeMillis(attempt["endTimeEpoch"]),
          lastUpdated: formatTimeMillis(attempt["lastUpdatedEpoch"]),
          durationMillisec: attempt["duration"],
          duration: formatDuration(attempt["duration"]),
          attemptUrl: attemptUrl,
          log: logUrl,
          id: app.id,
          name: app.name,
          version: attempt["appSparkVersion"],
        }
      }
    )
}

jQuery.extend(jQuery.fn.dataTableExt.oSort, {
  "title-numeric-pre": function (a) {
    var x = a.match(/title="*(-?[0-9.]+)/)[1];
    return parseFloat(x);
  },

  "title-numeric-asc": function (a, b) {
    return ((a < b) ? -1 : ((a > b) ? 1 : 0));
  },

  "title-numeric-desc": function (a, b) {
    return ((a < b) ? 1 : ((a > b) ? -1 : 0));
  }
});

jQuery.extend(jQuery.fn.dataTableExt.oSort, {
  "appid-numeric-pre": function (a) {
    var x = a.match(/title="*(-?[0-9a-zA-Z\\-_]+)/)[1];
    return makeIdNumeric(x);
  },

  "appid-numeric-asc": function (a, b) {
    return ((a < b) ? -1 : ((a > b) ? 1 : 0));
  },

  "appid-numeric-desc": function (a, b) {
    return ((a < b) ? 1 : ((a > b) ? -1 : 0));
  }
});

jQuery.extend(jQuery.fn.dataTableExt.ofnSearch, {
  "appid-numeric": function (a) {
    return a.replace(/[\r\n]/g, " ").replace(/<.*?>/g, "");
  }
});

$(document).on("ajaxStop", $.unblockUI);
$(document).on("ajaxStart", () => {
  $.blockUI({message: "<h3>Loading history summary...</h3>"});
});

$(document).ready(async function () {
  $.extend($.fn.dataTable.defaults, {
    stateSave: true,
    lengthMenu: [[20, 40, 60, 100, -1], [20, 40, 60, 100, "All"]],
    pageLength: 20
  });

  const response = await $.getJSON(`${uiRoot}/api/v1/applications`, {limit: appLimit});
  let apps = response.flatMap(flatMapAttempts)
  let runningApps = apps.filter((app) => !app["completed"])
  let completedApps = apps.filter((app) => app["completed"])
  let hasMultipleAttempts = response.some((app) => app["attempts"].length > 1)

  const template = await $.get(`${uiRoot}/static/historypage-template.html`)

  renderTable(
    $("#running-app-table"),
    template,
    {
      applications: runningApps,
      hasMultipleAttempts: hasMultipleAttempts,
      showCompletedColumns: false,
    }
  );

  renderTable(
    $("#completed-app-table"),
    template,
    {
      applications: completedApps,
      hasMultipleAttempts: hasMultipleAttempts,
      showCompletedColumns: true,
    }
  );
});
