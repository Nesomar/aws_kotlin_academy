import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
	repositories {
		maven {
			url = uri("https://plugins.gradle.org/m2/")
		}
	}
	dependencies {
		classpath("com.palantir.gradle.docker:gradle-docker:0.32.0")
	}
}

apply(plugin = "com.palantir.docker")

plugins {
	id("org.springframework.boot") version "2.6.3"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	id("com.palantir.docker") version "0.32.0"
	kotlin("jvm") version "1.6.10"
	kotlin("plugin.spring") version "1.6.10"
}

group = "nesomar"
version = "1.0.0"

val dockerImageTag: String? by project
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
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


