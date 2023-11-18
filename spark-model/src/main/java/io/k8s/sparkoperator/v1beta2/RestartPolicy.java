
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
    "onFailureRetries",
    "onFailureRetryInterval",
    "onSubmissionFailureRetries",
    "onSubmissionFailureRetryInterval",
    "type"
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
public class RestartPolicy implements KubernetesResource
{

    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("onFailureRetries")
    private Integer onFailureRetries;
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("onFailureRetryInterval")
    private Long onFailureRetryInterval;
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("onSubmissionFailureRetries")
    private Integer onSubmissionFailureRetries;
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("onSubmissionFailureRetryInterval")
    private Long onSubmissionFailureRetryInterval;
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("type")
    private String type;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public RestartPolicy() {
    }

    public RestartPolicy(Integer onFailureRetries, Long onFailureRetryInterval, Integer onSubmissionFailureRetries, Long onSubmissionFailureRetryInterval, String type) {
        super();
        this.onFailureRetries = onFailureRetries;
        this.onFailureRetryInterval = onFailureRetryInterval;
        this.onSubmissionFailureRetries = onSubmissionFailureRetries;
        this.onSubmissionFailureRetryInterval = onSubmissionFailureRetryInterval;
        this.type = type;
    }

    @JsonProperty("onFailureRetries")
    public Integer getOnFailureRetries() {
        return onFailureRetries;
    }

    @JsonProperty("onFailureRetries")
    public void setOnFailureRetries(Integer onFailureRetries) {
        this.onFailureRetries = onFailureRetries;
    }

    @JsonProperty("onFailureRetryInterval")
    public Long getOnFailureRetryInterval() {
        return onFailureRetryInterval;
    }

    @JsonProperty("onFailureRetryInterval")
    public void setOnFailureRetryInterval(Long onFailureRetryInterval) {
        this.onFailureRetryInterval = onFailureRetryInterval;
    }

    @JsonProperty("onSubmissionFailureRetries")
    public Integer getOnSubmissionFailureRetries() {
        return onSubmissionFailureRetries;
    }

    @JsonProperty("onSubmissionFailureRetries")
    public void setOnSubmissionFailureRetries(Integer onSubmissionFailureRetries) {
        this.onSubmissionFailureRetries = onSubmissionFailureRetries;
    }

    @JsonProperty("onSubmissionFailureRetryInterval")
    public Long getOnSubmissionFailureRetryInterval() {
        return onSubmissionFailureRetryInterval;
    }

    @JsonProperty("onSubmissionFailureRetryInterval")
    public void setOnSubmissionFailureRetryInterval(Long onSubmissionFailureRetryInterval) {
        this.onSubmissionFailureRetryInterval = onSubmissionFailureRetryInterval;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
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
