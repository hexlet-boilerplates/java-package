import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent

plugins {
    application
    jacoco
    id("checkstyle")
    id("io.freefair.lombok") version "8.13.1"
    id("com.github.ben-manes.versions") version "0.52.0"
    id("com.github.johnrengelman.shadow") version "8.1.1"
    // Плагин для публикации отчета о покрытии тестами на SonarQube
    id("org.sonarqube") version "6.0.1.5171"
}

group = "io.hexlet"

version = "1.0-SNAPSHOT"

application { mainClass.set("io.hexlet.Application") }

repositories { mavenCentral() }

dependencies {
    implementation("org.apache.commons:commons-lang3:3.17.0")
    implementation("org.apache.commons:commons-collections4:4.4")
    testImplementation(platform("org.junit:junit-bom:5.12.2"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()
    // https://technology.lastminute.com/junit5-kotlin-and-gradle-dsl/
    testLogging {
        exceptionFormat = TestExceptionFormat.FULL
        events = mutableSetOf(TestLogEvent.FAILED, TestLogEvent.PASSED, TestLogEvent.SKIPPED)
        // showStackTraces = true
        // showCauses = true
        showStandardStreams = true
    }
}

tasks.jacocoTestReport { reports { xml.required.set(true) } }

// Конфигурация плагина org.sonarqube
sonar {
    properties {
        property("sonar.projectKey", "hexlet-boilerplates_java-package")
        property("sonar.organization", "hexlet-boilerplates")
        property("sonar.host.url", "https://sonarcloud.io")
    }
}
