FROM zhuozhuang/java:1.8-glibc

RUN mkdir -p /opt/app
ENV PROJECT_HOME /opt/app
COPY /target/helium-fast.jar $PROJECT_HOME/app.jar

WORKDIR $PROJECT_HOME
EXPOSE 8081
CMD ["java" ,"-jar","./app.jar"]

