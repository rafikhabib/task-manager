# Use official OpenJDK 17 base image
FROM openjdk:17-jdk-slim

# Set working directory in the container
WORKDIR /app

# Copy Maven wrapper and pom.xml
COPY pom.xml mvnw ./

# Copy the source code
COPY src ./src

# Build the application
RUN ./mvnw clean package -DskipTests

# Run the application
CMD ["java", "-jar", "target/backend-0.0.1-SNAPSHOT.jar"]

# Expose the application port
EXPOSE 8082
