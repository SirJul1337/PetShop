
FROM maven:3.8.4-openjdk-17 AS build


WORKDIR /app


COPY pom.xml .


RUN mvn dependency:go-offline -B


COPY src ./src


RUN mvn package -DskipTests

RUN ls -la target/


FROM tomcat:9.0-jdk17


RUN rm -rf /usr/local/tomcat/webapps/*

COPY --from=build /app/target/*.war /usr/local/tomcat/webapps/ROOT.war

RUN ls -la /usr/local/tomcat/webapps/

EXPOSE 8080

# Start Tomcat
CMD ["catalina.sh", "run"]