package estoque;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBanco {
    private static final String URL = "jdbc:postgresql://localhost:5432/Estoquee";
    private static final String USUARIO = "postgres";
    private static final String SENHA = "eloisa1108";

    private static Connection conexao;

    public static Connection getConexao() throws SQLException {
        try {   
            Class.forName("org.postgresql.Driver");

            if (conexao == null || conexao.isClosed()) {
                conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            }
        } catch (ClassNotFoundException e) {
            System.out.println("ERRO: Driver JDBC do PostgreSQL não encontrado!");
            e.printStackTrace();
        }

        return conexao;
    }

    public static void fecharConexao() throws SQLException {
        if (conexao != null && !conexao.isClosed()) {
            conexao.close();
        }
    }
}