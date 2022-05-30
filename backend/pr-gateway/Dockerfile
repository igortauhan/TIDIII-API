FROM openjdk:17

VOLUME /tmp

COPY target/*.jar pr-gateway.jar

ENTRYPOINT ["java", "-jar", "/pr-gateway.jar"]