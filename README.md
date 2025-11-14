## 🏡 DemoCondomControl: Sistema de Controle de Condomínio

Este é o repositório do projeto desenvolvido para a disciplina de **Programação Server-Side**, seguindo as premissas de um sistema web completo com backend robusto.

## 🎯 Tema e Descrição do Projeto

### Tema

Sistema de Gerenciamento e Controle de Condomínio.

### Descrição

O **DemoCondomControl** é uma aplicação web desenvolvida para otimizar a administração de um condomínio residencial ou comercial. O sistema oferece uma interface para o gerenciamento centralizado de unidades, moradores e visitantes, garantindo que os dados sigam os requisitos de persistência e manipulação (CRUD) e oferecendo uma API RESTful para integração com outros serviços.

### Requisitos Atendidos (T1ESOFT03N)

| Requisito | Status | Observação |
| :--- | :--- | :--- |
| Equipe de até 5 alunos | **Em conformidade** | |
| Mínimo 1 serviço REST | **Implementado** | API REST para gerenciamento de Moradores (ou Visitantes). |
| Mínimo 1 CRUD com tela | **Implementado** | Cadastro de Unidades/Apartamentos com interface web (tela). |
| Utilizar arquitetura apresentada em sala | **Em conformidade** | Projeto segue a arquitetura em camadas (MVC). |

-----

## ✨ Funcionalidades Principais

O sistema é dividido nas seguintes áreas de gerenciamento:

1.  **Unidades/Apartamentos (CRUD Web - Tela):**
      * Cadastro, listagem, edição e exclusão de apartamentos/casas.
      * Informações incluem número/bloco e status da unidade.
2.  **Moradores (Serviço REST/API):**
      * Endpoint RESTful para manipulação (GET, POST, PUT, DELETE) dos dados dos moradores.
      * Relacionamento com a Unidade onde o morador reside.
3.  **Registro de Visitantes (CRUD):**
      * Controle de entrada e saída de visitantes, com registro da unidade visitada.
4.  **Autenticação:**
      * Sistema de login básico para acesso à área administrativa.

-----

## 🛠️ Tecnologias e Arquitetura

O projeto foi construído sobre uma arquitetura robusta, conforme as tecnologias apresentadas em aula, focando em Java para o *server-side*.

  * **Linguagem Backend:** Java (com suporte Maven)
  * **Framework Web:** Spring Boot (ou similar)
  * **Servidor:** Tomcat embarcado
  * **Persistência (ORM):** JPA / Hibernate
  * **Banco de Dados:** H2 (para desenvolvimento) / PostgreSQL (para produção)
  * **Frontend (Views):** HTML, CSS, JavaScript (pode ser Thymeleaf ou JSPs, se aplicável)
  * **Controle de Dependências:** Maven

-----

## ⚙️ Configuração e Execução do Projeto

Siga os passos abaixo para configurar e rodar o projeto em sua máquina local.

### Pré-requisitos

  * Java Development Kit (JDK) 17 ou superior.
  * Apache Maven 3.6+
  * Uma IDE (IntelliJ IDEA, Eclipse, VS Code).

### 1\. Clonar o Repositório

```bash
git clone https://github.com/maiacleberson/democondomcontrol.git
cd democondomcontrol
```

### 2\. Configurar o Banco de Dados (Opcional)

Se estiver usando um banco de dados externo (ex: PostgreSQL), edite o arquivo `src/main/resources/application.properties` (ou `application.yml`) com suas credenciais:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/condomcontrol_db
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
```

### 3\. Compilar e Executar o Projeto

Use o Maven para compilar e executar o projeto:

```bash
# Compila o projeto e roda os testes
mvn clean install

# Executa a aplicação Spring Boot
mvn spring-boot:run
```

A aplicação estará disponível em `http://localhost:8080`.

-----

## 🔗 Endpoints REST (API)

O serviço RESTful principal para o gerenciamento de Moradores está disponível em `/api/moradores`.

| Método | Endpoint | Descrição |
| :--- | :--- | :--- |
| `GET` | `/api/moradores` | Lista todos os moradores cadastrados. |
| `GET` | `/api/moradores/{id}` | Busca um morador específico por ID. |
| `POST` | `/api/moradores` | Cria um novo registro de morador. |
| `PUT` | `/api/moradores/{id}` | Atualiza um morador existente. |
| `DELETE` | `/api/moradores/{id}` | Exclui um morador. |

**Exemplo de requisição `POST` para `/api/moradores`:**

```json
{
  "nome": "João da Silva",
  "cpf": "123.456.789-00",
  "unidadeId": 1
}
```

-----

## 🧑‍💻 Equipe e Contribuição

| Integrante | Função |
| :--- | :--- |
| **Cleberson Maia** | **Líder/Backend** |
| **Cleberson Maia** | **Backend/Database** |
| **Alyson Lima** | **Frontend/UX** |
| **Alyson Lima** | **Documentação/Testes** |
| **Alyson Lima** | **Suporte** |

-----

*Developed as part of the Server-Side Programming Final Project.*
