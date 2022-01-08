#
# Build stage
#
FROM maven:3.6.3-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

#
# Run stage
#
FROM openjdk:11-jre-slim
COPY --from=build /home/app/target/Shopify-0.0.1-SNAPSHOT.jar /usr/local/lib/Shopify.jar
EXPOSE 8080
ENTRYPOINT ["java","-Xmx256m","-jar","/usr/local/lib/Shopify.jar"]

