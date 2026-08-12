.DEFAULT_GOAL := build-run

setup:
	./gradlew wrapper --gradle-version 9.7.0

clean:
	./gradlew clean

build:
	./gradlew clean build

install:
	./gradlew clean install

run-dist:
	./build/install/java-package/bin/java-package

run:
	./gradlew run

test:
	./gradlew test

report:
	./gradlew jacocoTestReport

lint:
	./gradlew spotlessCheck

lint-fix:
	./gradlew spotlessApply

update-deps:
	./gradlew versionCatalogUpdate


build-run: build run

.PHONY: build
