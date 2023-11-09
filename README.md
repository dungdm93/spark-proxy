spark-proxy
===========

# Sync Spark Operator CRD

```bash
export VERSION="v1beta2-1.3.8-3.1.1"
curl -L "https://github.com/GoogleCloudPlatform/spark-on-k8s-operator/raw/${VERSION}/manifest/crds/sparkoperator.k8s.io_sparkapplications.yaml" \
     -o "src/main/resources/kubernetes/sparkoperator.k8s.io_sparkapplications.yaml"
curl -L "https://github.com/GoogleCloudPlatform/spark-on-k8s-operator/raw/${VERSION}/manifest/crds/sparkoperator.k8s.io_scheduledsparkapplications.yaml" \
     -o "src/main/resources/kubernetes/sparkoperator.k8s.io_scheduledsparkapplications.yaml"
```
