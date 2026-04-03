import java.sql.*;
import java.util.ArrayList;

public class JdbcApp2 {
    private static String currentDatabase = "myDatabase";
    static ArrayList<String> result = new ArrayList<>();

    public static String getCurrentDatabase() {
        return currentDatabase;
    }

    public static void setCurrentDatabase(String newDatabase) {
        currentDatabase = newDatabase;
    }

    @SuppressWarnings({"ConvertToTryWithResources", "CallToPrintStackTrace"})
    public static ArrayList<String> runCommand(String command) {
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + currentDatabase, "root", "78952");
            Statement stmt = con.createStatement();
            String query = command; 
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                result.add("");
            }

            rs.close();
            stmt.close();
            con.close();
        } 
        catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
            System.out.println("SQL State: " + e.getSQLState());
            System.out.println("Vendor Error: " + e.getErrorCode());
        } 
        catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found.");
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}