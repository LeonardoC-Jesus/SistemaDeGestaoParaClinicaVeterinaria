package banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BancoConexao {

    private static final String
            URL = "jdbc:postgresql://localhost:5432/clinica-veterinaria";

    private static final String
            USER = "postgres";

    private static final String
            PASSWORD = "admindb";

    public static Connection getConexao() {

        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Conexão feita com sucesso!!");
                return conn;
        } catch (SQLException e) {
            System.err.println("Erro ocorrido na Conexão!!");
            throw new RuntimeException(e);
        }
    }
}
