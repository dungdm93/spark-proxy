
package io.k8s.sparkoperator.api.model;

import javax.annotation.Generated;
import javax.annotation.Nullable;
import javax.validation.Valid;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.k8s.sparkoperator.v1beta2.ApplicationState;
import io.k8s.sparkoperator.v1beta2.BatchSchedulerConfiguration;
import io.k8s.sparkoperator.v1beta2.Dependencies;
import io.k8s.sparkoperator.v1beta2.DriverInfo;
import io.k8s.sparkoperator.v1beta2.DriverSpec;
import io.k8s.sparkoperator.v1beta2.DynamicAllocation;
import io.k8s.sparkoperator.v1beta2.ExecutorSpec;
import io.k8s.sparkoperator.v1beta2.GPUSpec;
import io.k8s.sparkoperator.v1beta2.MonitoringSpec;
import io.k8s.sparkoperator.v1beta2.NameKey;
import io.k8s.sparkoperator.v1beta2.NamePath;
import io.k8s.sparkoperator.v1beta2.Port;
import io.k8s.sparkoperator.v1beta2.PrometheusSpec;
import io.k8s.sparkoperator.v1beta2.RestartPolicy;
import io.k8s.sparkoperator.v1beta2.ScheduledSparkApplication;
import io.k8s.sparkoperator.v1beta2.ScheduledSparkApplicationList;
import io.k8s.sparkoperator.v1beta2.ScheduledSparkApplicationSpec;
import io.k8s.sparkoperator.v1beta2.ScheduledSparkApplicationStatus;
import io.k8s.sparkoperator.v1beta2.SecretInfo;
import io.k8s.sparkoperator.v1beta2.SparkApplication;
import io.k8s.sparkoperator.v1beta2.SparkApplicationList;
import io.k8s.sparkoperator.v1beta2.SparkApplicationSpec;
import io.k8s.sparkoperator.v1beta2.SparkApplicationStatus;
import io.k8s.sparkoperator.v1beta2.SparkUIConfiguration;
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
    "github_com_GoogleCloudPlatform_spark-on-k8s-operator_pkg_apis_sparkoperator_k8s_io_v1beta2_ApplicationState",
    "github_com_GoogleCloudPlatform_spark-on-k8s-operator_pkg_apis_sparkoperator_k8s_io_v1beta2_BatchSchedulerConfiguration",
    "github_com_GoogleCloudPlatform_spark-on-k8s-operator_pkg_apis_sparkoperator_k8s_io_v1beta2_Dependencies",
    "github_com_GoogleCloudPlatform_spark-on-k8s-operator_pkg_apis_sparkoperator_k8s_io_v1beta2_DriverInfo",
    "github_com_GoogleCloudPlatform_spark-on-k8s-operator_pkg_apis_sparkoperator_k8s_io_v1beta2_DriverSpec",
    "github_com_GoogleCloudPlatform_spark-on-k8s-operator_pkg_apis_sparkoperator_k8s_io_v1beta2_DynamicAllocation",
    "github_com_GoogleCloudPlatform_spark-on-k8s-operator_pkg_apis_sparkoperator_k8s_io_v1beta2_ExecutorSpec",
    "github_com_GoogleCloudPlatform_spark-on-k8s-operator_pkg_apis_sparkoperator_k8s_io_v1beta2_GPUSpec",
    "github_com_GoogleCloudPlatform_spark-on-k8s-operator_pkg_apis_sparkoperator_k8s_io_v1beta2_MonitoringSpec",
    "github_com_GoogleCloudPlatform_spark-on-k8s-operator_pkg_apis_sparkoperator_k8s_io_v1beta2_NameKey",
    "github_com_GoogleCloudPlatform_spark-on-k8s-operator_pkg_apis_sparkoperator_k8s_io_v1beta2_NamePath",
    "github_com_GoogleCloudPlatform_spark-on-k8s-operator_pkg_apis_sparkoperator_k8s_io_v1beta2_Port",
    "github_com_GoogleCloudPlatform_spark-on-k8s-operator_pkg_apis_sparkoperator_k8s_io_v1beta2_PrometheusSpec",
    "github_com_GoogleCloudPlatform_spark-on-k8s-operator_pkg_apis_sparkoperator_k8s_io_v1beta2_RestartPolicy",
    "github_com_GoogleCloudPlatform_spark-on-k8s-operator_pkg_apis_sparkoperator_k8s_io_v1beta2_ScheduledSparkApplication",
    "github_com_GoogleCloudPlatform_spark-on-k8s-operator_pkg_apis_sparkoperator_k8s_io_v1beta2_ScheduledSparkApplicationList",
    "github_com_GoogleCloudPlatform_spark-on-k8s-operator_pkg_apis_sparkoperator_k8s_io_v1beta2_ScheduledSparkApplicationSpec",
    "github_com_GoogleCloudPlatform_spark-on-k8s-operator_pkg_apis_sparkoperator_k8s_io_v1beta2_ScheduledSparkApplicationStatus",
    "github_com_GoogleCloudPlatform_spark-on-k8s-operator_pkg_apis_sparkoperator_k8s_io_v1beta2_SecretInfo",
    "github_com_GoogleCloudPlatform_spark-on-k8s-operator_pkg_apis_sparkoperator_k8s_io_v1beta2_SparkApplication",
    "github_com_GoogleCloudPlatform_spark-on-k8s-operator_pkg_apis_sparkoperator_k8s_io_v1beta2_SparkApplicationList",
    "github_com_GoogleCloudPlatform_spark-on-k8s-operator_pkg_apis_sparkoperator_k8s_io_v1beta2_SparkApplicationSpec",
    "github_com_GoogleCloudPlatform_spark-on-k8s-operator_pkg_apis_sparkoperator_k8s_io_v1beta2_SparkApplicationStatus",
    "github_com_GoogleCloudPlatform_spark-on-k8s-operator_pkg_apis_sparkoperator_k8s_io_v1beta2_SparkUIConfiguration"
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
public class SparkSchema {

    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("github_com_GoogleCloudPlatform_spark-on-k8s-operator_pkg_apis_sparkoperator_k8s_io_v1beta2_ApplicationState")
    @Valid
    private ApplicationState githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2ApplicationState;
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("github_com_GoogleCloudPlatform_spark-on-k8s-operator_pkg_apis_sparkoperator_k8s_io_v1beta2_BatchSchedulerConfiguration")
    @Valid
    private BatchSchedulerConfiguration githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2BatchSchedulerConfiguration;
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("github_com_GoogleCloudPlatform_spark-on-k8s-operator_pkg_apis_sparkoperator_k8s_io_v1beta2_Dependencies")
    @Valid
    private Dependencies githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2Dependencies;
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("github_com_GoogleCloudPlatform_spark-on-k8s-operator_pkg_apis_sparkoperator_k8s_io_v1beta2_DriverInfo")
    @Valid
    private DriverInfo githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2DriverInfo;
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("github_com_GoogleCloudPlatform_spark-on-k8s-operator_pkg_apis_sparkoperator_k8s_io_v1beta2_DriverSpec")
    @Valid
    private DriverSpec githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2DriverSpec;
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("github_com_GoogleCloudPlatform_spark-on-k8s-operator_pkg_apis_sparkoperator_k8s_io_v1beta2_DynamicAllocation")
    @Valid
    private DynamicAllocation githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2DynamicAllocation;
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("github_com_GoogleCloudPlatform_spark-on-k8s-operator_pkg_apis_sparkoperator_k8s_io_v1beta2_ExecutorSpec")
    @Valid
    private ExecutorSpec githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2ExecutorSpec;
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("github_com_GoogleCloudPlatform_spark-on-k8s-operator_pkg_apis_sparkoperator_k8s_io_v1beta2_GPUSpec")
    @Valid
    private GPUSpec githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2GPUSpec;
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("github_com_GoogleCloudPlatform_spark-on-k8s-operator_pkg_apis_sparkoperator_k8s_io_v1beta2_MonitoringSpec")
    @Valid
    private MonitoringSpec githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2MonitoringSpec;
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("github_com_GoogleCloudPlatform_spark-on-k8s-operator_pkg_apis_sparkoperator_k8s_io_v1beta2_NameKey")
    @Valid
    private NameKey githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2NameKey;
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("github_com_GoogleCloudPlatform_spark-on-k8s-operator_pkg_apis_sparkoperator_k8s_io_v1beta2_NamePath")
    @Valid
    private NamePath githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2NamePath;
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("github_com_GoogleCloudPlatform_spark-on-k8s-operator_pkg_apis_sparkoperator_k8s_io_v1beta2_Port")
    @Valid
    private Port githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2Port;
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("github_com_GoogleCloudPlatform_spark-on-k8s-operator_pkg_apis_sparkoperator_k8s_io_v1beta2_PrometheusSpec")
    @Valid
    private PrometheusSpec githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2PrometheusSpec;
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("github_com_GoogleCloudPlatform_spark-on-k8s-operator_pkg_apis_sparkoperator_k8s_io_v1beta2_RestartPolicy")
    @Valid
    private RestartPolicy githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2RestartPolicy;
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("github_com_GoogleCloudPlatform_spark-on-k8s-operator_pkg_apis_sparkoperator_k8s_io_v1beta2_ScheduledSparkApplication")
    @Valid
    private ScheduledSparkApplication githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2ScheduledSparkApplication;
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("github_com_GoogleCloudPlatform_spark-on-k8s-operator_pkg_apis_sparkoperator_k8s_io_v1beta2_ScheduledSparkApplicationList")
    @Valid
    private ScheduledSparkApplicationList githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2ScheduledSparkApplicationList;
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("github_com_GoogleCloudPlatform_spark-on-k8s-operator_pkg_apis_sparkoperator_k8s_io_v1beta2_ScheduledSparkApplicationSpec")
    @Valid
    private ScheduledSparkApplicationSpec githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2ScheduledSparkApplicationSpec;
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("github_com_GoogleCloudPlatform_spark-on-k8s-operator_pkg_apis_sparkoperator_k8s_io_v1beta2_ScheduledSparkApplicationStatus")
    @Valid
    private ScheduledSparkApplicationStatus githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2ScheduledSparkApplicationStatus;
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("github_com_GoogleCloudPlatform_spark-on-k8s-operator_pkg_apis_sparkoperator_k8s_io_v1beta2_SecretInfo")
    @Valid
    private SecretInfo githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2SecretInfo;
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("github_com_GoogleCloudPlatform_spark-on-k8s-operator_pkg_apis_sparkoperator_k8s_io_v1beta2_SparkApplication")
    @Valid
    private SparkApplication githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2SparkApplication;
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("github_com_GoogleCloudPlatform_spark-on-k8s-operator_pkg_apis_sparkoperator_k8s_io_v1beta2_SparkApplicationList")
    @Valid
    private SparkApplicationList githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2SparkApplicationList;
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("github_com_GoogleCloudPlatform_spark-on-k8s-operator_pkg_apis_sparkoperator_k8s_io_v1beta2_SparkApplicationSpec")
    @Valid
    private SparkApplicationSpec githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2SparkApplicationSpec;
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("github_com_GoogleCloudPlatform_spark-on-k8s-operator_pkg_apis_sparkoperator_k8s_io_v1beta2_SparkApplicationStatus")
    @Valid
    private SparkApplicationStatus githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2SparkApplicationStatus;
    /**
     * 
     * (Can be null)
     * 
     */
    @Nullable
    @JsonProperty("github_com_GoogleCloudPlatform_spark-on-k8s-operator_pkg_apis_sparkoperator_k8s_io_v1beta2_SparkUIConfiguration")
    @Valid
    private SparkUIConfiguration githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2SparkUIConfiguration;

