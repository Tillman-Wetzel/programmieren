package Steuerungsklassen;

import EntityKlassen.EntityFactory;
import EntityKlassen.Vokabel;

public class GetWortSteuerung {
    private Vokabel vokabel;

    GetWortSteuerung(String ausgangssprache, String zielsprache) {
        vokabel = EntityFactory.erstelleVokabel(ausgangssprache, zielsprache);
    }

    public String getWort() {
        vokabel.generiereWort();
        return vokabel.getAusgangswort();
    }
}
