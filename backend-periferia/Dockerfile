FROM maven:3.8.3-openjdk-17-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package -DskipTests

FROM openjdk:17-slim
COPY --from=build /home/app/target/backend-periferia.jar /usr/local/lib/backend-periferia.jar
EXPOSE 8090
ENTRYPOINT ["java","-jar","/usr/local/lib/backend-periferia.jar"]
