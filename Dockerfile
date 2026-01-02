FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# install maven
RUN apk add --no-cache maven

COPY . .

RUN mvn clean package -DskipTests

EXPOSE 8080

CMD ["java", "-jar", "target/*.jar"]