    /**
     * No args constructor for use in serialization
     * 
     */
    public SparkSchema() {
    }

    public SparkSchema(ApplicationState githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2ApplicationState, BatchSchedulerConfiguration githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2BatchSchedulerConfiguration, Dependencies githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2Dependencies, DriverInfo githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2DriverInfo, DriverSpec githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2DriverSpec, DynamicAllocation githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2DynamicAllocation, ExecutorSpec githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2ExecutorSpec, GPUSpec githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2GPUSpec, MonitoringSpec githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2MonitoringSpec, NameKey githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2NameKey, NamePath githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2NamePath, Port githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2Port, PrometheusSpec githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2PrometheusSpec, RestartPolicy githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2RestartPolicy, ScheduledSparkApplication githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2ScheduledSparkApplication, ScheduledSparkApplicationList githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2ScheduledSparkApplicationList, ScheduledSparkApplicationSpec githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2ScheduledSparkApplicationSpec, ScheduledSparkApplicationStatus githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2ScheduledSparkApplicationStatus, SecretInfo githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2SecretInfo, SparkApplication githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2SparkApplication, SparkApplicationList githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2SparkApplicationList, SparkApplicationSpec githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2SparkApplicationSpec, SparkApplicationStatus githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2SparkApplicationStatus, SparkUIConfiguration githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2SparkUIConfiguration) {
        super();
        this.githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2ApplicationState = githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2ApplicationState;
        this.githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2BatchSchedulerConfiguration = githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2BatchSchedulerConfiguration;
        this.githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2Dependencies = githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2Dependencies;
        this.githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2DriverInfo = githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2DriverInfo;
        this.githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2DriverSpec = githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2DriverSpec;
        this.githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2DynamicAllocation = githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2DynamicAllocation;
        this.githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2ExecutorSpec = githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2ExecutorSpec;
        this.githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2GPUSpec = githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2GPUSpec;
        this.githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2MonitoringSpec = githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2MonitoringSpec;
        this.githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2NameKey = githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2NameKey;
        this.githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2NamePath = githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2NamePath;
        this.githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2Port = githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2Port;
        this.githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2PrometheusSpec = githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2PrometheusSpec;
        this.githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2RestartPolicy = githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2RestartPolicy;
        this.githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2ScheduledSparkApplication = githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2ScheduledSparkApplication;
        this.githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2ScheduledSparkApplicationList = githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2ScheduledSparkApplicationList;
        this.githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2ScheduledSparkApplicationSpec = githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2ScheduledSparkApplicationSpec;
        this.githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2ScheduledSparkApplicationStatus = githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2ScheduledSparkApplicationStatus;
        this.githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2SecretInfo = githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2SecretInfo;
        this.githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2SparkApplication = githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2SparkApplication;
        this.githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2SparkApplicationList = githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2SparkApplicationList;
        this.githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2SparkApplicationSpec = githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2SparkApplicationSpec;
        this.githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2SparkApplicationStatus = githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2SparkApplicationStatus;
        this.githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2SparkUIConfiguration = githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2SparkUIConfiguration;
    }

