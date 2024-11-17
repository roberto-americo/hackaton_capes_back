# Back-End Risc

Hackaton CAPES 2024

Desafio Portal De Periódicos Da CAPES

Projeto desenvolvido em Java 17, utilizando Maven e SpringBoot.

Necessário:
    Java jdk 17

Para executar o projeto:
    mvn clean install
    mvn spring-boot:run4
    
Base de dados H2 em tempo de execução com arquivo, o arquivo encontra-se na pasta ./data

Para gerar nova base de dados, utilizar ./src/main/resources/output.csv como exemplo e executar a url http://localhost:8080/data/load-from-csv

Frontend: https://github.com/roberto-americo/hackaton_capes_front