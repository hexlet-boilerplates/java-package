build: clean
	./mvnw package

clean:
	./mvnw clean

run:
	java -jar ./target/java-package-1.0-SNAPSHOT-jar-with-dependencies.jar