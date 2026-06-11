FROM maven:3.9.9-eclipse-temurin-21

WORKDIR /app

COPY . .

RUN mvn dependency:resolve

CMD ["mvn", "clean", "test"]