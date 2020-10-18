FROM openjdk:11

WORKDIR app
COPY ./target/mktec.jar /app

EXPOSE 8080
EXPOSE 5005

ARG db_hostname
ARG db_username
ARG db_port
ARG db_database
ARG db_password

ENV DB_HOSTNAME=${db_hostname}
ENV DB_USERNAME=${db_username}
ENV DB_PORT=${db_port}
ENV DB_DATABASE=${db_database}
ENV Db_PASSWORD=${db_password}

CMD [ \
      "java", \
      "-Xms128m", \
      "-Xmx256m",\
      "-Xdebug", "-Xnoagent", "-Xrunjdwp:transport=dt_socket,address=*:5005,server=y,suspend=n", \
      "-jar",\
      "mktec.jar" \
]