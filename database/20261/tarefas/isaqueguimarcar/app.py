from pymongo import MongoClient

# ==========================================
# CONEXÃO COM O MONGODB
# ==========================================

client = MongoClient(
    "mongodb://usuarioProj:senha123@localhost:27017/AtividadesProj?authSource=AtividadesProj"
)

# banco de dados
db = client["AtividadesProj"]

# coleções
projetos = db["projetos"]
atividades = db["atividades"]

print("Conectado ao MongoDB com sucesso!")

# ==========================================
# CREATE
# Inserir nova atividade
# ==========================================

nova_atividade = {
    "titulo": "Testar Sistema",
    "projeto": "Sistema Financeiro",
    "responsavel": "Maria Souza",
    "status": "Pendente"
}

atividades.insert_one(nova_atividade)

print("\n[CREATE] Nova atividade inserida!")

# ==========================================
# READ
# Listar projetos e atividades
# ==========================================

print("\n[READ] Projetos e suas atividades:\n")

for projeto in projetos.find():

    print(f"Projeto: {projeto['nome']}")
    print(f"Líder: {projeto['lider']}")

    print("Atividades:")

    lista_atividades = atividades.find({
        "projeto": projeto["nome"]
    })

    for atividade in lista_atividades:

        print(
            f" - {atividade['titulo']} "
            f"({atividade['status']})"
        )

    print("-" * 40)

# ==========================================
# UPDATE
# Atualizar líder do projeto
# ==========================================

projetos.update_one(
    {"nome": "Portal Acadêmico"},
    {"$set": {"lider": "Pedro Lima"}}
)

print("\n[UPDATE] Líder atualizado!")

# ==========================================
# DELETE
# Remover atividade
# ==========================================

atividades.delete_one({
    "titulo": "Desenvolver Interface"
})

print("\n[DELETE] Atividade removida!")

# ==========================================
# ENCERRAR CONEXÃO
# ==========================================

client.close()

print("\nConexão encerrada.")