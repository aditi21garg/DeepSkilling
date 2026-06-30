import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionHandling {
    private static final String URL = "jdbc:sqlite:bank.db";

    public static void setupAccounts() throws SQLException {
        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement()) {

            stmt.execute("CREATE TABLE IF NOT EXISTS accounts (id INTEGER PRIMARY KEY, balance REAL)");
            stmt.execute("DELETE FROM accounts");
            stmt.execute("INSERT INTO accounts (id, balance) VALUES (1, 1000)");
            stmt.execute("INSERT INTO accounts (id, balance) VALUES (2, 500)");
        }
    }

    public static void transfer(int fromId, int toId, double amount) {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(URL);
            conn.setAutoCommit(false);

            PreparedStatement debit = conn.prepareStatement(
                    "UPDATE accounts SET balance = balance - ? WHERE id = ?");
            debit.setDouble(1, amount);
            debit.setInt(2, fromId);
            debit.executeUpdate();

            PreparedStatement credit = conn.prepareStatement(
                    "UPDATE accounts SET balance = balance + ? WHERE id = ?");
            credit.setDouble(1, amount);
            credit.setInt(2, toId);
            credit.executeUpdate();

            conn.commit();
            System.out.println("Transfer successful.");

        } catch (SQLException e) {
            System.out.println("Transfer failed, rolling back: " + e.getMessage());
            try {
                if (conn != null) conn.rollback();
            } catch (SQLException ex) {
                System.out.println("Rollback failed: " + ex.getMessage());
            }
        } finally {
            try {
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("Error closing connection: " + e.getMessage());
            }
        }
    }

    public static void printBalances() throws SQLException {
        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement()) {

            var rs = stmt.executeQuery("SELECT * FROM accounts");
            while (rs.next()) {
                System.out.println("Account " + rs.getInt("id") + ": " + rs.getDouble("balance"));
            }
        }
    }

    public static void main(String[] args) throws SQLException {
        setupAccounts();

        System.out.println("Before transfer:");
        printBalances();

        transfer(1, 2, 200);

        System.out.println("After transfer:");
        printBalances();
    }
}
