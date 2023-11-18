
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
    "arguments",
    "batchScheduler",
    "batchSchedulerOptions",
    "deps",
    "driver",
    "dynamicAllocation",
    "executor",
    "failureRetries",
    "hadoopConf",
    "hadoopConfigMap",
    "image",
    "imagePullPolicy",
    "imagePullSecrets",
    "mainApplicationFile",
    "mainClass",
    "memoryOverheadFactor",
    "mode",
    "monitoring",
    "nodeSelector",
    "proxyUser",
    "pythonVersion",
    "restartPolicy",
    "retryInterval",
    "sparkConf",
    "sparkConfigMap",
    "sparkUIOptions",
    "sparkVersion",
    "timeToLiveSeconds",
    "type",
    "volumes"
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
    @BuildableReference(io.fabric8.kubernetes.api.model.Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("jsonschema2pojo")
public class SparkApplicationSpec implements KubernetesResource
{

    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("arguments")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @Valid
    private List<java.lang.String> arguments = new ArrayList<java.lang.String>();
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("batchScheduler")
    private String batchScheduler;
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("batchSchedulerOptions")
    @Valid
    private BatchSchedulerConfiguration batchSchedulerOptions;
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("deps")
    @Valid
    private Dependencies deps;
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("driver")
    @Valid
    private DriverSpec driver;
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("dynamicAllocation")
    @Valid
    private DynamicAllocation dynamicAllocation;
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("executor")
    @Valid
    private ExecutorSpec executor;
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("failureRetries")
    private Integer failureRetries;
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("hadoopConf")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @Valid
    private Map<String, String> hadoopConf = new LinkedHashMap<String, String>();
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("hadoopConfigMap")
    private String hadoopConfigMap;
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
    @JsonProperty("imagePullPolicy")
    private String imagePullPolicy;
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("imagePullSecrets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @Valid
    private List<java.lang.String> imagePullSecrets = new ArrayList<java.lang.String>();
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("mainApplicationFile")
    private String mainApplicationFile;
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("mainClass")
    private String mainClass;
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("memoryOverheadFactor")
    private String memoryOverheadFactor;
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("mode")
    private java.lang.String mode;
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("monitoring")
    @Valid
    private MonitoringSpec monitoring;
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
    @JsonProperty("proxyUser")
    private String proxyUser;
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("pythonVersion")
    private String pythonVersion;
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("restartPolicy")
    @Valid
    private RestartPolicy restartPolicy;
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("retryInterval")
    private Long retryInterval;
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("sparkConf")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @Valid
    private Map<String, String> sparkConf = new LinkedHashMap<String, String>();
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("sparkConfigMap")
    private String sparkConfigMap;
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("sparkUIOptions")
    @Valid
    private SparkUIConfiguration sparkUIOptions;
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("sparkVersion")
    private java.lang.String sparkVersion;
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("timeToLiveSeconds")
    private Long timeToLiveSeconds;
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("type")
    private java.lang.String type;
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("volumes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @Valid
    private List<io.fabric8.kubernetes.api.model.Volume> volumes = new ArrayList<io.fabric8.kubernetes.api.model.Volume>();
    @JsonIgnore
    @Valid
    private Map<java.lang.String, Object> additionalProperties = new LinkedHashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public SparkApplicationSpec() {
    }

    public SparkApplicationSpec(List<java.lang.String> arguments, String batchScheduler, BatchSchedulerConfiguration batchSchedulerOptions, Dependencies deps, DriverSpec driver, DynamicAllocation dynamicAllocation, ExecutorSpec executor, Integer failureRetries, Map<String, String> hadoopConf, String hadoopConfigMap, String image, String imagePullPolicy, List<java.lang.String> imagePullSecrets, String mainApplicationFile, String mainClass, String memoryOverheadFactor, java.lang.String mode, MonitoringSpec monitoring, Map<String, String> nodeSelector, String proxyUser, String pythonVersion, RestartPolicy restartPolicy, Long retryInterval, Map<String, String> sparkConf, String sparkConfigMap, SparkUIConfiguration sparkUIOptions, java.lang.String sparkVersion, Long timeToLiveSeconds, java.lang.String type, List<io.fabric8.kubernetes.api.model.Volume> volumes) {
        super();
        this.arguments = arguments;
        this.batchScheduler = batchScheduler;
        this.batchSchedulerOptions = batchSchedulerOptions;
        this.deps = deps;
        this.driver = driver;
        this.dynamicAllocation = dynamicAllocation;
        this.executor = executor;
        this.failureRetries = failureRetries;
        this.hadoopConf = hadoopConf;
        this.hadoopConfigMap = hadoopConfigMap;
        this.image = image;
        this.imagePullPolicy = imagePullPolicy;
        this.imagePullSecrets = imagePullSecrets;
        this.mainApplicationFile = mainApplicationFile;
        this.mainClass = mainClass;
        this.memoryOverheadFactor = memoryOverheadFactor;
        this.mode = mode;
        this.monitoring = monitoring;
        this.nodeSelector = nodeSelector;
        this.proxyUser = proxyUser;
        this.pythonVersion = pythonVersion;
        this.restartPolicy = restartPolicy;
        this.retryInterval = retryInterval;
        this.sparkConf = sparkConf;
        this.sparkConfigMap = sparkConfigMap;
        this.sparkUIOptions = sparkUIOptions;
        this.sparkVersion = sparkVersion;
        this.timeToLiveSeconds = timeToLiveSeconds;
        this.type = type;
        this.volumes = volumes;
    }

    @JsonProperty("arguments")
    public List<java.lang.String> getArguments() {
        return arguments;
    }

    @JsonProperty("arguments")
    public void setArguments(List<java.lang.String> arguments) {
        this.arguments = arguments;
    }

    @JsonProperty("batchScheduler")
    public String getBatchScheduler() {
        return batchScheduler;
    }

    @JsonProperty("batchScheduler")
    public void setBatchScheduler(String batchScheduler) {
        this.batchScheduler = batchScheduler;
    }

    @JsonProperty("batchSchedulerOptions")
    public BatchSchedulerConfiguration getBatchSchedulerOptions() {
        return batchSchedulerOptions;
    }

    @JsonProperty("batchSchedulerOptions")
    public void setBatchSchedulerOptions(BatchSchedulerConfiguration batchSchedulerOptions) {
        this.batchSchedulerOptions = batchSchedulerOptions;
    }

    @JsonProperty("deps")
    public Dependencies getDeps() {
        return deps;
    }

    @JsonProperty("deps")
    public void setDeps(Dependencies deps) {
        this.deps = deps;
    }

    @JsonProperty("driver")
    public DriverSpec getDriver() {
        return driver;
    }

    @JsonProperty("driver")
    public void setDriver(DriverSpec driver) {
        this.driver = driver;
    }

    @JsonProperty("dynamicAllocation")
    public DynamicAllocation getDynamicAllocation() {
        return dynamicAllocation;
    }

    @JsonProperty("dynamicAllocation")
    public void setDynamicAllocation(DynamicAllocation dynamicAllocation) {
        this.dynamicAllocation = dynamicAllocation;
    }

    @JsonProperty("executor")
    public ExecutorSpec getExecutor() {
        return executor;
    }

    @JsonProperty("executor")
    public void setExecutor(ExecutorSpec executor) {
        this.executor = executor;
    }

    @JsonProperty("failureRetries")
    public Integer getFailureRetries() {
        return failureRetries;
    }

    @JsonProperty("failureRetries")
    public void setFailureRetries(Integer failureRetries) {
        this.failureRetries = failureRetries;
    }

    @JsonProperty("hadoopConf")
    public Map<String, String> getHadoopConf() {
        return hadoopConf;
    }

    @JsonProperty("hadoopConf")
    public void setHadoopConf(Map<String, String> hadoopConf) {
        this.hadoopConf = hadoopConf;
    }

    @JsonProperty("hadoopConfigMap")
    public String getHadoopConfigMap() {
        return hadoopConfigMap;
    }

    @JsonProperty("hadoopConfigMap")
    public void setHadoopConfigMap(String hadoopConfigMap) {
        this.hadoopConfigMap = hadoopConfigMap;
    }

    @JsonProperty("image")
    public String getImage() {
        return image;
    }

    @JsonProperty("image")
    public void setImage(String image) {
        this.image = image;
    }

    @JsonProperty("imagePullPolicy")
    public String getImagePullPolicy() {
        return imagePullPolicy;
    }

    @JsonProperty("imagePullPolicy")
    public void setImagePullPolicy(String imagePullPolicy) {
        this.imagePullPolicy = imagePullPolicy;
    }

    @JsonProperty("imagePullSecrets")
    public List<java.lang.String> getImagePullSecrets() {
        return imagePullSecrets;
    }

    @JsonProperty("imagePullSecrets")
    public void setImagePullSecrets(List<java.lang.String> imagePullSecrets) {
        this.imagePullSecrets = imagePullSecrets;
    }

    @JsonProperty("mainApplicationFile")
    public String getMainApplicationFile() {
        return mainApplicationFile;
    }

    @JsonProperty("mainApplicationFile")
    public void setMainApplicationFile(String mainApplicationFile) {
        this.mainApplicationFile = mainApplicationFile;
    }

    @JsonProperty("mainClass")
    public String getMainClass() {
        return mainClass;
    }

    @JsonProperty("mainClass")
    public void setMainClass(String mainClass) {
        this.mainClass = mainClass;
    }

    @JsonProperty("memoryOverheadFactor")
    public String getMemoryOverheadFactor() {
        return memoryOverheadFactor;
    }

    @JsonProperty("memoryOverheadFactor")
    public void setMemoryOverheadFactor(String memoryOverheadFactor) {
        this.memoryOverheadFactor = memoryOverheadFactor;
    }

    @JsonProperty("mode")
    public java.lang.String getMode() {
        return mode;
    }

    @JsonProperty("mode")
    public void setMode(java.lang.String mode) {
        this.mode = mode;
    }

    @JsonProperty("monitoring")
    public MonitoringSpec getMonitoring() {
        return monitoring;
    }

    @JsonProperty("monitoring")
    public void setMonitoring(MonitoringSpec monitoring) {
        this.monitoring = monitoring;
    }

    @JsonProperty("nodeSelector")
    public Map<String, String> getNodeSelector() {
        return nodeSelector;
    }

    @JsonProperty("nodeSelector")
    public void setNodeSelector(Map<String, String> nodeSelector) {
        this.nodeSelector = nodeSelector;
    }

    @JsonProperty("proxyUser")
    public String getProxyUser() {
        return proxyUser;
    }

    @JsonProperty("proxyUser")
    public void setProxyUser(String proxyUser) {
        this.proxyUser = proxyUser;
    }

    @JsonProperty("pythonVersion")
    public String getPythonVersion() {
        return pythonVersion;
    }

    @JsonProperty("pythonVersion")
    public void setPythonVersion(String pythonVersion) {
        this.pythonVersion = pythonVersion;
    }

    @JsonProperty("restartPolicy")
    public RestartPolicy getRestartPolicy() {
        return restartPolicy;
    }

    @JsonProperty("restartPolicy")
    public void setRestartPolicy(RestartPolicy restartPolicy) {
        this.restartPolicy = restartPolicy;
    }

    @JsonProperty("retryInterval")
    public Long getRetryInterval() {
        return retryInterval;
    }

    @JsonProperty("retryInterval")
    public void setRetryInterval(Long retryInterval) {
        this.retryInterval = retryInterval;
    }

    @JsonProperty("sparkConf")
    public Map<String, String> getSparkConf() {
        return sparkConf;
    }

    @JsonProperty("sparkConf")
    public void setSparkConf(Map<String, String> sparkConf) {
        this.sparkConf = sparkConf;
    }

    @JsonProperty("sparkConfigMap")
    public String getSparkConfigMap() {
        return sparkConfigMap;
    }

    @JsonProperty("sparkConfigMap")
    public void setSparkConfigMap(String sparkConfigMap) {
        this.sparkConfigMap = sparkConfigMap;
    }

    @JsonProperty("sparkUIOptions")
    public SparkUIConfiguration getSparkUIOptions() {
        return sparkUIOptions;
    }

    @JsonProperty("sparkUIOptions")
    public void setSparkUIOptions(SparkUIConfiguration sparkUIOptions) {
        this.sparkUIOptions = sparkUIOptions;
    }

    @JsonProperty("sparkVersion")
    public java.lang.String getSparkVersion() {
        return sparkVersion;
    }

    @JsonProperty("sparkVersion")
    public void setSparkVersion(java.lang.String sparkVersion) {
        this.sparkVersion = sparkVersion;
    }

    @JsonProperty("timeToLiveSeconds")
    public Long getTimeToLiveSeconds() {
        return timeToLiveSeconds;
    }

    @JsonProperty("timeToLiveSeconds")
    public void setTimeToLiveSeconds(Long timeToLiveSeconds) {
        this.timeToLiveSeconds = timeToLiveSeconds;
    }

    @JsonProperty("type")
    public java.lang.String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(java.lang.String type) {
        this.type = type;
    }

    @JsonProperty("volumes")
    public List<io.fabric8.kubernetes.api.model.Volume> getVolumes() {
        return volumes;
    }

    @JsonProperty("volumes")
    public void setVolumes(List<io.fabric8.kubernetes.api.model.Volume> volumes) {
        this.volumes = volumes;
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
