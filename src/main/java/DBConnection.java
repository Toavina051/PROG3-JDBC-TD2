import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public Connection getDBConnection() throws SQLException {

        String url = System.getenv("jdbc:postgresql://localhost:5432/mini_dish_db");
        String username = System.getenv("mini_dish_db_manager");
        String password = System.getenv("123456");

        if (url == null || username == null || password == null) {
            throw new RuntimeException("Variables d'environnement manquantes");
        }

        return DriverManager.getConnection(url, username, password);
    }

}