plugins {
    java
    scala
}

group = "org.apache.spark"
version = "1.0-SNAPSHOT"

val scalaBinaryVersion = "2.12"
val sparkVersion = "3.5.0"
val hadoopVersion = "3.3.4"
val jettyVersion = "9.4.51.v20230217"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.apache.spark:spark-core_$scalaBinaryVersion:$sparkVersion")
    implementation("org.apache.hadoop:hadoop-aws:$hadoopVersion")
    implementation("org.eclipse.jetty:jetty-servlet:$jettyVersion")

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

tasks.test {
    useJUnitPlatform()
}
