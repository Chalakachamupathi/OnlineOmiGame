FROM tomcat:8.5.37-jre8

COPY /target/OnlineOmiGame-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/OnlineOmiGame.war

CMD ["catalina.sh", "run"]