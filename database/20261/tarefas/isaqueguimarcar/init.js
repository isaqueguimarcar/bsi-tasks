use("AtividadesProj")

db.empregados.insertMany([
  {
    nome: "João Silva",
    cargo: "Desenvolvedor",
    email: "joao@email.com"
  },
  {
    nome: "Maria Souza",
    cargo: "Analista",
    email: "maria@email.com"
  },
  {
    nome: "Pedro Lima",
    cargo: "Gerente",
    email: "pedro@email.com"
  }
])

db.projetos.insertMany([
  {
    nome: "Sistema Financeiro",
    lider: "Pedro Lima",
    setor: "TI"
  },
  {
    nome: "Portal Acadêmico",
    lider: "Maria Souza",
    setor: "Educação"
  },
  {
    nome: "Aplicativo Mobile",
    lider: "João Silva",
    setor: "Mobile"
  }
])

db.atividades.insertMany([
  {
    titulo: "Criar API",
    projeto: "Sistema Financeiro",
    responsavel: "João Silva",
    status: "Em andamento"
  },
  {
    titulo: "Modelar Banco",
    projeto: "Portal Acadêmico",
    responsavel: "Maria Souza",
    status: "Concluído"
  },
  {
    titulo: "Desenvolver Interface",
    projeto: "Aplicativo Mobile",
    responsavel: "Pedro Lima",
    status: "Pendente"
  }
])