
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
import io.fabric8.kubernetes.api.model.networking.v1.IngressTLS;
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
    "ingressAnnotations",
    "ingressTLS",
    "serviceAnnotations",
    "servicePort",
    "servicePortName",
    "serviceType"
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
public class SparkUIConfiguration implements KubernetesResource
{

    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("ingressAnnotations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @Valid
    private Map<String, String> ingressAnnotations = new LinkedHashMap<String, String>();
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("ingressTLS")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @Valid
    private List<IngressTLS> ingressTLS = new ArrayList<IngressTLS>();
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("serviceAnnotations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @Valid
    private Map<String, String> serviceAnnotations = new LinkedHashMap<String, String>();
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("servicePort")
    private Integer servicePort;
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("servicePortName")
    private String servicePortName;
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("serviceType")
    private String serviceType;
    @JsonIgnore
    @Valid
    private Map<java.lang.String, Object> additionalProperties = new LinkedHashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public SparkUIConfiguration() {
    }

    public SparkUIConfiguration(Map<String, String> ingressAnnotations, List<IngressTLS> ingressTLS, Map<String, String> serviceAnnotations, Integer servicePort, String servicePortName, String serviceType) {
        super();
        this.ingressAnnotations = ingressAnnotations;
        this.ingressTLS = ingressTLS;
        this.serviceAnnotations = serviceAnnotations;
        this.servicePort = servicePort;
        this.servicePortName = servicePortName;
        this.serviceType = serviceType;
    }

    @JsonProperty("ingressAnnotations")
    public Map<String, String> getIngressAnnotations() {
        return ingressAnnotations;
    }

    @JsonProperty("ingressAnnotations")
    public void setIngressAnnotations(Map<String, String> ingressAnnotations) {
        this.ingressAnnotations = ingressAnnotations;
    }

    @JsonProperty("ingressTLS")
    public List<IngressTLS> getIngressTLS() {
        return ingressTLS;
    }

    @JsonProperty("ingressTLS")
    public void setIngressTLS(List<IngressTLS> ingressTLS) {
        this.ingressTLS = ingressTLS;
    }

    @JsonProperty("serviceAnnotations")
    public Map<String, String> getServiceAnnotations() {
        return serviceAnnotations;
    }

    @JsonProperty("serviceAnnotations")
    public void setServiceAnnotations(Map<String, String> serviceAnnotations) {
        this.serviceAnnotations = serviceAnnotations;
    }

    @JsonProperty("servicePort")
    public Integer getServicePort() {
        return servicePort;
    }

    @JsonProperty("servicePort")
    public void setServicePort(Integer servicePort) {
        this.servicePort = servicePort;
    }

    @JsonProperty("servicePortName")
    public String getServicePortName() {
        return servicePortName;
    }

    @JsonProperty("servicePortName")
    public void setServicePortName(String servicePortName) {
        this.servicePortName = servicePortName;
    }

    @JsonProperty("serviceType")
    public String getServiceType() {
        return serviceType;
    }

    @JsonProperty("serviceType")
    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
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
