# Tarefa - ODBC e ORM

**Aluno:** Isaque Guimarães  
**Repositório:** https://github.com/isaqueguimarcar/bsi-tasks   

---

# 1. Introdução

Esta atividade tem como objetivo implementar o acesso a um banco de dados relacional utilizando duas abordagens:

- ODBC/JDBC (acesso direto ao banco)
- ORM (mapeamento objeto-relacional com Hibernate)

O banco utilizado é o **AtividadesBD**, executado via PostgreSQL em ambiente Docker, com gerenciamento pelo PgAdmin.

---

# 2. Banco de Dados

PgAdmin executado via Docker para gerenciamento do PostgreSQL. O banco de dados utilizado foi o **AtividadesBD**, contendo as tabelas principais:

- projeto
- atividade

O ambiente foi configurado utilizando:

- Docker (PostgreSQL)
- PgAdmin

--- 


# 3. ODBC / JDBC (Acesso Direto ao Banco)

## Descrição

O ODBC (Open Database Connectivity), na prática Java, é representado pelo JDBC (Java Database Connectivity), que permite conexão direta com o banco de dados através de drivers.

Nesta implementação, foi utilizado o driver JDBC do PostgreSQL para realizar operações SQL diretamente.

---

## Operações realizadas

- Inserção de uma atividade em um projeto
- Atualização do líder de um projeto
- Listagem de projetos e atividades
- Consulta com JOIN entre projeto e atividade

---

## Código fonte

java-jdbc/

---

## Principais funcionalidades

- Connection via DriverManager
- PreparedStatement
- ResultSet
- Execução direta de SQL

---

# 4. ORM (Hibernate)

## Descrição

ORM (Object-Relational Mapping) é uma técnica que permite mapear tabelas do banco de dados em classes Java.

Nesta atividade foi utilizado o framework Hibernate ORM.

Ele automatiza o acesso ao banco, eliminando a necessidade de SQL manual na maioria das operações.

---

## Operações realizadas

- Inserção de atividade
- Atualização de projeto
- Listagem de dados
- Relacionamentos entre entidades

---

## Entidades utilizadas

- Projeto
- Atividade

---

## Código fonte

orm-hibernate/

---

## Configuração

src/main/resources/hibernate.cfg.xml

---

## Framework utilizado

- Hibernate ORM 6.4.4.Final
- Jakarta Persistence API
- PostgreSQL Driver

---

# 5. Comparação ODBC (JDBC) vs ORM

## JDBC

- Controle total do SQL
- Mais verboso
- Maior esforço de codificação
- Mais próximo do banco

## ORM (Hibernate)

- Abstração do banco
- Menos SQL manual
- Mais produtividade
- Código mais limpo e orientado a objetos

---

# 6. Estrutura do Projeto

database/
 └── 20252/
     └── tarefas/
         └── isaqueguimarcar/
             ├── tarefa-orm.md
             ├── java-jdbc/
             └── orm-hibernate/

---

# 7. Links do projeto

JDBC:
https://github.com/isaqueguimarcar/bsi-tasks/tree/feat/tarefa-2/database/20252/tarefas/isaqueguimarcar/java-jdbc

ORM:
https://github.com/isaqueguimarcar/bsi-tasks/tree/feat/tarefa-2/database/20252/tarefas/isaqueguimarcar/orm-hibernate

---

# 8. Conclusão

A utilização de JDBC permite maior controle direto sobre o banco de dados, enquanto o Hibernate (ORM) facilita o desenvolvimento ao abstrair a camada de persistência.

Ambas as abordagens são importantes para compreender diferentes níveis de acesso a dados em aplicações Java.
