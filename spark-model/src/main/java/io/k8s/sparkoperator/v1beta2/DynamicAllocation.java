
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
    "enabled",
    "initialExecutors",
    "maxExecutors",
    "minExecutors",
    "shuffleTrackingTimeout"
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
public class DynamicAllocation implements KubernetesResource
{

    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("enabled")
    private Boolean enabled;
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("initialExecutors")
    private Integer initialExecutors;
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("maxExecutors")
    private Integer maxExecutors;
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("minExecutors")
    private Integer minExecutors;
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("shuffleTrackingTimeout")
    private Long shuffleTrackingTimeout;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public DynamicAllocation() {
    }

    public DynamicAllocation(Boolean enabled, Integer initialExecutors, Integer maxExecutors, Integer minExecutors, Long shuffleTrackingTimeout) {
        super();
        this.enabled = enabled;
        this.initialExecutors = initialExecutors;
        this.maxExecutors = maxExecutors;
        this.minExecutors = minExecutors;
        this.shuffleTrackingTimeout = shuffleTrackingTimeout;
    }

    @JsonProperty("enabled")
    public Boolean getEnabled() {
        return enabled;
    }

    @JsonProperty("enabled")
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    @JsonProperty("initialExecutors")
    public Integer getInitialExecutors() {
        return initialExecutors;
    }

    @JsonProperty("initialExecutors")
    public void setInitialExecutors(Integer initialExecutors) {
        this.initialExecutors = initialExecutors;
    }

    @JsonProperty("maxExecutors")
    public Integer getMaxExecutors() {
        return maxExecutors;
    }

    @JsonProperty("maxExecutors")
    public void setMaxExecutors(Integer maxExecutors) {
        this.maxExecutors = maxExecutors;
    }

    @JsonProperty("minExecutors")
    public Integer getMinExecutors() {
        return minExecutors;
    }

    @JsonProperty("minExecutors")
    public void setMinExecutors(Integer minExecutors) {
        this.minExecutors = minExecutors;
    }

    @JsonProperty("shuffleTrackingTimeout")
    public Long getShuffleTrackingTimeout() {
        return shuffleTrackingTimeout;
    }

    @JsonProperty("shuffleTrackingTimeout")
    public void setShuffleTrackingTimeout(Long shuffleTrackingTimeout) {
        this.shuffleTrackingTimeout = shuffleTrackingTimeout;
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
