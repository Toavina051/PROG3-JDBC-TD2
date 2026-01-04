import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public Connection getDBConnection() throws SQLException {

        String url = ("jdbc:postgresql://localhost:5432/mini_dish_db");
        String username = ("mini_dish_db_manager");
        String password = ("123456");

        if (url == null || username == null || password == null) {
            throw new RuntimeException("Variables d'environnement manquantes");
        }

        return DriverManager.getConnection(url, username, password);
    }
}