# Tarefa Individual - MongoDB

## Disciplina
Projeto e Administração de Banco de Dados

## Aluno
Isaque Guimarães Carreiro

## Matrícula
20240026493 

## Email
isaqueguimaraes388@gmail.com

---

# Arquivos do Projeto

## Programa Python

[app.py](./app.py)

## Script de Inicialização do Banco

[init.js](./init.js)

## Configuração Docker

[docker-compose.yml](./docker-compose.yml)



# 1. Introdução ao MongoDB

O MongoDB é um Sistema Gerenciador de Banco de Dados NoSQL orientado a documentos. Diferente dos bancos relacionais tradicionais, o MongoDB armazena os dados em documentos no formato BSON (Binary JSON), permitindo maior flexibilidade na modelagem e manipulação dos dados.

Entre suas principais características estão:

- Estrutura flexível de documentos;
- Alta escalabilidade;
- Alta disponibilidade;
- Facilidade de integração com aplicações modernas;
- Suporte a replicação de dados;
- Alto desempenho em operações de leitura e escrita.

No MongoDB, os dados são organizados em bancos de dados, coleções e documentos.

---

# 2. Configuração do MongoDB com Docker

Para execução do MongoDB foi utilizado Docker Compose.

## Arquivo docker-compose.yml

```yaml
services:
  mongodb:
    image: mongo:latest
    container_name: mongodb

    restart: always

    ports:
      - "27017:27017"

    environment:
      MONGO_INITDB_ROOT_USERNAME: admin
      MONGO_INITDB_ROOT_PASSWORD: admin123

    volumes:
      - mongo_data:/data/db

volumes:
  mongo_data:
```

## Comando para iniciar o container

```bash
docker compose up -d
```

---

# 3. Criação do Banco de Dados

Foi criado o banco de dados chamado:

```txt
AtividadesProj
```

Também foi criado um usuário com permissões de leitura e escrita.

## Comando utilizado

```javascript
use AtividadesProj

db.createUser({
  user: "usuarioProj",
  pwd: "senha123",
  roles: [
    {
      role: "readWrite",
      db: "AtividadesProj"
    }
  ]
})
```

---

# 4. Alta Disponibilidade e Replica Sets

## 4.1 O que é um Replica Set

Replica Set é um mecanismo do MongoDB responsável por fornecer alta disponibilidade e tolerância a falhas através da replicação de dados entre múltiplos servidores MongoDB.

Nesse modelo, os dados são copiados automaticamente entre os membros do conjunto, garantindo que o sistema continue funcionando mesmo em caso de falha de um servidor.

O Replica Set permite maior confiabilidade para aplicações críticas, evitando indisponibilidade do banco de dados.

---

## 4.2 Papéis dos membros do Replica Set

### Primary (Primário)

O membro primário é responsável por receber todas as operações de escrita e atualização do banco de dados.

Os dados recebidos pelo primário são replicados automaticamente para os demais membros do Replica Set.

Existe apenas um membro primário ativo por vez.

---

### Secondary (Secundário)

Os membros secundários mantêm cópias idênticas dos dados do primário através do processo de replicação.

Eles podem assumir o papel de primário caso o servidor principal falhe.

Além disso, secundários podem ser utilizados para operações de leitura, reduzindo a carga do servidor principal.

---

### Arbiter

O arbiter não armazena dados e não participa da replicação.

Sua única função é participar das votações para eleição de um novo primário em caso de falha.

O uso do arbiter ajuda a evitar empates durante o processo de eleição.

---

# 4.3 Configuração de Replica Set com Docker

Para transformar o ambiente inicial em um Replica Set de três membros, seria necessário criar múltiplos containers MongoDB executando com a opção `--replSet`.

## Exemplo de docker-compose.yml

```yaml
services:

  mongo1:
    image: mongo:latest
    container_name: mongo1
    command: mongod --replSet rs0

    ports:
      - "27017:27017"

  mongo2:
    image: mongo:latest
    container_name: mongo2
    command: mongod --replSet rs0

    ports:
      - "27018:27017"

  mongo3:
    image: mongo:latest
    container_name: mongo3
    command: mongod --replSet rs0

    ports:
      - "27019:27017"
```

---

# 4.4 Inicialização do Replica Set

Após iniciar os containers com Docker Compose, seria necessário acessar um dos containers MongoDB:

```bash
docker exec -it mongo1 mongosh
```

Em seguida, executar o comando de inicialização do Replica Set:

```javascript
rs.initiate({
  _id: "rs0",
  members: [
    { _id: 0, host: "mongo1:27017" },
    { _id: 1, host: "mongo2:27017" },
    { _id: 2, host: "mongo3:27017" }
  ]
})
```

Para verificar o status do Replica Set:

```javascript
rs.status()
```

---

# 5. Conclusão

Durante esta atividade foi possível configurar um ambiente MongoDB utilizando Docker, criar bancos de dados e coleções, inserir documentos e desenvolver operações CRUD utilizando Python.

Também foi possível compreender conceitos importantes relacionados à alta disponibilidade no MongoDB, especialmente através do uso de Replica Sets, mecanismo fundamental para sistemas robustos e tolerantes a falhas.