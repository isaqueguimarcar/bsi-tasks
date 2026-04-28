package com.exemplo;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        System.out.println("Conectado com Hibernate!");

        // 1. Inserir atividade em um projeto
        Projeto projeto = session.get(Projeto.class, 1);

        Atividade a1 = new Atividade(
                "Atividade via Hibernate",
                LocalDate.now(),
                null,
                projeto
        );

        session.persist(a1);
        System.out.println("INSERT realizado!");

        // 2. Atualizar líder do projeto
        projeto.setResponsavel(2);
        session.merge(projeto);
        System.out.println("UPDATE líder realizado!");

        // 3. Listar projetos e atividades
        List<Projeto> projetos = session.createQuery(
                "from Projeto", Projeto.class
        ).getResultList();

        System.out.println("\n=== PROJETOS E ATIVIDADES ===");

        for (Projeto p : projetos) {
            if (p.getAtividades() != null) {
                for (Atividade a : p.getAtividades()) {
                    System.out.println(
                            p.getCodigo() + " | " +
                            p.getNome() + " | " +
                            p.getResponsavel() + " | " +
                            a.getDescricao()
                    );
                }
            }
        }

        tx.commit();
        session.close();

        System.out.println("\nFim.");
    }
}