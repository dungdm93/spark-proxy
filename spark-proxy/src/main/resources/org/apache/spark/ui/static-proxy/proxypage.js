/* global $, Mustache, formatDuration, formatTimeMillis, jQuery, uiRoot */

let appLimit = -1;

function setAppLimit(val) {
  appLimit = val;
}

const runningAppTemplate = `
<table id="running-app-table" class="table table-striped compact">
  <thead>
    <tr>
      <th>
        <span data-toggle="tooltip" data-placement="top" title="Spark version of this application.">Version</span>
      </th>
      <th>
        <span data-toggle="tooltip" data-placement="top" title="ID of this application.">App ID</span>
      </th>
      <th>
        <span data-toggle="tooltip" data-placement="top" title="Name of this application.">App Name</span>
      </th>
      <th>
        <span data-toggle="tooltip" data-placement="top" title="Number of cores to use for the driver process.">Cores</span>
      </th>
      <th>
        <span data-toggle="tooltip" data-placement="top" title="Amount of memory to use per executor process.">Memory/Executor</span>
      </th>
      <th>
        <span data-toggle="tooltip" data-placement="top" title="Number of cores to use for the executor process">Cores/Executor</span>
      </th>
      <th>
        <span data-toggle="tooltip" data-placement="top" title="Submitted time of this application.">Submitted Time</span>
      </th>
      <th>
        <span data-toggle="tooltip" data-placement="top" title="The Spark user of this application">Spark User</span>
      </th>
      <th>
        <span data-toggle="tooltip" data-placement="top" title="Current this application state">State</span>
      </th>
      <th>
        <span data-toggle="tooltip" data-placement="top" title="The duration time of this application.">Duration</span>
      </th>
  </thead>
  <tbody>
  </tbody>
</table>
`

const completedAppTemplate = `
<table id="completed-app-table" class="table table-striped compact">
  <thead>
    <tr>
      <th>
        <span data-toggle="tooltip" data-placement="top" title="Spark version of this application.">Version</span>
      </th>
      <th>
        <span data-toggle="tooltip" data-placement="top" title="ID of this application.">App ID</span>
      </th>
      <th>
        <span data-toggle="tooltip" data-placement="top" title="Name of this application.">App Name</span>
      </th>
      <th>
        <span data-toggle="tooltip" data-placement="top" title="Started time of this application.">Started</span>
      </th>
      <th>
        <span data-toggle="tooltip" data-placement="top" title="The completed time of this application.">Completed</span>
      </th>
      <th>
        <span data-toggle="tooltip" data-placement="top" title="The duration time of this application.">Duration</span>
      </th>
      <th>
        <span data-toggle="tooltip" data-placement="top" title="The Spark user of this application">Spark User</span>
      </th>
      <th>
        <span data-toggle="tooltip" data-placement="top" title="The timestamp of the last updating on this application">Last Updated</span>
      </th>
      <th>
        <span data-toggle="tooltip" data-placement="top" title="Download the event log for this application">Event Log</span>
      </th>
  </thead>
  <tbody>
  </tbody>
</table>
`