    @JsonProperty("github_com_GoogleCloudPlatform_spark-on-k8s-operator_pkg_apis_sparkoperator_k8s_io_v1beta2_ApplicationState")
    public ApplicationState getGithubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2ApplicationState() {
        return githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2ApplicationState;
    }

    @JsonProperty("github_com_GoogleCloudPlatform_spark-on-k8s-operator_pkg_apis_sparkoperator_k8s_io_v1beta2_ApplicationState")
    public void setGithubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2ApplicationState(ApplicationState githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2ApplicationState) {
        this.githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2ApplicationState = githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2ApplicationState;
    }

    @JsonProperty("github_com_GoogleCloudPlatform_spark-on-k8s-operator_pkg_apis_sparkoperator_k8s_io_v1beta2_BatchSchedulerConfiguration")
    public BatchSchedulerConfiguration getGithubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2BatchSchedulerConfiguration() {
        return githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2BatchSchedulerConfiguration;
    }

    @JsonProperty("github_com_GoogleCloudPlatform_spark-on-k8s-operator_pkg_apis_sparkoperator_k8s_io_v1beta2_BatchSchedulerConfiguration")
    public void setGithubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2BatchSchedulerConfiguration(BatchSchedulerConfiguration githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2BatchSchedulerConfiguration) {
        this.githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2BatchSchedulerConfiguration = githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2BatchSchedulerConfiguration;
    }

