FROM  openjdk:17

MAINTAINER kunal<kunalprajapat221@gmail.com>

COPY /target/Plan-API-0.0.1-SNAPSHOT.jar   /usr/Plan-API-0.0.1-SNAPSHOT.jar

WORKDIR /usr/Plan-API-0.0.1-SNAPSHOT

EXPOSE 9090  

ENTRYPOINT [ "java", "-jar" ,"Plan-API-0.0.1-SNAPSHOT" ]