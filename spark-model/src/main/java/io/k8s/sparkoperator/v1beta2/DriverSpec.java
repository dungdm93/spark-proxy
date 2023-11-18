
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
import io.fabric8.kubernetes.api.model.Affinity;
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.EnvFromSource;
import io.fabric8.kubernetes.api.model.HostAlias;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.Lifecycle;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodDNSConfig;
import io.fabric8.kubernetes.api.model.PodSecurityContext;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.SecurityContext;
import io.fabric8.kubernetes.api.model.Toleration;
import io.fabric8.kubernetes.api.model.Volume;
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
    "affinity",
    "annotations",
    "configMaps",
    "coreLimit",
    "coreRequest",
    "cores",
    "dnsConfig",
    "env",
    "envFrom",
    "envSecretKeyRefs",
    "envVars",
    "gpu",
    "hostAliases",
    "hostNetwork",
    "image",
    "initContainers",
    "javaOptions",
    "kubernetesMaster",
    "labels",
    "lifecycle",
    "memory",
    "memoryOverhead",
    "nodeSelector",
    "podName",
    "podSecurityContext",
    "ports",
    "schedulerName",
    "secrets",
    "securityContext",
    "serviceAccount",
    "serviceAnnotations",
    "shareProcessNamespace",
    "sidecars",
    "terminationGracePeriodSeconds",
    "tolerations",
    "volumeMounts"
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
    @BuildableReference(io.fabric8.kubernetes.api.model.Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.VolumeMount.class)
})
@Generated("jsonschema2pojo")
public class DriverSpec implements KubernetesResource
{

    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("affinity")
    private Affinity affinity;
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("annotations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @Valid
    private Map<String, String> annotations = new LinkedHashMap<String, String>();
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("configMaps")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @Valid
    private List<NamePath> configMaps = new ArrayList<NamePath>();
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("coreLimit")
    private String coreLimit;
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("coreRequest")
    private String coreRequest;
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("cores")
    private Integer cores;
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("dnsConfig")
    private PodDNSConfig dnsConfig;
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("env")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @Valid
    private List<io.fabric8.kubernetes.api.model.EnvVar> env = new ArrayList<io.fabric8.kubernetes.api.model.EnvVar>();
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("envFrom")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @Valid
    private List<EnvFromSource> envFrom = new ArrayList<EnvFromSource>();
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("envSecretKeyRefs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @Valid
    private Map<String, NameKey> envSecretKeyRefs = new LinkedHashMap<String, NameKey>();
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("envVars")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @Valid
    private Map<String, String> envVars = new LinkedHashMap<String, String>();
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("gpu")
    @Valid
    private GPUSpec gpu;
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("hostAliases")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @Valid
    private List<HostAlias> hostAliases = new ArrayList<HostAlias>();
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("hostNetwork")
    private Boolean hostNetwork;
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("image")
    private String image;
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("initContainers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @Valid
    private List<io.fabric8.kubernetes.api.model.Container> initContainers = new ArrayList<io.fabric8.kubernetes.api.model.Container>();
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("javaOptions")
    private String javaOptions;
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("kubernetesMaster")
    private String kubernetesMaster;
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("labels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @Valid
    private Map<String, String> labels = new LinkedHashMap<String, String>();
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("lifecycle")
    private Lifecycle lifecycle;
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("memory")
    private String memory;
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("memoryOverhead")
    private String memoryOverhead;
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("nodeSelector")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @Valid
    private Map<String, String> nodeSelector = new LinkedHashMap<String, String>();
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
    @JsonProperty("podSecurityContext")
    private PodSecurityContext podSecurityContext;
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("ports")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @Valid
    private List<Port> ports = new ArrayList<Port>();
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("schedulerName")
    private String schedulerName;
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("secrets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @Valid
    private List<SecretInfo> secrets = new ArrayList<SecretInfo>();
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("securityContext")
    private SecurityContext securityContext;
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("serviceAccount")
    private String serviceAccount;
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
    @JsonProperty("shareProcessNamespace")
    private Boolean shareProcessNamespace;
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("sidecars")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @Valid
    private List<io.fabric8.kubernetes.api.model.Container> sidecars = new ArrayList<io.fabric8.kubernetes.api.model.Container>();
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("terminationGracePeriodSeconds")
    private Long terminationGracePeriodSeconds;
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("tolerations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @Valid
    private List<Toleration> tolerations = new ArrayList<Toleration>();
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("volumeMounts")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @Valid
    private List<io.fabric8.kubernetes.api.model.VolumeMount> volumeMounts = new ArrayList<io.fabric8.kubernetes.api.model.VolumeMount>();
    @JsonIgnore
    @Valid
    private Map<java.lang.String, Object> additionalProperties = new LinkedHashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public DriverSpec() {
    }

    public DriverSpec(Affinity affinity, Map<String, String> annotations, List<NamePath> configMaps, String coreLimit, String coreRequest, Integer cores, PodDNSConfig dnsConfig, List<io.fabric8.kubernetes.api.model.EnvVar> env, List<EnvFromSource> envFrom, Map<String, NameKey> envSecretKeyRefs, Map<String, String> envVars, GPUSpec gpu, List<HostAlias> hostAliases, Boolean hostNetwork, String image, List<io.fabric8.kubernetes.api.model.Container> initContainers, String javaOptions, String kubernetesMaster, Map<String, String> labels, Lifecycle lifecycle, String memory, String memoryOverhead, Map<String, String> nodeSelector, String podName, PodSecurityContext podSecurityContext, List<Port> ports, String schedulerName, List<SecretInfo> secrets, SecurityContext securityContext, String serviceAccount, Map<String, String> serviceAnnotations, Boolean shareProcessNamespace, List<io.fabric8.kubernetes.api.model.Container> sidecars, Long terminationGracePeriodSeconds, List<Toleration> tolerations, List<io.fabric8.kubernetes.api.model.VolumeMount> volumeMounts) {
        super();
        this.affinity = affinity;
        this.annotations = annotations;
        this.configMaps = configMaps;
        this.coreLimit = coreLimit;
        this.coreRequest = coreRequest;
        this.cores = cores;
        this.dnsConfig = dnsConfig;
        this.env = env;
        this.envFrom = envFrom;
        this.envSecretKeyRefs = envSecretKeyRefs;
        this.envVars = envVars;
        this.gpu = gpu;
        this.hostAliases = hostAliases;
        this.hostNetwork = hostNetwork;
        this.image = image;
        this.initContainers = initContainers;
        this.javaOptions = javaOptions;
        this.kubernetesMaster = kubernetesMaster;
        this.labels = labels;
        this.lifecycle = lifecycle;
        this.memory = memory;
        this.memoryOverhead = memoryOverhead;
        this.nodeSelector = nodeSelector;
        this.podName = podName;
        this.podSecurityContext = podSecurityContext;
        this.ports = ports;
        this.schedulerName = schedulerName;
        this.secrets = secrets;
        this.securityContext = securityContext;
        this.serviceAccount = serviceAccount;
        this.serviceAnnotations = serviceAnnotations;
        this.shareProcessNamespace = shareProcessNamespace;
        this.sidecars = sidecars;
        this.terminationGracePeriodSeconds = terminationGracePeriodSeconds;
        this.tolerations = tolerations;
        this.volumeMounts = volumeMounts;
    }

    @JsonProperty("affinity")
    public Affinity getAffinity() {
        return affinity;
    }

    @JsonProperty("affinity")
    public void setAffinity(Affinity affinity) {
        this.affinity = affinity;
    }

    @JsonProperty("annotations")
    public Map<String, String> getAnnotations() {
        return annotations;
    }

    @JsonProperty("annotations")
    public void setAnnotations(Map<String, String> annotations) {
        this.annotations = annotations;
    }

    @JsonProperty("configMaps")
    public List<NamePath> getConfigMaps() {
        return configMaps;
    }

    @JsonProperty("configMaps")
    public void setConfigMaps(List<NamePath> configMaps) {
        this.configMaps = configMaps;
    }

    @JsonProperty("coreLimit")
    public String getCoreLimit() {
        return coreLimit;
    }

    @JsonProperty("coreLimit")
    public void setCoreLimit(String coreLimit) {
        this.coreLimit = coreLimit;
    }

    @JsonProperty("coreRequest")
    public String getCoreRequest() {
        return coreRequest;
    }

    @JsonProperty("coreRequest")
    public void setCoreRequest(String coreRequest) {
        this.coreRequest = coreRequest;
    }

    @JsonProperty("cores")
    public Integer getCores() {
        return cores;
    }

    @JsonProperty("cores")
    public void setCores(Integer cores) {
        this.cores = cores;
    }

    @JsonProperty("dnsConfig")
    public PodDNSConfig getDnsConfig() {
        return dnsConfig;
    }

    @JsonProperty("dnsConfig")
    public void setDnsConfig(PodDNSConfig dnsConfig) {
        this.dnsConfig = dnsConfig;
    }

    @JsonProperty("env")
    public List<io.fabric8.kubernetes.api.model.EnvVar> getEnv() {
        return env;
    }

    @JsonProperty("env")
    public void setEnv(List<io.fabric8.kubernetes.api.model.EnvVar> env) {
        this.env = env;
    }

    @JsonProperty("envFrom")
    public List<EnvFromSource> getEnvFrom() {
        return envFrom;
    }

    @JsonProperty("envFrom")
    public void setEnvFrom(List<EnvFromSource> envFrom) {
        this.envFrom = envFrom;
    }

    @JsonProperty("envSecretKeyRefs")
    public Map<String, NameKey> getEnvSecretKeyRefs() {
        return envSecretKeyRefs;
    }

    @JsonProperty("envSecretKeyRefs")
    public void setEnvSecretKeyRefs(Map<String, NameKey> envSecretKeyRefs) {
        this.envSecretKeyRefs = envSecretKeyRefs;
    }

    @JsonProperty("envVars")
    public Map<String, String> getEnvVars() {
        return envVars;
    }

    @JsonProperty("envVars")
    public void setEnvVars(Map<String, String> envVars) {
        this.envVars = envVars;
    }

    @JsonProperty("gpu")
    public GPUSpec getGpu() {
        return gpu;
    }

    @JsonProperty("gpu")
    public void setGpu(GPUSpec gpu) {
        this.gpu = gpu;
    }

    @JsonProperty("hostAliases")
    public List<HostAlias> getHostAliases() {
        return hostAliases;
    }

    @JsonProperty("hostAliases")
    public void setHostAliases(List<HostAlias> hostAliases) {
        this.hostAliases = hostAliases;
    }

    @JsonProperty("hostNetwork")
    public Boolean getHostNetwork() {
        return hostNetwork;
    }

    @JsonProperty("hostNetwork")
    public void setHostNetwork(Boolean hostNetwork) {
        this.hostNetwork = hostNetwork;
    }

    @JsonProperty("image")
    public String getImage() {
        return image;
    }

    @JsonProperty("image")
    public void setImage(String image) {
        this.image = image;
    }

    @JsonProperty("initContainers")
    public List<io.fabric8.kubernetes.api.model.Container> getInitContainers() {
        return initContainers;
    }

    @JsonProperty("initContainers")
    public void setInitContainers(List<io.fabric8.kubernetes.api.model.Container> initContainers) {
        this.initContainers = initContainers;
    }

    @JsonProperty("javaOptions")
    public String getJavaOptions() {
        return javaOptions;
    }

    @JsonProperty("javaOptions")
    public void setJavaOptions(String javaOptions) {
        this.javaOptions = javaOptions;
    }

    @JsonProperty("kubernetesMaster")
    public String getKubernetesMaster() {
        return kubernetesMaster;
    }

    @JsonProperty("kubernetesMaster")
    public void setKubernetesMaster(String kubernetesMaster) {
        this.kubernetesMaster = kubernetesMaster;
    }

    @JsonProperty("labels")
    public Map<String, String> getLabels() {
        return labels;
    }

    @JsonProperty("labels")
    public void setLabels(Map<String, String> labels) {
        this.labels = labels;
    }

    @JsonProperty("lifecycle")
    public Lifecycle getLifecycle() {
        return lifecycle;
    }

    @JsonProperty("lifecycle")
    public void setLifecycle(Lifecycle lifecycle) {
        this.lifecycle = lifecycle;
    }

    @JsonProperty("memory")
    public String getMemory() {
        return memory;
    }

    @JsonProperty("memory")
    public void setMemory(String memory) {
        this.memory = memory;
    }

    @JsonProperty("memoryOverhead")
    public String getMemoryOverhead() {
        return memoryOverhead;
    }

    @JsonProperty("memoryOverhead")
    public void setMemoryOverhead(String memoryOverhead) {
        this.memoryOverhead = memoryOverhead;
    }

    @JsonProperty("nodeSelector")
    public Map<String, String> getNodeSelector() {
        return nodeSelector;
    }

    @JsonProperty("nodeSelector")
    public void setNodeSelector(Map<String, String> nodeSelector) {
        this.nodeSelector = nodeSelector;
    }

    @JsonProperty("podName")
    public String getPodName() {
        return podName;
    }

    @JsonProperty("podName")
    public void setPodName(String podName) {
        this.podName = podName;
    }

    @JsonProperty("podSecurityContext")
    public PodSecurityContext getPodSecurityContext() {
        return podSecurityContext;
    }

    @JsonProperty("podSecurityContext")
    public void setPodSecurityContext(PodSecurityContext podSecurityContext) {
        this.podSecurityContext = podSecurityContext;
    }

    @JsonProperty("ports")
    public List<Port> getPorts() {
        return ports;
    }

    @JsonProperty("ports")
    public void setPorts(List<Port> ports) {
        this.ports = ports;
    }

    @JsonProperty("schedulerName")
    public String getSchedulerName() {
        return schedulerName;
    }

    @JsonProperty("schedulerName")
    public void setSchedulerName(String schedulerName) {
        this.schedulerName = schedulerName;
    }

    @JsonProperty("secrets")
    public List<SecretInfo> getSecrets() {
        return secrets;
    }

    @JsonProperty("secrets")
    public void setSecrets(List<SecretInfo> secrets) {
        this.secrets = secrets;
    }

    @JsonProperty("securityContext")
    public SecurityContext getSecurityContext() {
        return securityContext;
    }

    @JsonProperty("securityContext")
    public void setSecurityContext(SecurityContext securityContext) {
        this.securityContext = securityContext;
    }

    @JsonProperty("serviceAccount")
    public String getServiceAccount() {
        return serviceAccount;
    }

    @JsonProperty("serviceAccount")
    public void setServiceAccount(String serviceAccount) {
        this.serviceAccount = serviceAccount;
    }

    @JsonProperty("serviceAnnotations")
    public Map<String, String> getServiceAnnotations() {
        return serviceAnnotations;
    }

    @JsonProperty("serviceAnnotations")
    public void setServiceAnnotations(Map<String, String> serviceAnnotations) {
        this.serviceAnnotations = serviceAnnotations;
    }

    @JsonProperty("shareProcessNamespace")
    public Boolean getShareProcessNamespace() {
        return shareProcessNamespace;
    }

    @JsonProperty("shareProcessNamespace")
    public void setShareProcessNamespace(Boolean shareProcessNamespace) {
        this.shareProcessNamespace = shareProcessNamespace;
    }

    @JsonProperty("sidecars")
    public List<io.fabric8.kubernetes.api.model.Container> getSidecars() {
        return sidecars;
    }

    @JsonProperty("sidecars")
    public void setSidecars(List<io.fabric8.kubernetes.api.model.Container> sidecars) {
        this.sidecars = sidecars;
    }

    @JsonProperty("terminationGracePeriodSeconds")
    public Long getTerminationGracePeriodSeconds() {
        return terminationGracePeriodSeconds;
    }

    @JsonProperty("terminationGracePeriodSeconds")
    public void setTerminationGracePeriodSeconds(Long terminationGracePeriodSeconds) {
        this.terminationGracePeriodSeconds = terminationGracePeriodSeconds;
    }

    @JsonProperty("tolerations")
    public List<Toleration> getTolerations() {
        return tolerations;
    }

    @JsonProperty("tolerations")
    public void setTolerations(List<Toleration> tolerations) {
        this.tolerations = tolerations;
    }

    @JsonProperty("volumeMounts")
    public List<io.fabric8.kubernetes.api.model.VolumeMount> getVolumeMounts() {
        return volumeMounts;
    }

    @JsonProperty("volumeMounts")
    public void setVolumeMounts(List<io.fabric8.kubernetes.api.model.VolumeMount> volumeMounts) {
        this.volumeMounts = volumeMounts;
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