    @JsonProperty("github_com_GoogleCloudPlatform_spark-on-k8s-operator_pkg_apis_sparkoperator_k8s_io_v1beta2_Dependencies")
    public Dependencies getGithubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2Dependencies() {
        return githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2Dependencies;
    }

    @JsonProperty("github_com_GoogleCloudPlatform_spark-on-k8s-operator_pkg_apis_sparkoperator_k8s_io_v1beta2_Dependencies")
    public void setGithubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2Dependencies(Dependencies githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2Dependencies) {
        this.githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2Dependencies = githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2Dependencies;
    }

    @JsonProperty("github_com_GoogleCloudPlatform_spark-on-k8s-operator_pkg_apis_sparkoperator_k8s_io_v1beta2_DriverInfo")
    public DriverInfo getGithubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2DriverInfo() {
        return githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2DriverInfo;
    }

    @JsonProperty("github_com_GoogleCloudPlatform_spark-on-k8s-operator_pkg_apis_sparkoperator_k8s_io_v1beta2_DriverInfo")
    public void setGithubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2DriverInfo(DriverInfo githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2DriverInfo) {
        this.githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2DriverInfo = githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2DriverInfo;
    }

    @JsonProperty("github_com_GoogleCloudPlatform_spark-on-k8s-operator_pkg_apis_sparkoperator_k8s_io_v1beta2_DriverSpec")
    public DriverSpec getGithubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2DriverSpec() {
        return githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2DriverSpec;
    }

