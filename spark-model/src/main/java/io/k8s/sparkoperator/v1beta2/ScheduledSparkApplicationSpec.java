
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
    "concurrencyPolicy",
    "failedRunHistoryLimit",
    "schedule",
    "successfulRunHistoryLimit",
    "suspend",
    "template"
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
public class ScheduledSparkApplicationSpec implements KubernetesResource
{

    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("concurrencyPolicy")
    private String concurrencyPolicy;
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("failedRunHistoryLimit")
    private Integer failedRunHistoryLimit;
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("schedule")
    private String schedule;
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("successfulRunHistoryLimit")
    private Integer successfulRunHistoryLimit;
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("suspend")
    private Boolean suspend;
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("template")
    @Valid
    private SparkApplicationSpec template;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ScheduledSparkApplicationSpec() {
    }

    public ScheduledSparkApplicationSpec(String concurrencyPolicy, Integer failedRunHistoryLimit, String schedule, Integer successfulRunHistoryLimit, Boolean suspend, SparkApplicationSpec template) {
        super();
        this.concurrencyPolicy = concurrencyPolicy;
        this.failedRunHistoryLimit = failedRunHistoryLimit;
        this.schedule = schedule;
        this.successfulRunHistoryLimit = successfulRunHistoryLimit;
        this.suspend = suspend;
        this.template = template;
    }

    @JsonProperty("concurrencyPolicy")
    public String getConcurrencyPolicy() {
        return concurrencyPolicy;
    }

    @JsonProperty("concurrencyPolicy")
    public void setConcurrencyPolicy(String concurrencyPolicy) {
        this.concurrencyPolicy = concurrencyPolicy;
    }

    @JsonProperty("failedRunHistoryLimit")
    public Integer getFailedRunHistoryLimit() {
        return failedRunHistoryLimit;
    }

    @JsonProperty("failedRunHistoryLimit")
    public void setFailedRunHistoryLimit(Integer failedRunHistoryLimit) {
        this.failedRunHistoryLimit = failedRunHistoryLimit;
    }

    @JsonProperty("schedule")
    public String getSchedule() {
        return schedule;
    }

    @JsonProperty("schedule")
    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    @JsonProperty("successfulRunHistoryLimit")
    public Integer getSuccessfulRunHistoryLimit() {
        return successfulRunHistoryLimit;
    }

    @JsonProperty("successfulRunHistoryLimit")
    public void setSuccessfulRunHistoryLimit(Integer successfulRunHistoryLimit) {
        this.successfulRunHistoryLimit = successfulRunHistoryLimit;
    }

    @JsonProperty("suspend")
    public Boolean getSuspend() {
        return suspend;
    }

    @JsonProperty("suspend")
    public void setSuspend(Boolean suspend) {
        this.suspend = suspend;
    }

    @JsonProperty("template")
    public SparkApplicationSpec getTemplate() {
        return template;
    }

    @JsonProperty("template")
    public void setTemplate(SparkApplicationSpec template) {
        this.template = template;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
