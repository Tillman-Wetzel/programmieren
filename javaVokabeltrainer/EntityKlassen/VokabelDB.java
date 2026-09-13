package EntityKlassen;

import java.sql.*;

public class VokabelDB {

    private Connection connection;

    public VokabelDB() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/vocabulary";
        String user = "vokabeluser";
        String password = "78952";

        connection = DriverManager.getConnection(url, user, password);
    }

    // 1. Gibt die Anzahl der Vokabelpaare zurück
    public int getAnzahlVokabeln() throws SQLException {
        String sql = "SELECT COUNT(*) FROM vokabeln";

        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet result = statement.executeQuery()) {

            if (result.next()) {
                return result.getInt(1);
            }
        }

        return 0;
    }

    // 2. Gibt ein Vokabelpaar anhand des Index zurück
    // [0] = Deutsch
    // [1] = Englisch
    public String[] getVokabelPaar(int index) throws SQLException {
        String sql = "SELECT deutsch, englisch FROM vokabeln ORDER BY id LIMIT 1 OFFSET ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, index);

            try (ResultSet result = statement.executeQuery()) {
                if (result.next()) {
                    return new String[] {
                        result.getString("deutsch"),
                        result.getString("englisch")
                    };
                }
            }
        }

        return null;
    }

    // Verbindung schließen
    public void close() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}