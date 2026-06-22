package EntityKlassen;

public class Vokabel {
    private static String ausgangssprache;
    private static String zielsprache;
    private static String ausgangswort;
    private static String zielwort;

    Vokabel(String ausgangsspracheTemporaer, String zielspracheTemporaer) {
        ausgangssprache = ausgangsspracheTemporaer;
        zielsprache = zielspracheTemporaer;
    }

    public static String getWort() { // Singleton einbauen
        if (ausgangswort == null) {
            generiereWort();
        }
        
        return ausgangswort;
    }

    private static void generiereWort() {
        //setze Die Variable ausgangswort und zielwort auf ein rausgesuchtes Wort.
    }
}
