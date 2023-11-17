plugins {
    java
    scala
    id("org.jsonschema2pojo") version "1.2.1"
}

group = "org.apache.spark"
version = "1.0-SNAPSHOT"

val scalaBinaryVersion = "2.12"
val sparkVersion = "3.5.0"
val hadoopVersion = "3.3.4"
val jettyVersion = "9.4.51.v20230217"
val fabric8Version = "6.9.2"
val lombokVersion = "1.18.30"
val sundrVersion = "0.101.3"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.apache.spark:spark-core_$scalaBinaryVersion:$sparkVersion")
    runtimeOnly("org.apache.hadoop:hadoop-aws:$hadoopVersion")
    // shade from "org.eclipse.jetty" to "org.sparkproject.jetty"
    compileOnly("org.eclipse.jetty:jetty-servlet:$jettyVersion")
    implementation("io.fabric8:kubernetes-client:$fabric8Version")
    implementation("io.fabric8:generator-annotations:$fabric8Version")

    annotationProcessor("org.projectlombok:lombok:$lombokVersion")
    annotationProcessor("io.sundr:builder-annotations:$sundrVersion")
    annotationProcessor("io.sundr:transform-annotations:$sundrVersion")

    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

buildscript {
    dependencies {
        classpath("io.fabric8:kubernetes-model-jsonschema2pojo:6.9.2")
    }
}

scala {
    zincVersion = "1.9.5"
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(8))
    }
}

// See: https://github.com/fabric8io/kubernetes-client/blob/v6.9.2/pom.xml#L1057-L1067
// Ref: https://github.com/joelittlejohn/jsonschema2pojo/tree/master/jsonschema2pojo-gradle-plugin
jsonSchema2Pojo {
    sourceFiles = files("src/main/resources/schema")
    targetDirectory = file("src/gen/java")
    targetPackage = "io.k8s.sparkoperator.api.model"
    removeOldOutput = true

    setAnnotationStyle("NONE") // disable to avoid duplicate with fabric8
    setCustomAnnotator("io.fabric8.kubernetes.jsonschema2pojo.ExtensionTypeAnnotator")
    setCustomRuleFactory("io.fabric8.kubernetes.jsonschema2pojo.Fabric8RuleFactory")
    includeJsr303Annotations = true
    includeJsr305Annotations = true
    includeConstructors = true
    // use lombok instead
    includeToString = false
    includeHashcodeAndEquals = false
}

tasks.test {
    useJUnitPlatform()
}