    @JsonProperty("github_com_GoogleCloudPlatform_spark-on-k8s-operator_pkg_apis_sparkoperator_k8s_io_v1beta2_DriverSpec")
    public void setGithubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2DriverSpec(DriverSpec githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2DriverSpec) {
        this.githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2DriverSpec = githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2DriverSpec;
    }

    @JsonProperty("github_com_GoogleCloudPlatform_spark-on-k8s-operator_pkg_apis_sparkoperator_k8s_io_v1beta2_DynamicAllocation")
    public DynamicAllocation getGithubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2DynamicAllocation() {
        return githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2DynamicAllocation;
    }

    @JsonProperty("github_com_GoogleCloudPlatform_spark-on-k8s-operator_pkg_apis_sparkoperator_k8s_io_v1beta2_DynamicAllocation")
    public void setGithubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2DynamicAllocation(DynamicAllocation githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2DynamicAllocation) {
        this.githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2DynamicAllocation = githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2DynamicAllocation;
    }

    @JsonProperty("github_com_GoogleCloudPlatform_spark-on-k8s-operator_pkg_apis_sparkoperator_k8s_io_v1beta2_ExecutorSpec")
    public ExecutorSpec getGithubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2ExecutorSpec() {
        return githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2ExecutorSpec;
    }

    @JsonProperty("github_com_GoogleCloudPlatform_spark-on-k8s-operator_pkg_apis_sparkoperator_k8s_io_v1beta2_ExecutorSpec")
    public void setGithubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2ExecutorSpec(ExecutorSpec githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2ExecutorSpec) {
        this.githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2ExecutorSpec = githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2ExecutorSpec;
    }

