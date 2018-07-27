FROM tomcat:8.0.38

# Place the code version inside the webapps directory
ARG PACKAGE_VERSION
RUN echo "${PACKAGE_VERSION}" >> /usr/local/tomcat/webapps/version.txt

COPY jenkinspipeline.jar /usr/local/tomcat/webapps/jenkinspipeline

EXPOSE 8080
CMD ["catalina.sh", "run"]