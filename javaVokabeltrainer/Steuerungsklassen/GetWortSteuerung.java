package Steuerungsklassen;

import EntityKlassen.EntityFactory;
import EntityKlassen.Vokabel;

public class GetWortSteuerung {
    GetWortSteuerung(String ausgangssprache, String zielsprache) {
        EntityFactory.erstelleVokabel(ausgangssprache, zielsprache);
    }

    public static String getWort() {
        return Vokabel.getWort();
    }
}
