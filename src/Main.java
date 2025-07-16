import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            Connection conn = Conn.getConnection();

            if (conn != null) {
                System.out.println("🎉 Connection object created successfully!");
                conn.close();
            } else {
                System.out.println("⚠️ Failed to create connection object.");
            }

        } catch (SQLException e) {
            System.out.println("⚠️ SQLException occurred.");
            e.printStackTrace();
        }
    }
}
