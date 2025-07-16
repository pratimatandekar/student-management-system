import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conn {
    // Change these according to your database setup
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe"; // Format: jdbc:oracle:thin:@host:port:SID
    private static final String USER = "system"; // e.g., system
    private static final String PASSWORD = "qwerty";

    // Method to get connection
    public static Connection getConnection() throws SQLException {
        Connection conn = null;
        try {
            // Load Oracle JDBC Driver
            Class.forName("oracle.jdbc.driver.OracleDriver");
            // Establish the connection
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to Oracle database successfully.");
        } catch (ClassNotFoundException e) {
            System.out.println("Oracle JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connection failed.");
            throw e;
        }
        return conn;
    }
}
