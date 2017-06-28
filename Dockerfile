FROM openjdk:8
ADD target/sbux-docker-poc.jar sbux-docker-poc.jar
EXPOSE 8085
ENTRYPOINT ["java","-jar","sbux-docker-poc.jar"]