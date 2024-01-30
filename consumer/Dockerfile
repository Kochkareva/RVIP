FROM openjdk:17-jdk

WORKDIR /app
COPY ./consumer/build/libs/consumer-0.0.1-SNAPSHOT.jar /app/consumer-0.0.1-SNAPSHOT.jar
EXPOSE 8081

CMD ["java", "-jar", "consumer-0.0.1-SNAPSHOT.jar"]