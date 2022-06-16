from openjdk:8-jre-alpine 

expose 8080 

copy ./target/my-app-*.jar /usr/app/ 

workdir /usr/app 

entrypoint ["java","-jar","my-app-1.0-SNAPSHOT.jar"] 
