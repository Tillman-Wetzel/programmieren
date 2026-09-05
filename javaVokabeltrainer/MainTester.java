import java.sql.SQLException;

import EntityKlassen.VokabelDB;

public class MainTester {
    public static void main(String[] args) {
        
        try {

            VokabelDB vokabelDB1 = new VokabelDB();
            System.out.println(vokabelDB1.getAnzahlVokabeln());
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
