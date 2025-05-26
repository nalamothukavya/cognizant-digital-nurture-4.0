import java.sql.*;

public class JDBCInsertUpdate {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String user = "root";
        String password = "password";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            // Insert
            String insertSQL = "INSERT INTO students (id, name) VALUES (?, ?)";
            PreparedStatement insertStmt = conn.prepareStatement(insertSQL);
            insertStmt.setInt(1, 1);
            insertStmt.setString(2, "John Doe");
            insertStmt.executeUpdate();

            // Update
            String updateSQL = "UPDATE students SET name = ? WHERE id = ?";
            PreparedStatement updateStmt = conn.prepareStatement(updateSQL);
            updateStmt.setString(1, "Jane Doe");
            updateStmt.setInt(2, 1);
            updateStmt.executeUpdate();

            System.out.println("Insert and update completed.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
