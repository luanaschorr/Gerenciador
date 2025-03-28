import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    public static Connection getConnection(){
        try{
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/Estoque",
                    "postgres",
                    "postgreegay");
        } catch(SQLException e){
            System.out.println("Erro ao conectar com o banco: " + e.getMessage());
            return null;
        }
    }

}