    @JsonProperty("github_com_GoogleCloudPlatform_spark-on-k8s-operator_pkg_apis_sparkoperator_k8s_io_v1beta2_GPUSpec")
    public GPUSpec getGithubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2GPUSpec() {
        return githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2GPUSpec;
    }

    @JsonProperty("github_com_GoogleCloudPlatform_spark-on-k8s-operator_pkg_apis_sparkoperator_k8s_io_v1beta2_GPUSpec")
    public void setGithubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2GPUSpec(GPUSpec githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2GPUSpec) {
        this.githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2GPUSpec = githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2GPUSpec;
    }

    @JsonProperty("github_com_GoogleCloudPlatform_spark-on-k8s-operator_pkg_apis_sparkoperator_k8s_io_v1beta2_MonitoringSpec")
    public MonitoringSpec getGithubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2MonitoringSpec() {
        return githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2MonitoringSpec;
    }

    @JsonProperty("github_com_GoogleCloudPlatform_spark-on-k8s-operator_pkg_apis_sparkoperator_k8s_io_v1beta2_MonitoringSpec")
    public void setGithubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2MonitoringSpec(MonitoringSpec githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2MonitoringSpec) {
        this.githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2MonitoringSpec = githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2MonitoringSpec;
    }

    @JsonProperty("github_com_GoogleCloudPlatform_spark-on-k8s-operator_pkg_apis_sparkoperator_k8s_io_v1beta2_NameKey")
    public NameKey getGithubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2NameKey() {
        return githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2NameKey;
    }

    @JsonProperty("github_com_GoogleCloudPlatform_spark-on-k8s-operator_pkg_apis_sparkoperator_k8s_io_v1beta2_NameKey")
    public void setGithubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2NameKey(NameKey githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2NameKey) {
        this.githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2NameKey = githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2NameKey;
    }

    @JsonProperty("github_com_GoogleCloudPlatform_spark-on-k8s-operator_pkg_apis_sparkoperator_k8s_io_v1beta2_NamePath")
    public NamePath getGithubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2NamePath() {
        return githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2NamePath;
    }

    @JsonProperty("github_com_GoogleCloudPlatform_spark-on-k8s-operator_pkg_apis_sparkoperator_k8s_io_v1beta2_NamePath")
    public void setGithubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2NamePath(NamePath githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2NamePath) {
        this.githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2NamePath = githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2NamePath;
    }

    @JsonProperty("github_com_GoogleCloudPlatform_spark-on-k8s-operator_pkg_apis_sparkoperator_k8s_io_v1beta2_Port")
    public Port getGithubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2Port() {
        return githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2Port;
    }

    @JsonProperty("github_com_GoogleCloudPlatform_spark-on-k8s-operator_pkg_apis_sparkoperator_k8s_io_v1beta2_Port")
    public void setGithubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2Port(Port githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2Port) {
        this.githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2Port = githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2Port;
    }

    @JsonProperty("github_com_GoogleCloudPlatform_spark-on-k8s-operator_pkg_apis_sparkoperator_k8s_io_v1beta2_PrometheusSpec")
    public PrometheusSpec getGithubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2PrometheusSpec() {
        return githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2PrometheusSpec;
    }

    @JsonProperty("github_com_GoogleCloudPlatform_spark-on-k8s-operator_pkg_apis_sparkoperator_k8s_io_v1beta2_PrometheusSpec")
    public void setGithubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2PrometheusSpec(PrometheusSpec githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2PrometheusSpec) {
        this.githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2PrometheusSpec = githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2PrometheusSpec;
    }

    @JsonProperty("github_com_GoogleCloudPlatform_spark-on-k8s-operator_pkg_apis_sparkoperator_k8s_io_v1beta2_RestartPolicy")
    public RestartPolicy getGithubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2RestartPolicy() {
        return githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2RestartPolicy;
    }

