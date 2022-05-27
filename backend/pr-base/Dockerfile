FROM openjdk:11

VOLUME /tmp

COPY target/*.jar pr-base.jar

ENTRYPOINT ["java", "-jar", "/pr-base.jar"]