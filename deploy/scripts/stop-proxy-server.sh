#!/usr/bin/env bash

# Stops the proxy server on the machine this script is executed on.

if [ -z "${SPARK_HOME}" ]; then
  export SPARK_HOME="$(cd "`dirname "$0"`"/..; pwd)"
fi

"${SPARK_HOME}/sbin/spark-daemon.sh" stop org.apache.spark.deploy.history.ProxyServer 1
