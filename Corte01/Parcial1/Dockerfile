FROM maven:3.8.3-openjdk-17 AS builder
WORKDIR /app
COPY . /app

RUN ["mvn", "clean", "package", "-Dskiptest"]

FROM tomcat:9.0.89-jre17 AS runner
WORKDIR /usr/local/tomcat/webapps

COPY --from=builder /app/target/Parcial1-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war

EXPOSE 8080

ENTRYPOINT ["catalina.sh", "run"]