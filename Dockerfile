FROM maven:3.8-jdk-11
COPY src  home/apiframework/src
COPY pom.xml	home/apiframework/pom.xml
COPY testng.xml	home/apiframework/testng.xml
WORKDIR home/apiframework
ENTRYPOINT mvn clean test