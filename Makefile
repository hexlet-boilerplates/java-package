.DEFAULT_GOAL := build-run

clean:
	./app/gradlew clean

build:
	./app/gradlew clean build

install:
	./app/gradlew clean install

run-dist:
	./app/build/install/java-package/bin/java-package

run:
	./app/gradlew run

test:
	./app/gradlew test

report:
	./app/gradlew jacocoTestReport

lint:
	./app/gradlew checkstyleMain checkstyleTest

update-deps:
	./app/gradlew useLatestVersions


build-run: build run

.PHONY: build