    @JsonProperty("github_com_GoogleCloudPlatform_spark-on-k8s-operator_pkg_apis_sparkoperator_k8s_io_v1beta2_RestartPolicy")
    public void setGithubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2RestartPolicy(RestartPolicy githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2RestartPolicy) {
        this.githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2RestartPolicy = githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2RestartPolicy;
    }

    @JsonProperty("github_com_GoogleCloudPlatform_spark-on-k8s-operator_pkg_apis_sparkoperator_k8s_io_v1beta2_ScheduledSparkApplication")
    public ScheduledSparkApplication getGithubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2ScheduledSparkApplication() {
        return githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2ScheduledSparkApplication;
    }

    @JsonProperty("github_com_GoogleCloudPlatform_spark-on-k8s-operator_pkg_apis_sparkoperator_k8s_io_v1beta2_ScheduledSparkApplication")
    public void setGithubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2ScheduledSparkApplication(ScheduledSparkApplication githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2ScheduledSparkApplication) {
        this.githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2ScheduledSparkApplication = githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2ScheduledSparkApplication;
    }

    @JsonProperty("github_com_GoogleCloudPlatform_spark-on-k8s-operator_pkg_apis_sparkoperator_k8s_io_v1beta2_ScheduledSparkApplicationList")
    public ScheduledSparkApplicationList getGithubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2ScheduledSparkApplicationList() {
        return githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2ScheduledSparkApplicationList;
    }

    @JsonProperty("github_com_GoogleCloudPlatform_spark-on-k8s-operator_pkg_apis_sparkoperator_k8s_io_v1beta2_ScheduledSparkApplicationList")
    public void setGithubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2ScheduledSparkApplicationList(ScheduledSparkApplicationList githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2ScheduledSparkApplicationList) {
        this.githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2ScheduledSparkApplicationList = githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2ScheduledSparkApplicationList;
    }

    @JsonProperty("github_com_GoogleCloudPlatform_spark-on-k8s-operator_pkg_apis_sparkoperator_k8s_io_v1beta2_ScheduledSparkApplicationSpec")
    public ScheduledSparkApplicationSpec getGithubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2ScheduledSparkApplicationSpec() {
        return githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2ScheduledSparkApplicationSpec;
    }

    @JsonProperty("github_com_GoogleCloudPlatform_spark-on-k8s-operator_pkg_apis_sparkoperator_k8s_io_v1beta2_ScheduledSparkApplicationSpec")
    public void setGithubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2ScheduledSparkApplicationSpec(ScheduledSparkApplicationSpec githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2ScheduledSparkApplicationSpec) {
        this.githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2ScheduledSparkApplicationSpec = githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2ScheduledSparkApplicationSpec;
    }

    @JsonProperty("github_com_GoogleCloudPlatform_spark-on-k8s-operator_pkg_apis_sparkoperator_k8s_io_v1beta2_ScheduledSparkApplicationStatus")
    public ScheduledSparkApplicationStatus getGithubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2ScheduledSparkApplicationStatus() {
        return githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2ScheduledSparkApplicationStatus;
    }

    @JsonProperty("github_com_GoogleCloudPlatform_spark-on-k8s-operator_pkg_apis_sparkoperator_k8s_io_v1beta2_ScheduledSparkApplicationStatus")
    public void setGithubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2ScheduledSparkApplicationStatus(ScheduledSparkApplicationStatus githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2ScheduledSparkApplicationStatus) {
        this.githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2ScheduledSparkApplicationStatus = githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2ScheduledSparkApplicationStatus;
    }

    @JsonProperty("github_com_GoogleCloudPlatform_spark-on-k8s-operator_pkg_apis_sparkoperator_k8s_io_v1beta2_SecretInfo")
    public SecretInfo getGithubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2SecretInfo() {
        return githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2SecretInfo;
    }

