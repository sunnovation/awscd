FROM openjdk:17
WORKDIR /app
COPY ./target/emp.jar /app
EXPOSE 8087
CMD ["java","-jar","emp.jar"]