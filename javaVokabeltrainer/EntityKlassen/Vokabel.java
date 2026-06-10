package javaVokabeltrainer.EntityKlassen;

public class Vokabel {
    private static String ausgangssprache;
    private static String zielsprache;
    private static String ausgangswort;
    private static String zielwort;

    static void erstelleVokabel(String ausgangsspracheTemporaer, String zielspracheTemporaer) {
        ausgangssprache = ausgangsspracheTemporaer;
        zielsprache = zielspracheTemporaer;
    }

    public static String getWort() { // Singleton einbauen
        if (ausgangswort == null) {
            generiereWort();
        }
        
        return 
    }

    private static void generiereWort() {

    }
}
