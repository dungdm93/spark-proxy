
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
    "applicationState",
    "driverInfo",
    "executionAttempts",
    "executorState",
    "lastSubmissionAttemptTime",
    "sparkApplicationId",
    "submissionAttempts",
    "submissionID",
    "terminationTime"
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
public class SparkApplicationStatus implements KubernetesResource
{

    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("applicationState")
    @Valid
    private ApplicationState applicationState;
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("driverInfo")
    @Valid
    private DriverInfo driverInfo;
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("executionAttempts")
    private Integer executionAttempts;
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("executorState")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @Valid
    private Map<String, String> executorState = new LinkedHashMap<String, String>();
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("lastSubmissionAttemptTime")
    private java.lang.String lastSubmissionAttemptTime;
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("sparkApplicationId")
    private java.lang.String sparkApplicationId;
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("submissionAttempts")
    private Integer submissionAttempts;
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("submissionID")
    private java.lang.String submissionID;
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("terminationTime")
    private java.lang.String terminationTime;
    @JsonIgnore
    @Valid
    private Map<java.lang.String, Object> additionalProperties = new LinkedHashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public SparkApplicationStatus() {
    }

    public SparkApplicationStatus(ApplicationState applicationState, DriverInfo driverInfo, Integer executionAttempts, Map<String, String> executorState, java.lang.String lastSubmissionAttemptTime, java.lang.String sparkApplicationId, Integer submissionAttempts, java.lang.String submissionID, java.lang.String terminationTime) {
        super();
        this.applicationState = applicationState;
        this.driverInfo = driverInfo;
        this.executionAttempts = executionAttempts;
        this.executorState = executorState;
        this.lastSubmissionAttemptTime = lastSubmissionAttemptTime;
        this.sparkApplicationId = sparkApplicationId;
        this.submissionAttempts = submissionAttempts;
        this.submissionID = submissionID;
        this.terminationTime = terminationTime;
    }

    @JsonProperty("applicationState")
    public ApplicationState getApplicationState() {
        return applicationState;
    }

    @JsonProperty("applicationState")
    public void setApplicationState(ApplicationState applicationState) {
        this.applicationState = applicationState;
    }

    @JsonProperty("driverInfo")
    public DriverInfo getDriverInfo() {
        return driverInfo;
    }

    @JsonProperty("driverInfo")
    public void setDriverInfo(DriverInfo driverInfo) {
        this.driverInfo = driverInfo;
    }

    @JsonProperty("executionAttempts")
    public Integer getExecutionAttempts() {
        return executionAttempts;
    }

    @JsonProperty("executionAttempts")
    public void setExecutionAttempts(Integer executionAttempts) {
        this.executionAttempts = executionAttempts;
    }

    @JsonProperty("executorState")
    public Map<String, String> getExecutorState() {
        return executorState;
    }

    @JsonProperty("executorState")
    public void setExecutorState(Map<String, String> executorState) {
        this.executorState = executorState;
    }

    @JsonProperty("lastSubmissionAttemptTime")
    public java.lang.String getLastSubmissionAttemptTime() {
        return lastSubmissionAttemptTime;
    }

    @JsonProperty("lastSubmissionAttemptTime")
    public void setLastSubmissionAttemptTime(java.lang.String lastSubmissionAttemptTime) {
        this.lastSubmissionAttemptTime = lastSubmissionAttemptTime;
    }

    @JsonProperty("sparkApplicationId")
    public java.lang.String getSparkApplicationId() {
        return sparkApplicationId;
    }

    @JsonProperty("sparkApplicationId")
    public void setSparkApplicationId(java.lang.String sparkApplicationId) {
        this.sparkApplicationId = sparkApplicationId;
    }

    @JsonProperty("submissionAttempts")
    public Integer getSubmissionAttempts() {
        return submissionAttempts;
    }

    @JsonProperty("submissionAttempts")
    public void setSubmissionAttempts(Integer submissionAttempts) {
        this.submissionAttempts = submissionAttempts;
    }

    @JsonProperty("submissionID")
    public java.lang.String getSubmissionID() {
        return submissionID;
    }

    @JsonProperty("submissionID")
    public void setSubmissionID(java.lang.String submissionID) {
        this.submissionID = submissionID;
    }

    @JsonProperty("terminationTime")
    public java.lang.String getTerminationTime() {
        return terminationTime;
    }

    @JsonProperty("terminationTime")
    public void setTerminationTime(java.lang.String terminationTime) {
        this.terminationTime = terminationTime;
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
