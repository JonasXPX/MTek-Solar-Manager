FROM openjdk:11

WORKDIR app
COPY target/mktek.jar app

CMD ["java", "-Xmx256m", "-jar", "mktek.jar"]