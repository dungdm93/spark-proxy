
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
    "podName",
    "webUIAddress",
    "webUIIngressAddress",
    "webUIIngressName",
    "webUIPort",
    "webUIServiceName"
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
public class DriverInfo implements KubernetesResource
{

    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("podName")
    private String podName;
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("webUIAddress")
    private String webUIAddress;
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("webUIIngressAddress")
    private String webUIIngressAddress;
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("webUIIngressName")
    private String webUIIngressName;
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("webUIPort")
    private Integer webUIPort;
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("webUIServiceName")
    private String webUIServiceName;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public DriverInfo() {
    }

    public DriverInfo(String podName, String webUIAddress, String webUIIngressAddress, String webUIIngressName, Integer webUIPort, String webUIServiceName) {
        super();
        this.podName = podName;
        this.webUIAddress = webUIAddress;
        this.webUIIngressAddress = webUIIngressAddress;
        this.webUIIngressName = webUIIngressName;
        this.webUIPort = webUIPort;
        this.webUIServiceName = webUIServiceName;
    }

    @JsonProperty("podName")
    public String getPodName() {
        return podName;
    }

    @JsonProperty("podName")
    public void setPodName(String podName) {
        this.podName = podName;
    }

    @JsonProperty("webUIAddress")
    public String getWebUIAddress() {
        return webUIAddress;
    }

    @JsonProperty("webUIAddress")
    public void setWebUIAddress(String webUIAddress) {
        this.webUIAddress = webUIAddress;
    }

    @JsonProperty("webUIIngressAddress")
    public String getWebUIIngressAddress() {
        return webUIIngressAddress;
    }

    @JsonProperty("webUIIngressAddress")
    public void setWebUIIngressAddress(String webUIIngressAddress) {
        this.webUIIngressAddress = webUIIngressAddress;
    }

    @JsonProperty("webUIIngressName")
    public String getWebUIIngressName() {
        return webUIIngressName;
    }

    @JsonProperty("webUIIngressName")
    public void setWebUIIngressName(String webUIIngressName) {
        this.webUIIngressName = webUIIngressName;
    }

    @JsonProperty("webUIPort")
    public Integer getWebUIPort() {
        return webUIPort;
    }

    @JsonProperty("webUIPort")
    public void setWebUIPort(Integer webUIPort) {
        this.webUIPort = webUIPort;
    }

    @JsonProperty("webUIServiceName")
    public String getWebUIServiceName() {
        return webUIServiceName;
    }

    @JsonProperty("webUIServiceName")
    public void setWebUIServiceName(String webUIServiceName) {
        this.webUIServiceName = webUIServiceName;
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
