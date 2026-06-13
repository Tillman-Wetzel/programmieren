package javaVokabeltrainer.Steuerungsklassen;

import javaVokabeltrainer.EntityKlassen.EntityFactory;
import javaVokabeltrainer.EntityKlassen.Vokabel;

public class GetWortSteuerung {
    static void erstelleGetWortSteuerung(String ausgangssprache, String zielsprache) {
        EntityFactory.erstelleVokabel(ausgangssprache, zielsprache);
    }

    public static String getWort() {
        return Vokabel.getWort();
    }
}
