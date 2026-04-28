import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Main {

    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/atividadesbd";
        String user = "postgres";
        String password = "1234";

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Conectado com sucesso!");

            // =====================================
            // 1. INSERT - Atividade em um projeto
            // =====================================
            String sqlInsert = "INSERT INTO atividade (descricao, projeto, data_inicio, data_fim) VALUES (?, ?, ?, ?)";

            PreparedStatement insert = conn.prepareStatement(sqlInsert);

            insert.setString(1, "Atividade via Java JDBC");
            insert.setInt(2, 1);
            insert.setDate(3, java.sql.Date.valueOf("2018-10-01"));
            insert.setDate(4, null);

            insert.executeUpdate();
            System.out.println("INSERT realizado!");

            insert.close();

            // =====================================
            // 2. UPDATE - Líder do projeto
            // =====================================
            String sqlUpdate = "UPDATE projeto SET responsavel = ? WHERE codigo = ?";

            PreparedStatement update = conn.prepareStatement(sqlUpdate);

            update.setInt(1, 3); // novo líder
            update.setInt(2, 1); // projeto 1

            int linhas = update.executeUpdate();
            System.out.println("UPDATE realizado! Linhas afetadas: " + linhas);

            update.close();

            // =====================================
            // 3. SELECT - Atividades
            // =====================================
            System.out.println("\n=== LISTA DE ATIVIDADES ===");

            String sqlSelect = "SELECT codigo, descricao, projeto, data_inicio, data_fim FROM atividade";

            PreparedStatement select = conn.prepareStatement(sqlSelect);

            ResultSet rs = select.executeQuery();

            while (rs.next()) {
                System.out.println(
                        rs.getInt("codigo") + " | " +
                        rs.getString("descricao") + " | " +
                        rs.getInt("projeto") + " | " +
                        rs.getDate("data_inicio") + " | " +
                        rs.getDate("data_fim")
                );
            }

            rs.close();
            select.close();

            // =====================================
            // 4. JOIN - Projetos e suas atividades
            // =====================================
            System.out.println("\n=== PROJETOS E SUAS ATIVIDADES ===");

            String sqlJoin =
                    "SELECT p.codigo, p.nome, p.responsavel, " +
                    "a.codigo AS atividade_codigo, a.descricao, a.data_inicio, a.data_fim " +
                    "FROM projeto p " +
                    "LEFT JOIN atividade a ON a.projeto = p.codigo " +
                    "ORDER BY p.codigo";

            PreparedStatement joinStmt = conn.prepareStatement(sqlJoin);
            ResultSet rsJoin = joinStmt.executeQuery();

            while (rsJoin.next()) {
                System.out.println(
                        "Projeto: " + rsJoin.getInt("codigo") +
                        " | Nome: " + rsJoin.getString("nome") +
                        " | Responsável: " + rsJoin.getInt("responsavel") +
                        " | Atividade: " + rsJoin.getString("descricao")
                );
            }

            rsJoin.close();
            joinStmt.close();

            conn.close();

            System.out.println("\nFim da execução.");

        } catch (Exception e) {
            System.out.println("Erro:");
            e.printStackTrace();
        }
    }
}