package javaVokabeltrainer.Steuerungsklassen;

import javaVokabeltrainer.EntityKlassen.EntityFactory;

public class GetWortSteuerung {
    static void erstelleGetWortSteuerung(String ausgangssprache, String zielsprache) {
        EntityFactory.erstelleVokabel(ausgangssprache, zielsprache);
    }
}
