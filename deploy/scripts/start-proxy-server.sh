#!/usr/bin/env bash

# Starts the proxy server on the machine this script is executed on.
#
# Usage: start-proxy-server.sh
#
# Use the SPARK_HISTORY_OPTS environment variable to set proxy server configuration.
#

if [ -z "${SPARK_HOME}" ]; then
  export SPARK_HOME="$(cd "`dirname "$0"`"/..; pwd)"
fi

# NOTE: This exact class name is matched downstream by SparkSubmit.
# Any changes need to be reflected there.
CLASS="org.apache.spark.deploy.history.ProxyServer"

if [[ "$@" = *--help ]] || [[ "$@" = *-h ]]; then
  echo "Usage: ./sbin/start-proxy-server.sh [options]"
  pattern="Usage:"
  pattern+="\|Using Spark's default log4j profile:"
  pattern+="\|Started daemon with process name"
  pattern+="\|Registered signal handler for"

  "${SPARK_HOME}/bin/spark-class" $CLASS --help 2>&1 | grep -v "$pattern" 1>&2
  exit 1
fi

. "${SPARK_HOME}/sbin/spark-config.sh"
. "${SPARK_HOME}/bin/load-spark-env.sh"

exec "${SPARK_HOME}/sbin/spark-daemon.sh" start $CLASS 1 "$@"
