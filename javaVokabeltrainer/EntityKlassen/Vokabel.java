package javaVokabeltrainer.EntityKlassen;

public class Vokabel {
    private static String ausgangssprache;
    private static String zielsprache;

    static void erstelleVokabel(String ausgangsspracheTemporaer, String zielspracheTemporaer) {
        ausgangssprache = ausgangsspracheTemporaer;
        zielsprache = zielspracheTemporaer;
    }
}
