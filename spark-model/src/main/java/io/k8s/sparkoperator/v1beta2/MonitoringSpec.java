
package io.k8s.sparkoperator.v1beta2;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
import javax.annotation.Nullable;
import javax.validation.Valid;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "exposeDriverMetrics",
    "exposeExecutorMetrics",
    "metricsProperties",
    "metricsPropertiesFile",
    "prometheus"
})
@ToString
@EqualsAndHashCode
@Setter
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("jsonschema2pojo")
public class MonitoringSpec implements KubernetesResource
{

    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("exposeDriverMetrics")
    private Boolean exposeDriverMetrics;
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("exposeExecutorMetrics")
    private Boolean exposeExecutorMetrics;
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("metricsProperties")
    private String metricsProperties;
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("metricsPropertiesFile")
    private String metricsPropertiesFile;
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("prometheus")
    @Valid
    private PrometheusSpec prometheus;
    @JsonIgnore
    @Valid
    private Map<java.lang.String, Object> additionalProperties = new LinkedHashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public MonitoringSpec() {
    }

    public MonitoringSpec(Boolean exposeDriverMetrics, Boolean exposeExecutorMetrics, String metricsProperties, String metricsPropertiesFile, PrometheusSpec prometheus) {
        super();
        this.exposeDriverMetrics = exposeDriverMetrics;
        this.exposeExecutorMetrics = exposeExecutorMetrics;
        this.metricsProperties = metricsProperties;
        this.metricsPropertiesFile = metricsPropertiesFile;
        this.prometheus = prometheus;
    }

    @JsonProperty("exposeDriverMetrics")
    public Boolean getExposeDriverMetrics() {
        return exposeDriverMetrics;
    }

    @JsonProperty("exposeDriverMetrics")
    public void setExposeDriverMetrics(Boolean exposeDriverMetrics) {
        this.exposeDriverMetrics = exposeDriverMetrics;
    }

    @JsonProperty("exposeExecutorMetrics")
    public Boolean getExposeExecutorMetrics() {
        return exposeExecutorMetrics;
    }

    @JsonProperty("exposeExecutorMetrics")
    public void setExposeExecutorMetrics(Boolean exposeExecutorMetrics) {
        this.exposeExecutorMetrics = exposeExecutorMetrics;
    }

    @JsonProperty("metricsProperties")
    public String getMetricsProperties() {
        return metricsProperties;
    }

    @JsonProperty("metricsProperties")
    public void setMetricsProperties(String metricsProperties) {
        this.metricsProperties = metricsProperties;
    }

    @JsonProperty("metricsPropertiesFile")
    public String getMetricsPropertiesFile() {
        return metricsPropertiesFile;
    }

    @JsonProperty("metricsPropertiesFile")
    public void setMetricsPropertiesFile(String metricsPropertiesFile) {
        this.metricsPropertiesFile = metricsPropertiesFile;
    }

    @JsonProperty("prometheus")
    public PrometheusSpec getPrometheus() {
        return prometheus;
    }

    @JsonProperty("prometheus")
    public void setPrometheus(PrometheusSpec prometheus) {
        this.prometheus = prometheus;
    }

    @JsonAnyGetter
    public Map<java.lang.String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(java.lang.String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
