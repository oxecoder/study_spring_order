import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  id("org.springframework.boot") version "2.7.1"
  id("io.spring.dependency-management") version "1.0.11.RELEASE"
  kotlin("jvm") version "1.6.21"
  kotlin("plugin.spring") version "1.6.21"
  // no-arg constructor issue
  kotlin("plugin.jpa") version "1.6.21"
}

tasks.withType<KotlinCompile> {
  kotlinOptions {
    freeCompilerArgs = listOf("-Xjsr305=strict")
  }
}

noArg {
  annotation("javax.persistence.Entity")
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

configurations {
  compileOnly {
    extendsFrom(configurations.annotationProcessor.get())
  }
}

repositories {
  mavenCentral()
}

dependencies {
  implementation("org.springframework.boot:spring-boot-starter-data-jpa")
  implementation("org.springframework.boot:spring-boot-starter-web")
  implementation("org.springframework.boot:spring-boot-starter-validation") // NotEmpty

  /**
   * 중요
   */
  implementation("org.jetbrains.kotlin:kotlin-reflect")
  implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

  implementation("org.flywaydb:flyway-core:7.10.0")
//  compileOnly("org.projectlombok:lombok")

    // MapStruct
    implementation ("org.mapstruct:mapstruct:1.4.2.Final")
    annotationProcessor ("org.mapstruct:mapstruct-processor:1.4.2.Final")

  implementation("com.google.guava:guava:28.2-jre")
  implementation("org.apache.commons:commons-lang3:3.9")

  runtimeOnly("com.h2database:h2")
  runtimeOnly("mysql:mysql-connector-java")
  testImplementation("org.springframework.boot:spring-boot-starter-test")
}

buildscript {
  dependencies {
    classpath("org.jetbrains.kotlin:kotlin-noarg:1.6.21")
  }
}

tasks.withType<KotlinCompile> {
  kotlinOptions {
    freeCompilerArgs = listOf("-Xjsr305=strict")
    jvmTarget = "11"
  }
}

tasks.withType<Test> {
  useJUnitPlatform()
}
