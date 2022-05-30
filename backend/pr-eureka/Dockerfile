FROM openjdk:17

VOLUME /tmp

COPY target/*.jar pr-eureka.jar

ENTRYPOINT ["java", "-jar", "/pr-eureka.jar"]