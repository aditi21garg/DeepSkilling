import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentDAO {
    private static final String URL = "jdbc:sqlite:students.db";

    public void insertStudent(int id, String name, int age) {
        String sql = "INSERT INTO students (id, name, age) VALUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setInt(3, age);
            ps.executeUpdate();

            System.out.println("Student inserted successfully.");

        } catch (SQLException e) {
            System.out.println("Error inserting student: " + e.getMessage());
        }
    }

    public void updateStudent(int id, String newName, int newAge) {
        String sql = "UPDATE students SET name = ?, age = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, newName);
            ps.setInt(2, newAge);
            ps.setInt(3, id);
            ps.executeUpdate();

            System.out.println("Student updated successfully.");

        } catch (SQLException e) {
            System.out.println("Error updating student: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();

        dao.insertStudent(1, "Alice", 20);
        dao.insertStudent(2, "Bob", 22);

        dao.updateStudent(1, "Alice Smith", 21);
    }
}