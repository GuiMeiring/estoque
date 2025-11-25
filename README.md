# 📦 Sistema de Controle de Estoque – Spring Boot

Projeto desenvolvido para o **Trabalho Final de Programação Server-Side**, utilizando **Spring Boot**, **Thymeleaf**, **JPA/Hibernate**, **REST API** e **Banco H2 em arquivo**.

---

## 🚀 Tecnologias utilizadas
- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA
- Thymeleaf
- Banco H2 (persistente em arquivo)
- Maven

---

## 📁 Estrutura do Projeto
```
src/
 ├── main/java/br/org/catolicasc/estoque
 │   ├── controller     → Controllers MVC e REST
 │   ├── model          → Entidades JPA
 │   ├── repository     → Repositórios Spring Data
 │   ├── service        → Lógica de negócio
 │   └── EstoqueApplication.java
 └── main/resources
     ├── templates      → Telas Thymeleaf (CRUD)
     ├── static         → CSS/JS
     └── application.properties
```

---

# ▶️ Como executar o projeto

### **1. Clonar o repositório**
```bash
git clone https://github.com/GuiMeiring/estoque.git
cd estoque
```

### **2. Rodar com Maven**
```bash
mvn spring-boot:run
```

### **3. Acessar a aplicação (telas Thymeleaf)**
Abra no navegador:

👉 **http://localhost:8080**

---

# 🧪 Como executar os testes

### **Rodar todos os testes**
```bash
mvn test
```

### **Rodar um teste específico**
```bash
mvn -Dtest=ProdutoTest test
```

Os testes utilizam o **SpringBootTest** e acessam o repositório com H2 em memória ou arquivo, dependendo da configuração.

---

# 🗄️ Acessando o banco H2

### **1. Console H2**
Após subir a aplicação:

👉 **http://localhost:8080/h2-console**

### **2. Configuração de acesso**
Use:

```
JDBC URL: jdbc:h2:file:./data/estoque_db
User: sa
Password: password
```

### **3. Visualizar tabelas**
No console H2:
- Selecionar o schema `PUBLIC`
- Abrir a aba **Tables**

---

# 🌐 API REST (exemplos)

Os endpoints REST seguem o padrão `/api/produtos`.

### **GET – Listar todos**
```http
GET /api/produtos
```

### **GET – Buscar por ID**
```http
GET /api/produtos/{id}
```

### **POST – Criar**
```http
POST /api/produtos
Content-Type: application/json

{
  "nome": "Teclado",
  "preco": 120.0,
  "quantidade": 10
}
```

### **PUT – Atualizar**
```http
PUT /api/produtos/{id}
```

### **DELETE – Remover**
```http
DELETE /api/produtos/{id}
```

---

# 🖥️ CRUD com Thymeleaf

As telas seguem o padrão MVC:

| Rota | Descrição |
|------|-----------|
| `/produtos` | Lista de produtos |
| `/produtos/novo` | Formulário de criação |
| `/produtos/editar/{id}` | Edição |
| `/produtos/excluir/{id}` | Remoção |

Telas localizadas em:

```
src/main/resources/templates/produtos/
```

---

# 📘 Trabalho Final – Informações

### **TEMA DO PROJETO**  
Sistema Web de Controle de Estoque

### **DESCRIÇÃO**  
Aplicação web para cadastro, gerenciamento, movimentação e controle de produtos em estoque.  
Inclui interface com Thymeleaf, API REST para integração externa e persistência em banco H2.

### **EQUIPE / INTEGRANTES**  
- Guilherme Franciel Meiring
- Iago Henrique Pinto Bogler
- Johnatan Vargas da Fonseca

---

# 📄 Licença
Projeto acadêmico – uso livre para fins educacionais.