    @JsonProperty("github_com_GoogleCloudPlatform_spark-on-k8s-operator_pkg_apis_sparkoperator_k8s_io_v1beta2_SecretInfo")
    public void setGithubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2SecretInfo(SecretInfo githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2SecretInfo) {
        this.githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2SecretInfo = githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2SecretInfo;
    }

    @JsonProperty("github_com_GoogleCloudPlatform_spark-on-k8s-operator_pkg_apis_sparkoperator_k8s_io_v1beta2_SparkApplication")
    public SparkApplication getGithubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2SparkApplication() {
        return githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2SparkApplication;
    }

    @JsonProperty("github_com_GoogleCloudPlatform_spark-on-k8s-operator_pkg_apis_sparkoperator_k8s_io_v1beta2_SparkApplication")
    public void setGithubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2SparkApplication(SparkApplication githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2SparkApplication) {
        this.githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2SparkApplication = githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2SparkApplication;
    }

    @JsonProperty("github_com_GoogleCloudPlatform_spark-on-k8s-operator_pkg_apis_sparkoperator_k8s_io_v1beta2_SparkApplicationList")
    public SparkApplicationList getGithubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2SparkApplicationList() {
        return githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2SparkApplicationList;
    }

    @JsonProperty("github_com_GoogleCloudPlatform_spark-on-k8s-operator_pkg_apis_sparkoperator_k8s_io_v1beta2_SparkApplicationList")
    public void setGithubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2SparkApplicationList(SparkApplicationList githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2SparkApplicationList) {
        this.githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2SparkApplicationList = githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2SparkApplicationList;
    }

    @JsonProperty("github_com_GoogleCloudPlatform_spark-on-k8s-operator_pkg_apis_sparkoperator_k8s_io_v1beta2_SparkApplicationSpec")
    public SparkApplicationSpec getGithubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2SparkApplicationSpec() {
        return githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2SparkApplicationSpec;
    }

    @JsonProperty("github_com_GoogleCloudPlatform_spark-on-k8s-operator_pkg_apis_sparkoperator_k8s_io_v1beta2_SparkApplicationSpec")
    public void setGithubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2SparkApplicationSpec(SparkApplicationSpec githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2SparkApplicationSpec) {
        this.githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2SparkApplicationSpec = githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2SparkApplicationSpec;
    }

    @JsonProperty("github_com_GoogleCloudPlatform_spark-on-k8s-operator_pkg_apis_sparkoperator_k8s_io_v1beta2_SparkApplicationStatus")
    public SparkApplicationStatus getGithubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2SparkApplicationStatus() {
        return githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2SparkApplicationStatus;
    }

    @JsonProperty("github_com_GoogleCloudPlatform_spark-on-k8s-operator_pkg_apis_sparkoperator_k8s_io_v1beta2_SparkApplicationStatus")
    public void setGithubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2SparkApplicationStatus(SparkApplicationStatus githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2SparkApplicationStatus) {
        this.githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2SparkApplicationStatus = githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2SparkApplicationStatus;
    }

    @JsonProperty("github_com_GoogleCloudPlatform_spark-on-k8s-operator_pkg_apis_sparkoperator_k8s_io_v1beta2_SparkUIConfiguration")
    public SparkUIConfiguration getGithubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2SparkUIConfiguration() {
        return githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2SparkUIConfiguration;
    }

    @JsonProperty("github_com_GoogleCloudPlatform_spark-on-k8s-operator_pkg_apis_sparkoperator_k8s_io_v1beta2_SparkUIConfiguration")
    public void setGithubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2SparkUIConfiguration(SparkUIConfiguration githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2SparkUIConfiguration) {
        this.githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2SparkUIConfiguration = githubComGoogleCloudPlatformSparkOnK8sOperatorPkgApisSparkoperatorK8sIoV1beta2SparkUIConfiguration;
    }

}
