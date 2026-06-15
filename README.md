#  Gerenciamento de Academia – API REST com Spring Boot

Este projeto consiste em uma **API REST** desenvolvida com **Java + Spring Boot** para gerenciamento de academias, incluindo controle de **Unidades**, **Alunos**, **Funcionários** e **Equipamentos**.  
O objetivo foi criar uma aplicação organizada, escalável e alinhada às boas práticas de arquitetura backend.

---

##  Tecnologias Utilizadas

- **Java 17**
- **Spring Boot**
  - Spring Web  
  - Spring Data JPA  
- **MySQL**
- **Hibernate / JPA**
- **Lombok**
- **Postman**
- **HTML + JavaScript** (cliente básico para testes nao incluso no repositorio)

---

##  Arquitetura do Projeto

A estrutura segue uma arquitetura em camadas:


- **Controller** → expõe endpoints REST  
- **Service** → lógica de negócio  
- **Repository** → comunicação com banco via JPA  
- **Model** → entidades do banco  
- **DTO** → usado em *Aluno* para esconder dados sensíveis  

---

##  Modelo do Banco de Dados

Entidades principais:

- `unidade`
- `aluno`
- `funcionario`
- `equipamento`

Relacionamentos:

- Todos usam **ManyToOne** com **Unidade**

---

> Este projeto demonstra a base para criação de APIs REST simples e escaláveis com Spring Boot.
