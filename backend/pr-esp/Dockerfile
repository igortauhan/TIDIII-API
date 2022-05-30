FROM openjdk:17

VOLUME /tmp

COPY target/*.jar pr-esp.jar

ENTRYPOINT ["java", "-jar", "/pr-esp.jar"]