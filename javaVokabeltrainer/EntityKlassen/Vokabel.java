package EntityKlassen;

public class Vokabel {
    private String ausgangssprache;
    private String zielsprache;
    private String ausgangswort;
    private String zielwort;

    Vokabel(String ausgangsspracheTemporaer, String zielspracheTemporaer) {
        ausgangssprache = ausgangsspracheTemporaer;
        zielsprache = zielspracheTemporaer;
    }

    public String getAusgangswort() {
        return ausgangswort;
    }

    public String getZielwort() {
        return zielwort;
    }

    public String getAusgangssprache() {
        return ausgangssprache;
    }

    public String getZielsprache() {
        return zielsprache;
    }

    public void generiereWort() {
        //setze Die Variable ausgangswort und zielwort auf ein rausgesuchtes Wort.
    }
}
