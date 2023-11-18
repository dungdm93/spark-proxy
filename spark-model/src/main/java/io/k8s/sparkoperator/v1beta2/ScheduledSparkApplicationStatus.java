
package io.k8s.sparkoperator.v1beta2;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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
    "lastRun",
    "lastRunName",
    "nextRun",
    "pastFailedRunNames",
    "pastSuccessfulRunNames",
    "reason",
    "scheduleState"
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
public class ScheduledSparkApplicationStatus implements KubernetesResource
{

    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("lastRun")
    private String lastRun;
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("lastRunName")
    private String lastRunName;
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("nextRun")
    private String nextRun;
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("pastFailedRunNames")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @Valid
    private List<String> pastFailedRunNames = new ArrayList<String>();
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("pastSuccessfulRunNames")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @Valid
    private List<String> pastSuccessfulRunNames = new ArrayList<String>();
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("reason")
    private String reason;
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("scheduleState")
    private String scheduleState;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ScheduledSparkApplicationStatus() {
    }

    public ScheduledSparkApplicationStatus(String lastRun, String lastRunName, String nextRun, List<String> pastFailedRunNames, List<String> pastSuccessfulRunNames, String reason, String scheduleState) {
        super();
        this.lastRun = lastRun;
        this.lastRunName = lastRunName;
        this.nextRun = nextRun;
        this.pastFailedRunNames = pastFailedRunNames;
        this.pastSuccessfulRunNames = pastSuccessfulRunNames;
        this.reason = reason;
        this.scheduleState = scheduleState;
    }

    @JsonProperty("lastRun")
    public String getLastRun() {
        return lastRun;
    }

    @JsonProperty("lastRun")
    public void setLastRun(String lastRun) {
        this.lastRun = lastRun;
    }

    @JsonProperty("lastRunName")
    public String getLastRunName() {
        return lastRunName;
    }

    @JsonProperty("lastRunName")
    public void setLastRunName(String lastRunName) {
        this.lastRunName = lastRunName;
    }

    @JsonProperty("nextRun")
    public String getNextRun() {
        return nextRun;
    }

    @JsonProperty("nextRun")
    public void setNextRun(String nextRun) {
        this.nextRun = nextRun;
    }

    @JsonProperty("pastFailedRunNames")
    public List<String> getPastFailedRunNames() {
        return pastFailedRunNames;
    }

    @JsonProperty("pastFailedRunNames")
    public void setPastFailedRunNames(List<String> pastFailedRunNames) {
        this.pastFailedRunNames = pastFailedRunNames;
    }

    @JsonProperty("pastSuccessfulRunNames")
    public List<String> getPastSuccessfulRunNames() {
        return pastSuccessfulRunNames;
    }

    @JsonProperty("pastSuccessfulRunNames")
    public void setPastSuccessfulRunNames(List<String> pastSuccessfulRunNames) {
        this.pastSuccessfulRunNames = pastSuccessfulRunNames;
    }

    @JsonProperty("reason")
    public String getReason() {
        return reason;
    }

    @JsonProperty("reason")
    public void setReason(String reason) {
        this.reason = reason;
    }

    @JsonProperty("scheduleState")
    public String getScheduleState() {
        return scheduleState;
    }

    @JsonProperty("scheduleState")
    public void setScheduleState(String scheduleState) {
        this.scheduleState = scheduleState;
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
