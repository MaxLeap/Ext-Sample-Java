FROM 10.10.10.160:8010/ilegendsoft/jdk8:latest
RUN mkdir /opt/ext-sample-java
WORKDIR /opt/ext-sample-java
ADD ext-sample-java-*.jar ./lext-sample-java-latest.jar

ENTRYPOINT ["java","-jar","./lext-sample-java-latest.jar"]