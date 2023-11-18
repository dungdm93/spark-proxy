
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
    "excludePackages",
    "files",
    "jars",
    "packages",
    "pyFiles",
    "repositories"
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
public class Dependencies implements KubernetesResource
{

    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("excludePackages")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @Valid
    private List<String> excludePackages = new ArrayList<String>();
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("files")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @Valid
    private List<String> files = new ArrayList<String>();
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("jars")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @Valid
    private List<String> jars = new ArrayList<String>();
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("packages")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @Valid
    private List<String> packages = new ArrayList<String>();
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("pyFiles")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @Valid
    private List<String> pyFiles = new ArrayList<String>();
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("repositories")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @Valid
    private List<String> repositories = new ArrayList<String>();
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Dependencies() {
    }

    public Dependencies(List<String> excludePackages, List<String> files, List<String> jars, List<String> packages, List<String> pyFiles, List<String> repositories) {
        super();
        this.excludePackages = excludePackages;
        this.files = files;
        this.jars = jars;
        this.packages = packages;
        this.pyFiles = pyFiles;
        this.repositories = repositories;
    }

    @JsonProperty("excludePackages")
    public List<String> getExcludePackages() {
        return excludePackages;
    }

    @JsonProperty("excludePackages")
    public void setExcludePackages(List<String> excludePackages) {
        this.excludePackages = excludePackages;
    }

    @JsonProperty("files")
    public List<String> getFiles() {
        return files;
    }

    @JsonProperty("files")
    public void setFiles(List<String> files) {
        this.files = files;
    }

    @JsonProperty("jars")
    public List<String> getJars() {
        return jars;
    }

    @JsonProperty("jars")
    public void setJars(List<String> jars) {
        this.jars = jars;
    }

    @JsonProperty("packages")
    public List<String> getPackages() {
        return packages;
    }

    @JsonProperty("packages")
    public void setPackages(List<String> packages) {
        this.packages = packages;
    }

    @JsonProperty("pyFiles")
    public List<String> getPyFiles() {
        return pyFiles;
    }

    @JsonProperty("pyFiles")
    public void setPyFiles(List<String> pyFiles) {
        this.pyFiles = pyFiles;
    }

    @JsonProperty("repositories")
    public List<String> getRepositories() {
        return repositories;
    }

    @JsonProperty("repositories")
    public void setRepositories(List<String> repositories) {
        this.repositories = repositories;
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
