
# 📝 Projeto de Gerenciamento de Tarefas

Este é um CRUD simples em Spring Boot que criei para gerenciamento de tarefas.

## 📄 Documentação da API

Acesse o arquivo de documentação da API em API.md

## ⚙️ Funcionalidades (via api ou front-end embutido)

- Criar tarefas
- Editar tarefas
- Excluir tarefas
- Listar tarefas

## 📦 Tecnologias Utilizadas

- Java 21
- Spring Boot 3.4.5
- H2 Database
- HTML, CSS (Bootstrap) e JavaScript


## ▶️ Como Executar o Projeto

### 1. Clone o repositório

```bash
git clone https://github.com/jv-Max04/SpringCRUD.git
cd SpringCRUD
```

### 2. Backend (Spring Boot)

#### Pré-requisitos:
- Java 21

#### Executando:

> [!CAUTION]
> A porta padrão do aplicativo está definida como 80, caso ela esteja ocupada, altere esse valor em: `src/main/resources/application.properties`

<br>
<br>

Abra seu terminal, entre no diretório raiz do códgigo e utilize o comando: 
```bash
./mvnw spring-boot:run
```
<br>

O projeto renderiza uma página HTML para controle em:
```
http://localhost
```
<br>

Os endpoints da API estarão acessíveis em:
```
http://localhost/tarefas
```


## 🧪 Testando o Projeto

1. Acesse a interface no navegador (http://localhost ou http://127.0.01).
2. Adicione tarefas usando o formulário.
3. Veja a lista de tarefas sendo renderizada automaticamente.
4. Utilize os botões “Editar” e “Excluir” para interagir com as tarefas.
5. Atuailize a página para testar a persistência das informações.

## 💾 Banco de Dados

- Banco em memória: H2
- Console acessível em: `http://localhost/h2`
- JDBC URL padrão: `jdbc:h2:mem:testdb`
- Usuário padraõ: `sa`
- Usuário sem senha por padrão.


## 👤 Autor

Desenvolvido por [João Victor](https://github.com/jv-Max04).
