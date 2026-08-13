import org.gradle.api.tasks.testing.Test
import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent

plugins {
    application
    jacoco
    alias(libs.plugins.spotless)
    alias(libs.plugins.lombok)
    alias(libs.plugins.versions)
    alias(libs.plugins.version.catalog.update)
    alias(libs.plugins.shadow)
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
            useJUnitJupiter(libs.versions.junit.get())
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

// Точка входа из-под покрытия исключена: у класса с одним main jacoco считает
// ещё и неявный конструктор, который никто не вызывает, и на маленьком проекте
// это одно тянет покрытие вниз.
val coverageExcludes = listOf("io/hexlet/Application.class")

fun JacocoReportBase.excludeEntryPoint() {
    classDirectories.setFrom(
        files(classDirectories.files.map { fileTree(it) { exclude(coverageExcludes) } }),
    )
}

// Отчёт о покрытии считается сразу после тестов, отдельный вызов не нужен.
tasks.jacocoTestReport {
    dependsOn(tasks.test)
    excludeEntryPoint()
    reports {
        xml.required.set(true)
        html.required.set(true)
    }
}

tasks.test { finalizedBy(tasks.jacocoTestReport) }

// Порог покрытия: ниже него `./gradlew build` падает,
// и сборка в CI краснеет вместе с ним.
tasks.jacocoTestCoverageVerification {
    dependsOn(tasks.jacocoTestReport)
    excludeEntryPoint()
    violationRules {
        rule {
            limit {
                counter = "INSTRUCTION"
                value = "COVEREDRATIO"
                minimum = "0.80".toBigDecimal()
            }
        }
    }
}

tasks.check { dependsOn(tasks.jacocoTestCoverageVerification) }

// versionCatalogUpdate пишет свежие версии прямо в gradle/libs.versions.toml,
// поэтому руками их сверять не нужно. Ключи не сортируются: порядок в каталоге
// смысловой, по группам зависимостей.
versionCatalogUpdate {
    sortByKey = false
}
