FROM openjdk:11

VOLUME /tmp

COPY target/*.jar pr-esp.jar

ENTRYPOINT ["java", "-jar", "/pr-esp.jar"]