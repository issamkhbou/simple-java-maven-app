from openjdk:8-jre-alpine 

expose 8080 

copy ./target/my-app-*.jar /usr/app/ 

workdir /usr/app 

CMD java -jar my-app-*.jar
