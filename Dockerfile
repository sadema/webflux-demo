ARG BUILD_IMAGE=maven:3.6-jdk-11
ARG RUNTIME_IMAGE=openjdk:11-jdk-slim

FROM ${BUILD_IMAGE} as dependencies

COPY pom.xml ./

RUN mvn -B dependency:go-offline

FROM dependencies as build

COPY src ./src

RUN mvn -B clean package

FROM ${RUNTIME_IMAGE}

COPY --from=build target/webflux-demo-*.jar /opt/app/webflux-demo.jar

WORKDIR /opt/app/
CMD ["java", "-jar", "webflux-demo.jar"]
