FROM tomcat
MAINTAINER Kacper Rydzynski
ADD target/SecondTask-1.0.war /usr/local/tomcat/webapps/
EXPOSE 8080
CMD ["catalina.sh", "run"]