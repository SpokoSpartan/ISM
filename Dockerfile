FROM openjdk:8-jre-alpine
COPY ./target/swagger-spring-1.0.0.jar /usr/source/be.jar
WORKDIR /usr/source/
CMD java -Dspring.profiles.active=production -Dserver.port=$PORT -Xms256m -Xmx256m -Xss512k -jar be.jar