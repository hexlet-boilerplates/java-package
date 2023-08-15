import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent

plugins {
  application
  id("checkstyle")
  id("io.freefair.lombok") version "8.1.0"
  id("com.github.ben-manes.versions") version "0.47.0"
}

group = "io.hexlet"
version = "1.0-SNAPSHOT"

application { mainClass.set("io.hexlet.blog.Application") }

repositories {
  mavenCentral()
}

dependencies {
  testImplementation(platform("org.junit:junit-bom:5.9.1"))
  testImplementation("org.junit.jupiter:junit-jupiter")
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
