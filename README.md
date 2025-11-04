# UserAPI - API de Gestão de Utilizadores

Projeto desenvolvido como um teste técnico. Trata-se de uma API RESTful para realizar operações CRUD (Create, Read, Update, Delete) de utilizadores.

O projeto é construído com Java 17, Spring Boot e utiliza uma base de dados H2 em memória. A API também implementa segurança básica, garantindo que as senhas dos utilizadores sejam armazenadas de forma segura usando Spring Security (BCrypt).

## 🚀 Tecnologias Utilizadas

* **Java 17**
* **Spring Boot 3.x**
* **Spring Data JPA:** Para persistência de dados.
* **Spring Security:** Para encriptação (hashing) de senhas.
* **H2 Database:** Base de dados relacional em memória.
* **Maven:** Gestor de dependências e build do projeto.
* **Lombok:** Para reduzir código boilerplate (getters, setters, construtores).

## ✨ Funcionalidades

* **Criar** um novo utilizador (com senha encriptada).
* **Listar** todos os utilizadores.
* **Procurar** um utilizador específico por ID.
* **Atualizar** os dados de um utilizador.
* **Eliminar** um utilizador.

## ⚙️ Como Executar o Projeto

**Pré-requisitos:**

* **Java 17 (JDK)** instalado.
* **Maven** (normalmente já vem com o VS Code ou IntelliJ).

**Passos:**

1.  Clone o repositório:
    ```bash
    git clone [https://github.com/threg/userapi.git](https://github.com/threg/userapi.git)
    ```
2.  Navegue até à pasta do projeto:
    ```bash
    cd userapi
    ```
3.  Execute a aplicação usando o Maven Wrapper:
    * No **Windows** (via PowerShell ou CMD):
        ```bash
        .\mvnw.cmd spring-boot:run
        ```
    * No **Linux ou macOS**:
        ```bash
        ./mvnw spring-boot:run
        ```
4.  Pronto! A API estará a rodar e disponível em `http://localhost:8080`.

## Endpoints da API

Aqui estão os `endpoints` disponíveis para interagir com a API:

| Método | Endpoint | Descrição | Corpo (Body) de Exemplo |
| :--- | :--- | :--- | :--- |
| `GET` | `/api/users` | Lista todos os utilizadores. | N/A |
| `GET` | `/api/users/{id}` | Busca um utilizador por ID. | N/A |
| `POST` | `/api/users` | Cria um novo utilizador. | `{"name": "Seu Nome", "email": "email@teste.com", "password": "sua_senha_123"}` |
| `PUT` | `/api/users/{id}` | Atualiza um utilizador existente. | `{"name": "Nome Atualizado", "email": "email.novo@teste.com", "password": "nova_senha"}` |
| `DELETE`| `/api/users/{id}` | Elimina um utilizador. | N/A |

## 🧪 Como Testar

Pode utilizar qualquer cliente de API, como o **Postman** ou **Insomnia**, para testar os `endpoints`.

### Exemplo de teste com POST (Criar Utilizador)

* **Método:** `POST`
* **URL:** `http://localhost:8080/api/users`
* **Body:** Selecione `raw` e `JSON`.

---
**⭐ Dica de Teste Rápido (Postman)**

Para criar vários utilizadores de teste rapidamente, sem precisar editar manualmente o `email` (que é único), pode usar as **Variáveis Dinâmicas** do Postman.

Basta usar este JSON no seu Body. A cada clique em "Send", o Postman gerará dados aleatórios.

```json
{
    "name": "{{$randomFirstName}} {{$randomLastName}}",
    "email": "{{$randomEmail}}",
    "password": "{{$randomPassword}}"
}
