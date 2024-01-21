# Projeto de conclusão de fase de módulo de curso.
Construção de um sistema de parquimetro

Desafio Tecnológico na Pós-Graduação: Explorando Inovações e Soluções Na Fiap Curso de Pós Graduação de Arquitetura e desenvolvimento Java propõe na segunda fase do curso o desenvolvimento de um sistema WEB, com interfaces e APIS, para cadastro de cliente, endereços, veiculos e gerenciamneto de estacionamento - (Parquimetro), com a finalidade de calcular o consumo durante o periodo de utilização da vaga, assim como escolher formas de pagamentos entre PIX, cartão de crédito ou de débito. A API foi desenvolvida com as tecnologias Spring Boot, Java17, Maven e banco de dados interno h2. e banco de dados Postgres em nuvem no Docker o objetivo de uma solução pratica com a utilização de endpoints para realização de operações  de criação, atualização e recuperação de registros. 
## Equipe:

* Lucas Silva 
* Gustavo Dumitresco 
* Helio Nascimento 
* Guilherme 

### Índice

1. [Stack de desenvovimento Utilizado](#tecnologias)
2. [Plataformas e ferramentas](#ferramentas)
3. [Documentação](/DOCUMENTACAO.md)
4. [Licença](#licença)

### Tecnologias

Tecnologias utilizadas durante o desenvolvimento do projeto.

| Item .......................................                                            | Descrição                                                                                                                                                                                                                      |
|-----------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| 1. [Java 17](https://docs.oracle.com/en/java/javase/17/docs/api/)                       | Linguagem de programação escolhida para implementar a lógica do sistema, garantindo confiabilidade, segurança e escalabilidade.                                                                                                |
| 2. [Spring Boot](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/) | Utilizado como framework para agilizar o desenvolvimento da API, oferecendo recursos como injeção de dependências, mapeamento de URLs, tratamento de requisições HTTP e muito mais.                                            |
| 3. [h2](https://www.postgresql.org/docs/)                                               | Banco de dados utilizado para armazenar e gerenciar as informações relacionadas a eletrodomésticos, endereços e pessoas. O PostgreSQL é conhecido por sua robustez e confiabilidade, adequado para aplicações de larga escala. |
| 4. [PostgreSQL](https://www.postgresql.org/docs/)                                       | Banco de dados utilizado para armazenar e gerenciar as informações relacionadas a eletrodomésticos, endereços e pessoas.                                                                                                       |
| 5. [Maven](https://maven.apache.org/guides/index.html)                                  | Gerenciador de dependências utilizado para facilitar a configuração e o gerenciamento das bibliotecas e dependências do projeto.                                                                                               |

### Ferramentas

#### [Eclipse IDE](https://eclipseide.org)
Ambiente de desenvolvimento integrado (IDE) utilizado para escrever, depurar e testar o código-fonte do projeto. O Eclipse possui recursos avançados de produtividade que facilitãoo desenvolvimento em Java e agiliza o processo de construção da API's.
#### [Postman](https://www.postman.com/)
Plataforma de colaboração e testes de API que permite enviar e receber solicitações HTTP, testar os endpoints da API, verificar as respostas e realizar a depuração de forma eficiente.
#### [Git](https://git-scm.com/doc)
Sistema de controle de versão utilizado para rastrear alterações no código-fonte, facilitando o trabalho em equipe, o versionamento e a colaboração no projeto.
#### [GitHub](https://github.com/)
Plataforma de hospedagem de repositórios de controle de versão Git, utilizada para armazenar e gerenciar o código-fonte do projeto. O GitHub permite o trabalho colaborativo, controle de versões, rastreamento de alterações e facilita a integração com ferramentas de desenvolvimento.
#### [Docker](https://www.docker.com/products/docker-desktop/)
Software de conteinização para desenvolvedores, possibilitando o empacotamento de uma aplicação ou ambiente dentro de um container, se tornando portátil para qualquer outro host que contenha o Docker instalado. Então, você consegue criar, implantar, copiar e migrar de um ambiente para outro com maior flexibilidade.

### Estruturas de Bancos de dados utilizados no Projeto

### Modelo de Banco de dados h2 Executado ao Subir a aplicação no Eclipse.

1. Tabelas Criadas no banco de dados H2 após subir a aplicação no Eclipse

2. Consutas realizadas no banco de dados h2 após inserção de dados utilizando o metodo Post através do Postman
  
   ## Consulta de Clientes banco de dados h2

   ## Consulta de Endereços banco de dados h2

   ## Consulta de Veiculos banco de dados h2

   ## Consulta Parquimetro banco de dados h2

### Passos para a execução do projeto utilizando PostgreSQL

1. Instale o Docker Desktop e configure o PostgreSQL: 

##### *Script para subir meu servidor e banco postgres no docker via terminal powershell* <br/><br/>
```   
version: "3.7"
services:
  # ====================================================================================================================
  # POSTGRES SERVER
  # ====================================================================================================================
  pg-docker:
    image: postgres:14-alpine
    container_name: park-postgresql
    environment:
      POSTGRES_DB: mydatabase
      POSTGRES_PASSWORD: 1234567
    ports:
      - 5433:5432
    volumes:
      - ./.data/postgresql/data:/var/lib/postgresql/data
    networks:
      - ed-network
  # ====================================================================================================================
  # PGADMIN
  # ====================================================================================================================
  pgadmin-docker:
    image: dpage/pgadmin4
    container_name: park-pgadmin
    environment:
      PGADMIN_DEFAULT_EMAIL: me@example.com
      PGADMIN_DEFAULT_PASSWORD: 1234567
    ports:
      - 5050:80
    volumes:
      - ./.data/pgadmin:/var/lib/pgadmin
    depends_on:
      - pg-docker
    networks:
      - ed-network
# ======================================================================================================================
# REDE
# ======================================================================================================================
networks:
  ed-network:
    driver: bridge
```
#### *Passos para realizar após a execução do script pelo powershell* <br/><br/>

2. Execute e inicialize os serviços na sua máquina com o DockerDesktop 

3. Execute o Postgres através do endereço![Logo do Markdown](img/markdown.png) http://localhost:5050/browser/

4. Criando Tabelas no banco de dados Postgres

4. Visualizando Base, schemas, tabelas e relacionamentos.

5. Consultas de tabelas no Postgres em nuvem pelo servidor PgAdmin. 
   
   ## Consulta de Clientes banco de dados Postgres

   ## Consulta de Endereços banco de dados Postgres

   ## Consulta de Veiculos banco de dados Postgres

   ## Consulta Parquimetro banco de dados Postgres


## Licença

[Licença MIT](https://opensource.org/license/mit/): permite o uso, a modificação e a distribuição do software sem restrições significativas.

