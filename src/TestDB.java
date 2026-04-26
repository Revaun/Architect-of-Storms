import java.sql.*;

public class TestDB {
    public static void main(String[] args) {
        String host = System.getenv("DB_HOST");
        String user = System.getenv("DB_USER");
        String password = System.getenv("DB_PASSWORD");
        String db = System.getenv("DB_NAME");

        String url = "jdbc:mysql://" + host + ":3306/" + db;

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement()) {

            ResultSet rs = stmt.executeQuery("SELECT * FROM test_table;");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
