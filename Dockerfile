ARG BUILD_IMAGE=maven:3.6-jdk-11
ARG RUNTIME_IMAGE=openjdk:11-jdk-slim

FROM ${BUILD_IMAGE} as build

ARG MAVEN_SETTINGS_FILE=/usr/share/maven/conf/settings.xml

COPY src ./src
COPY pom.xml ./pom.xml

RUN /bin/bash -c 'mvn -s "$MAVEN_SETTINGS_FILE" -B clean package'

FROM ${RUNTIME_IMAGE}

COPY --from=build target/webflux-demo-*.jar /opt/app/webflux-demo.jar

WORKDIR /opt/app/
CMD ["java", "-jar", "webflux-demo.jar"]
