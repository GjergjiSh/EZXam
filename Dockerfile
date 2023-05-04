FROM openjdk:17
COPY target /app
ENTRYPOINT ["java","-jar","/app/ezxam.jar"]