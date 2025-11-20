import org.gradle.api.tasks.testing.Test
import org.gradle.api.tasks.testing.logging.TestLogEvent
import org.gradle.api.tasks.testing.logging.TestExceptionFormat

plugins {
    // id("com.github.ben-manes.versions") version "0.52.0"
    // id("com.diffplug.spotless") version "7.2.1"

    application
    // jacoco
    alias(libs.plugins.spotless)
    alias(libs.plugins.lombok)
    alias(libs.plugins.shadow)
    alias(libs.plugins.sonarqube)
}

group = "io.hexlet"
version = "1.0-SNAPSHOT"

application { mainClass.set("io.hexlet.Application") }

repositories { mavenCentral() }

dependencies {
    implementation(libs.commons.lang3)
    implementation(libs.commons.collections4)
    // testImplementation(platform(libs.junit.bom))
    // testImplementation(libs.junit.jupiter)
    // testRuntimeOnly(libs.junit.platform.launcher)
}

testing {
    suites {
        // Configure the built-in test suite
        val test by getting(JvmTestSuite::class) {
            // Use JUnit Jupiter test framework
            useJUnitJupiter("5.12.1")
        }
    }
}

tasks.test {
    testLogging {
        showStandardStreams = true

        // какие события показывать
        events(
            TestLogEvent.FAILED,
            TestLogEvent.PASSED,
            TestLogEvent.SKIPPED,
            TestLogEvent.STANDARD_OUT,
            TestLogEvent.STANDARD_ERROR,
        )

        // формат исключений
        exceptionFormat = TestExceptionFormat.FULL

        // детали
        showExceptions = true
        showCauses = true
        showStackTraces = true
    }
}

spotless {
    java {
        // don't need to set target, it is inferred from java

        // apply a specific flavor of google-java-format
        // googleJavaFormat('1.8').aosp().reflowLongStrings().skipJavadocFormatting()
        // fix formatting of type annotations
        importOrder()
        googleJavaFormat().aosp()
        formatAnnotations()
        removeUnusedImports()
        leadingTabsToSpaces(4)
        endWithNewline()
        // make sure every file has the following copyright header.
        // optionally, Spotless can set copyright years by digging
        // through git history (see "license" section below)
        // licenseHeader '/* (C)$YEAR */'
    }
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(25)
    }
}

// tasks.jacocoTestReport { reports { xml.required.set(true) } }

// sonar {
//     properties {
//         property("sonar.projectKey", "hexlet-boilerplates_java-package")
//         property("sonar.organization", "hexlet-boilerplates")
//         property("sonar.host.url", "https://sonarcloud.io")
//     }
// }
