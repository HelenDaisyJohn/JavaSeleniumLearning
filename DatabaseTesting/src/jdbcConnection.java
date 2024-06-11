import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbcConnection {
    public static void main(String[] args) {
        // Database connection parameters
        String host = "localhost";
        String port = "3306";
        String database = "qadbt";
        String user = "USER"; // Replace with your actual username
        String password = "PASSWORD"; // Replace with your actual password

        Connection con = null;
        Statement s = null;
        ResultSet rs = null;

        try {
            // Create a connection to the database
            con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, user, password);

            // Create a statement
            s = con.createStatement();

            // Execute a query
            rs = s.executeQuery("SELECT * FROM credentials WHERE scenario='sample'");

            // Process the result set
            while (rs.next()) {
                System.out.println("Username: " + rs.getString("username"));
                System.out.println("Password: " + rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (s != null) s.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
