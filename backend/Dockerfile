FROM openjdk:17-jdk-slim

RUN apt-get update && \
    apt-get install -y maven && \
    rm -rf /var/lib/apt/lists/*
    
WORKDIR /app

COPY pom.xml mvnw ./

COPY src ./src

RUN chmod +x ./mvnw

RUN mvn -N wrapper:wrapper

RUN ./mvnw clean package -DskipTests

CMD ["java", "-jar", "target/backend-0.0.1-SNAPSHOT.jar"]

EXPOSE 8082
