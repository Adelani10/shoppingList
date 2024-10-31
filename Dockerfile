FROM maven:3.9.8-eclipse-temurin-21 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM eclipse-temurin:21
COPY --from=build /target/shoppingList-0.0.1-SNAPSHOT.jar shoppingList.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","shoppingList.jar"]