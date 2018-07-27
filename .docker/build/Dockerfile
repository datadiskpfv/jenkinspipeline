FROM tomcat:8.0.38

# Place the code version inside the webapps directory
ARG PACKAGE_VERSION
RUN echo "${PACKAGE_VERSION}" >> /usr/local/tomcat/webapps/version.txt

RUN copy jenkinspipeline.war /usr/local/tomcat/webapps/
EXPOSE 8080
CMD ["catalina.sh", "run"]