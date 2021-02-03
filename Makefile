.DEFAULT_GOAL := build-run

setup:
	mvn -N io.takari:maven:wrapper -Dmaven=3.6.3

build:
	./mvnw clean package

install:
	./mvnw clean install

run:
	java -jar ./target/java-package-1.0-SNAPSHOT-jar-with-dependencies.jar

build-run: build run

test:
	./mvnw surefire:test

update:
	./mvnw versions:display-plugin-updates versions:update-properties
# versions:update-parent - not needed
