plugins {
    kotlin("jvm") version "1.9.25"
    kotlin("plugin.spring") version "1.9.25"
    kotlin("plugin.serialization") version "2.1.20"
    id("org.springframework.boot") version "3.3.11"
    id("io.spring.dependency-management") version "1.1.7"
}

group = "dev.studiohudson"
version = "0.0.1-SNAPSHOT"
var oktaSdkVersion = "22.0.1"
var oktaAuthVersion = "3.0.7"
var kotlinxSerializationJsonVersion = "1.8.1"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-quartz")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
//    implementation("com.okta.spring:okta-spring-boot-starter:${oktaAuthVersion}")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("com.okta.sdk:okta-sdk-api:${oktaSdkVersion}")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:${kotlinxSerializationJsonVersion}")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    runtimeOnly("com.okta.sdk:okta-sdk-impl:${oktaSdkVersion}")
}

kotlin {
    compilerOptions {
        freeCompilerArgs.addAll("-Xjsr305=strict")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
