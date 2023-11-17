plugins {
    java
    scala
    id("io.fabric8.java-generator") version "6.9.2"
}

group = "org.apache.spark"
version = "1.0-SNAPSHOT"

val scalaBinaryVersion = "2.12"
val sparkVersion = "3.5.0"
val hadoopVersion = "3.3.4"
val jettyVersion = "9.4.51.v20230217"
val fabric8Version = "6.9.2"

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

    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

scala {
    zincVersion = "1.9.5"
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(8))
    }
}

javaGen {
    source = file("src/main/resources/kubernetes")
    target = file("build/generated/sources/crds/java/main")
    // javax.annotation.processing.Generated requires Java 9
    generatedAnnotations = false
}

sourceSets.main {
    java {
        srcDir("build/generated/sources/crds/java/main")
    }
}

tasks.withType<JavaCompile> {
    dependsOn("crd2java")
}

tasks.test {
    useJUnitPlatform()
}
