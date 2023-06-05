################################################
#                   JAVA IMAGE                 #
################################################
# A base image containing a runtime Java environment
FROM openjdk:17
# Application jar file
ARG JAR_FILE=/target/*.jar
# Add the application jar file to the container
COPY ${JAR_FILE} /application.jar
# Launch the application
ENTRYPOINT ["java","-jar","/application.jar"]