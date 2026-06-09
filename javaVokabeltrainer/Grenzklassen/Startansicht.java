package javaVokabeltrainer.Grenzklassen;

import javaVokabeltrainer.Steuerungsklassen.Steuerungsklassenfactory;

public class Startansicht {
    private static String ausgangssprache;
    private static String zielsprache;
    static void erstelleStartansicht() {

    }

    static void beiStartKnopfdruck() {
        setzeSprachen();
        Steuerungsklassenfactory.erstelleGetWortSteuerung(ausgangssprache, zielsprache);
    }

    static void setzeSprachen() {
        ausgangssprache = "Englisch";
        zielsprache = "Deutsch";
    }
}
