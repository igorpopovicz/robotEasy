# Etapa de build - utilizando Maven 3.9.9 e Java 17
FROM maven:3.9.9-eclipse-temurin-17 as build

# Definir diretório de trabalho
WORKDIR /app

# Copiar os arquivos de projeto para o container
COPY pom.xml .
COPY src ./src

# Compilar o projeto usando Maven
RUN mvn clean package -DskipTests

# Etapa de execução - usando a imagem Eclipse Temurin com Java 17
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# Copiar o JAR gerado na etapa de build
COPY --from=build /app/target/robot_easy_api-0.0.1-SNAPSHOT.jar app.jar

# Expor a porta que será usada pela aplicação
EXPOSE 8080

# Executar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
