Para atender a solicitação do 'Desafio Técnico Saraiva', a aplicação usa :

Java 8
Spring Boot 2.0.1

É necessario ter instalado o Maven para executar a aplicação, através do seguinte comando :

mvnw spring-boot:run

O banco de dados utilizado foi o myslq 5.6 com os seguinte script de criação :

CREATE TABLE `book` (
  `sku` bigint(20) NOT NULL,
  `brand` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` decimal(19,2) DEFAULT NULL,
  PRIMARY KEY (`sku`)
  
As informações para alteração das configurações de acesso ao banco de dados e porta(80) se encontram em :

..\src\main\resources\application.properties   

para a execução dos testes, utilizar o seguinte comando :

mvn test





  


