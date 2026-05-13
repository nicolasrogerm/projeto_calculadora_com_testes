Calculadora Spring Boot com Histórico e Testes desenvolvida como atividade da matéria Testes de Sistemas

Esta é uma aplicação Full Stack desenvolvida com Java e Spring Boot, que realiza operações matemáticas, armazena o histórico em um banco de dados em memória (H2) e fornece uma interface web amigável utilizando Thymeleaf.

O projeto foi construído seguindo boas práticas de programação, como o padrão Strategy (via Enums) para eliminar estruturas condicionais complexas e facilitar a manutenção.

  Tecnologias Utilizadas:

- Java 17

- Spring Boot 3

- Spring Data JPA: Para persistência de dados.

- H2 Database: Banco de dados em memória para desenvolvimento e testes.

- Thymeleaf: Motor de templates para o front-end.

- Bootstrap 5: Para estilização da interface.

- JUnit 5 & Mockito: Para testes unitários e de serviço.

- Maven: Gerenciador de dependências.

  Funcionalidades:
  
- Operações: Soma, Subtração, Multiplicação, Divisão.

- Funções avançadas: Porcentagem, Potência e Raiz Quadrada.

- Tratamento de exceções: Impede divisão por zero e raiz quadrada de números negativos.

- Persistência: Todas as operações são salvas automaticamente no banco de dados.

  Interface Web:

- Tela principal para cálculos com exibição do resultado atual.

- Tela exclusiva para consulta do histórico de operações.

  Arquitetura e Design:
  
- O projeto utiliza o padrão Strategy encapsulado em um Enum (TipoOperacao). Isso permite que cada operação matemática saiba como se calcular e como formatar sua própria expressão, mantendo a classe de serviço (CalculadoraService) limpa e aderente ao princípio de Responsabilidade Única (SOLID).

  Como Executar o Projeto:

1. Pré-requisitos:

- JDK 17 ou superior instalado.

- Maven instalado (ou use o wrapper ./mvnw).

2. Clonar o repositório:

- git clone https://github.com/seu-usuario/calculadora-springboot.git
- cd calculadora-springboot

3. Executar a aplicação:
   
- mvn spring-boot:run

5. Acessar no navegador:

- Aplicação: http://localhost:8080

- Console do Banco H2: http://localhost:8080/h2-console

- JDBC URL: jdbc:h2:mem:calculadoradb

- User: sa

- Password: (vazio)

  Como Rodar os Testes:
  
- Os testes foram desenvolvidos utilizando Mockito para simular o repositório, garantindo que a lógica de negócio seja testada de forma isolada e rápida.

  Para rodar os testes via terminal:
  
- mvn test

  Para rodar os testes No IntelliJ IDEA:

  1. Navegue até src/test/java/org/example/service/CalculadoraServiceTest.java.

  2. Clique no ícone de play verde ao lado da definição da classe.

 Atividade desenvolvida por: Nicolas Roger
