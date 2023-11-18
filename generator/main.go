package main

import (
	"fmt"
	"reflect"

	sparkv1beta2 "github.com/GoogleCloudPlatform/spark-on-k8s-operator/pkg/apis/sparkoperator.k8s.io/v1beta2"
	"github.com/fabric8io/kubernetes-client/generator/pkg/schemagen"
	v1 "k8s.io/apimachinery/pkg/apis/meta/v1"
	"k8s.io/apimachinery/pkg/runtime"
)

func main() {
	// the CRD List types for which the model should be generated
	// no other types need to be defined as they are auto discovered
	crdLists := map[reflect.Type]schemagen.CrdScope{
		reflect.TypeOf(sparkv1beta2.SparkApplicationList{}):          schemagen.Namespaced,
		reflect.TypeOf(sparkv1beta2.ScheduledSparkApplicationList{}): schemagen.Namespaced,
	}

	// constraints and patterns for fields
	constraints := map[reflect.Type]map[string]*schemagen.Constraint{}

	// types that are manually defined in the model
	providedTypes := []schemagen.ProvidedType{}

	// go packages that are provided and where no generation is required and their corresponding java package
	providedPackages := map[string]string{
		// external
		"k8s.io/api/core/v1":       "io.fabric8.kubernetes.api.model",
		"k8s.io/api/networking/v1": "io.fabric8.kubernetes.api.model.networking.v1",

		"k8s.io/apimachinery/pkg/apis/meta/v1": "io.fabric8.kubernetes.api.model",
		"k8s.io/apimachinery/pkg/api/resource": "io.fabric8.kubernetes.api.model",
		"k8s.io/apimachinery/pkg/runtime":      "io.fabric8.kubernetes.api.model.runtime",
	}

	// mapping of go packages of this module to the resulting java package
	// optional ApiGroup and ApiVersion for the go package (which is added to the generated java class)
	packageMapping := map[string]schemagen.PackageInformation{
		"github.com/GoogleCloudPlatform/spark-on-k8s-operator/pkg/apis/sparkoperator.k8s.io/v1beta2": {
			JavaPackage: "io.k8s.sparkoperator.v1beta2",
			ApiGroup:    "sparkoperator.k8s.io",
			ApiVersion:  "v1beta2",
		},
	}

	// converts all packages starting with <key> to a java package using an automated scheme:
	//  - replace <key> with <value> aka "package prefix"
	//  - replace '/' with '.' for a valid java package name
	// e.g. knative.dev/eventing/pkg/apis/messaging/v1beta1/ChannelTemplateSpec is mapped to "io.fabric8.knative.internal.eventing.pkg.apis.messaging.v1beta1.ChannelTemplateSpec"
	mappingSchema := map[string]string{
		"github.com/GoogleCloudPlatform/spark-on-k8s-operator/pkg/apis/sparkoperator.k8s.io/v1beta2": "io.k8s.sparkoperator.v1beta2",
	}

	// overwriting sometimes
	manualTypeMap := map[reflect.Type]string{
		reflect.TypeOf(v1.Time{}):              "java.lang.String", // or java.time.ZonedDateTime
		reflect.TypeOf(v1.Duration{}):          "java.lang.String", // or java.time.Duration
		reflect.TypeOf(runtime.RawExtension{}): "Map<String, Object>",
		reflect.TypeOf([]byte{}):               "java.lang.String",
	}

	json := schemagen.GenerateSchema(
		"http://fabric8.io/spark/SparkSchema#",
		crdLists,
		providedPackages,
		manualTypeMap,
		packageMapping,
		mappingSchema,
		providedTypes,
		constraints,
		"io.k8s.sparkoperator",
	)

	fmt.Println(json)
}
