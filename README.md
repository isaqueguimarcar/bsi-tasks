📊 Sistema de Gestão de Projetos e Atividades - Tarefa ODBC e ORM

Repositório destinado à implementação da atividade da disciplina de Projeto e Administração de Banco de Dados, utilizando JDBC (ODBC) e ORM (Hibernate) com PostgreSQL.

---

👤 Identificação

- Nome: Isaque Guimarães  
- Matrícula: 20240026493 
- Email: isaqueguimarcar@gmail.com e isaqueguimaraes388@gmail.com

---

🏗️ Estrutura do Projeto

O projeto está organizado da seguinte forma:

- java-jdbc/ → Implementação utilizando JDBC (acesso direto ao banco)
- orm-hibernate/ → Implementação utilizando Hibernate (ORM)
- tarefa-orm.md → Documentação da atividade

---

📄 Documentação da Atividade

As respostas teóricas e explicações da atividade estão disponíveis no arquivo:

👉 (https://github.com/isaqueguimarcar/bsi-tasks/blob/feat/tarefa-2/database/20252/tarefas/isaqueguimarcar/tarefa-orm.md)

---

⚙️ Execução

JDBC:
Executar a classe Main dentro da pasta java-jdbc. Execute o programa com o driver PostgreSQL no classpath:

javac Main.java
java -cp .:postgresql-42.7.3.jar Main

<<<<<<< Updated upstream
aaaa
# BSI Tasks
=======

ORM (Hibernate):
Executar via Maven:
>>>>>>> Stashed changes

mvn clean install
mvn exec:java -Dexec.mainClass="com.exemplo.Main"

---

🐘 Banco de Dados

Banco utilizado: AtividadesBD  
Tecnologias: PostgreSQL + Docker + PgAdmin  

---

✔️ Status

Projeto finalizado com as operações exigidas:

- INSERT ✔
- UPDATE ✔
- SELECT ✔
- JOIN ✔
- ORM ✔