function renderRunningApp(data) {
  let element = $("#running-app-table")
  if (data.applications.length <= 0) {
    element.text("No running applications found!")
    return
  }

  // render bodiless table (only has header)
  const table = $(Mustache.render(runningAppTemplate, data));
  element.html(table);

  let columns = [
    {
      name: "version",
      data: "appSparkVersion"
    },
    {
      name: "appId",
      data: "appId",
      render: (id, type, row) => {
        if (type === "display") {
          return `<span title="${id}"><a href="${row.attemptUrl}">${id}</a></span>`
        }
        return id
      }
    },
    {
      name: "appName",
      data: "appName",
    },
    {
      name: "cores",
      data: "coresGranted",
      render: (cores, type, row) => cores ?? ""
    },
    {
      name: "executorMemory",
      data: "memoryPerExecutorMB",
      render: (mem, type, row) => mem ? `${mem} MB` : ""
    },
    {
      name: "executorCores",
      data: "coresPerExecutor",
      render: (cores, type, row) => cores ?? ""
    },
    {
      name: "submittedTime",
      data: "startTime",
    },
    {
      name: "user",
      data: "sparkUser"
    },
    {
      name: "state",
      render: (_, type, row) => row["completed"] ? "COMPLETED" : "RUNNING"
    },
    {
      name: "duration",
      data: "duration",
      searchable: false,
      render: (duration, type, row) => {
        if (type === "display") {
          return `<span title="${duration}">${formatDuration(duration)}</span>`
        }
        return duration
      }
    },
  ]
  if (!data.hasMultipleAttempts) {
    columns = columns.filter(c => c.name !== "attemptId")
  }

  let conf = {
    data: data.applications,
    columns: columns,
    order: [[columns.findIndex(c => c.name === "submittedTime"), "desc"]],
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

  table.DataTable(conf);
  element.find('[data-toggle="tooltip"]').tooltip();
  $("#running-app-title").text(`Running Applications (${data.applications.length})`)
}

function renderCompletedApp(data) {
  let element = $("#completed-app-table")
  if (data.applications.length <= 0) {
    element.text("No completed applications found!")
    return
  }

  // render bodiless table (only has header)
  const table = $(Mustache.render(completedAppTemplate, data));
  element.html(table);

  let columns = [
    {
      name: "version",
      data: "appSparkVersion"
    },
    {
      name: "appId",
      data: "appId",
      render: (id, type, row) => {
        if (type === "display") {
          return `<span title="${id}"><a href="${row.attemptUrl}">${id}</a></span>`
        }
        return id
      }
    },
    {
      name: "appName",
      data: "appName"
    },
    {
      name: "attemptId",
      data: "attemptId",
      render: (attemptId, type, row) => {
        if (type === "display") {
          return (attemptId ? `<a href="${row.attemptUrl}">${attemptId}</a>` : "")
        }
        return attemptId
      }
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
      render: (duration, type, row) => {
        if (type === "display") {
          return `<span title="${duration}">${formatDuration(duration)}</span>`
        }
        return duration
      }
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

  let conf = {
    data: data.applications,
    columns: columns,
    order: [[columns.findIndex(c => c.name === "completed"), "desc"]],
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

  table.DataTable(conf);
  element.find('[data-toggle="tooltip"]').tooltip();
  $("#completed-app-title").text(`Completed Applications (${data.applications.length})`)
}

function flatMapAttempts(app) {
  let {attempts, ...rest} = app

  return attempts.map((attempt) => {
      const attemptPart = attempt["attemptId"] ? attempt["attemptId"] + "/" : ""
      const logUrl = `${uiRoot}/api/v1/applications/${app.id}/${attemptPart}logs`
      const attemptUrl = attempt["completed"] ?
        `${uiRoot}/history/${app.id}/${attemptPart}jobs/` :
        `${uiRoot}/proxy/${app.id}/${attemptPart}jobs/`

      let result = {
        ...rest,
        ...attempt,

        appId: app.id,
        appName: app.name,
        attemptUrl: attemptUrl,
        log: logUrl,
      }

      if (!result["startTime"]) result["startTime"] = formatTimeMillis(attempt["startTimeEpoch"])
      if (!result["endTime"]) result["endTime"] = formatTimeMillis(attempt["endTimeEpoch"])
      if (!result["lastUpdated"]) result["lastUpdated"] = formatTimeMillis(attempt["lastUpdatedEpoch"])

      return result
    }
  )
}

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

  renderRunningApp({
    applications: runningApps,
    hasMultipleAttempts: hasMultipleAttempts,
  });

  renderCompletedApp({
    applications: completedApps,
    hasMultipleAttempts: hasMultipleAttempts,
  })
});
