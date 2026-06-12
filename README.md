# 🧪 Teste de API – Reqres.in

Projeto de automação de testes de API desenvolvido em **Java** utilizando o **RestAssured**, **JUnit 5**, **Java Faker** e **Allure Report**.

---
## 🚀 Objetivo

Demonstrar a automação de testes em uma API pública (https://reqres.in) cobrindo operações do tipo **CRUD (Create, Read, Update, Delete)**, com geração de relatório interativo via **Allure Report**.

---
## 🧰 Tecnologias Utilizadas

- ☕ **Java 21**
- 🧩 **Maven**
- 🧪 **JUnit 5**
- 🔗 **RestAssured**
- 🧙 **Java Faker**
- 📊 **Allure Report**

---
## 🏗️ Estrutura do projeto (conforme repositório)
```text
Teste_Api
│
├── src
│ ├── test
│ │ ├── java
│ │ │ ├── configuracao/ # Configurações gerais (base URI, specs)
│ │ │ ├── dados/ # Geração de dados dinâmicos (Java Faker)
│ │ │ ├── modelo/ # Modelos de dados (User, etc)
│ │ │ ├── servicos/ # Requisições e métodos de serviço
│ │ │ └── testes/ # Casos de teste JUnit
│ │ └── resources/
│ │
│ └── allure-results/ # Resultados de execução (Allure)
│
├── pom.xml # Dependências do projeto
└── README.md
```
---
## 🧩 Casos de Teste implementados

| Nº | Caso | Nota |
|----|------|------|
| 1 | Consultar usuário pelo ID cadastrado | ✔️ |
| 2 | Consultar quantidade de usuários por página | ✔️ |
| 3 | Consultar ID inexistente (404) | ✔️ |
| 4 | Incluir novo usuário (POST) | ✔️ |
| 5 | Alterar nome de um usuário (PUT) | ✔️ |
| 6 | Deletar um usuário (DELETE) | ✔️ |

Observação: Não foi possível tratar outras exceções em virtude das limitações da API. 

---
## 📸 Relatório Allure (exemplos)

<img width="1348" height="635" alt="image" src="https://github.com/user-attachments/assets/31ab7990-3802-4b3d-9708-2ef2eb4edb0a" />

<img width="1348" height="635" alt="image" src="https://github.com/user-attachments/assets/c31a4696-672f-4411-82f7-26f858eea439" />

---
## ▶️ Como executar

```text
1. Clonar o repositório
git clone https://github.com/edmatos123/Teste_Api.git

2. Executar os testes
Na raiz do diretório abrir o CMD e executar o comando <mvn clean test>

3. Gerar o relatório
Executar o comando <allure serve allure-results>
```
---
## 👨‍💻 Autor

**Edmilson Matos Santana Júnior**

**Linkedin:** linkedin.com/in/edmilson-santana-3934b318b
