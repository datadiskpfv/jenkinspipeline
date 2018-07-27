FROM tomcat:8.0.38

# Place the code version inside the webapps directory
ARG PACKAGE_VERSION
RUN echo "${PACKAGE_VERSION}" >> /usr/local/tomcat/webapps/version.txt
RUN echo "Hello World 1" >> /usr/local/tomcat/webapps/version.txt

COPY jenkinspipeline-1.0.jar /usr/local/tomcat/webapps/jenkinspipeline-1.0.jar

EXPOSE 8080
CMD ["catalina.sh", "run"]