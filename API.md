# 📌 API Tarefas

Api RESTful 

## 🌐 Base URL

```
http://localhost/tarefas
```

## 🔄 Endpoints

### 📥 Criar uma Tarefa

`POST /api/tarefas`

Cria uma nova tarefa.

**Request Body:**
```json
{
  "titulo": "Estudar Java",
  "descricao": "Revisar Optional e Streams",
}
```

**Response (201 Created):**
```json
{
  "id": 1,
  "titulo": "Estudar Java",
  "descricao": "Revisar Optional e Streams",
}
```

### 📃 Listar Tarefas

`GET /api/tarefas`

Retorna todas as tarefas.

**Response (200 OK):**
```json
[
  {
    "id": 1,
    "titulo": "Estudar Java",
    "descricao": "Revisar Optional e Streams",
  },
  {
    "id": 2,
    "titulo": "Comprar pão",
    "descricao": "Ir à padaria antes das 9h",
  }
]
```
### 📝 Atualizar Tarefa

`PUT /api/tarefas/{id}`

**Parâmetro na URL**
- `id` => ID da tarefa

Atualiza uma tarefa existente.

**Request Body:**
```json
{
  "titulo": "Estudar Spring Boot",
  "descricao": "Revisar JPA e Controllers",
}
```

**Response (200 OK):**
```json
{
  "id": 1,
  "titulo": "Estudar Spring Boot",
  "descricao": "Revisar JPA e Controllers",
}
```

**Erro (404 Not Found):**
```json
{
  "erro": "Tarefa não encontrada"
}
```

---

### ❌ Deletar Tarefa

`DELETE /api/tarefas/{id}`

Remove uma tarefa pelo ID.

**Response (204 No Content):**
Sem conteúdo.

**Erro (404 Not Found):**
```json
{
  "erro": "Tarefa não encontrada"
}
```

---

## ✅ Modelo de Dados

```json
{
  "id": 1,
  "titulo": "string",
  "descricao": "string",
}
```