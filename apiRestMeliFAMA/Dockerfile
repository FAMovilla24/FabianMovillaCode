FROM adoptopenjdk/openjdk11:latest
COPY "./build/libs/apiRestMeliFAMA-1.0.0.jar" "app.jar"
EXPOSE 3052
ENTRYPOINT ["java","-jar","/app.jar"]