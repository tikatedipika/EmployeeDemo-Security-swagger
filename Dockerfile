# Start with a base image containing Java runtime
FROM openjdk:8-jdk-alpine

# Add Maintainer Info
LABEL maintainer="singhan.dipika@gmail.com"

# Add a volume pointing to /tmp
VOLUME /tmp

# Make port 8090 available to the world outside this container
EXPOSE 8090

# The application's jar file
ARG JAR_FILE=target/EmployeeDemo-0.0.1-SNAPSHOT.jar

# Add the application's jar to the container
ADD ${JAR_FILE} employee-demo.jar

# Run the jar file 
ENTRYPOINT ["java","-jar","/employee-demo.jar"]