# Use official OpenJDK 17 base image
FROM openjdk:17-jdk-slim

# Install Maven
RUN apt-get update && \
    apt-get install -y maven && \
    rm -rf /var/lib/apt/lists/*
    
# Set working directory in the container
WORKDIR /app

# Copy Maven wrapper and pom.xml
COPY pom.xml mvnw ./

# Copy the source code
COPY src ./src

# Set execute permissions for the mvnw script
RUN chmod +x ./mvnw

# Generate Maven wrapper files
RUN mvn -N wrapper:wrapper

# Build the application
RUN ./mvnw clean package -DskipTests

# Run the application
CMD ["java", "-jar", "target/backend-0.0.1-SNAPSHOT.jar"]

# Expose the application port
EXPOSE 8082
