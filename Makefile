.DEFAULT_GOAL := build-run

setup:
	./gradlew wrapper --gradle-version 6.8.3

clean:
	./gradlew clean

build: clean
	./gradlew build

install: clean
	./gradlew install

run-dist:
	./build/install/java-package/bin/java-package

run:
	./gradlew run

test:
	./gradlew test

lint:
	./gradlew checkstyleMain checkstyleTest

check-updates:
	./gradlew dependencyUpdates

build-run: build run
