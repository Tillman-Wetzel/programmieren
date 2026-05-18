package javaVokabeltrainer.Grenzklassen;

import javaVokabeltrainer.EntityKlassen.Vokabel;

public class Grenzklassenfactory {
    public static Abfrage abfrageInstanz;
    public static Startansicht startansichtInstanz;

    static Abfrage getAbfrage() {
        Abfrage myAbfrageInstanz = null; 

        if (abfrageInstanz == null) {
            abfrageInstanz = new Abfrage();
        }
        else {
            myAbfrageInstanz = abfrageInstanz;
        }
        return myAbfrageInstanz;
    }

    static Startansicht getStartansicht() {
        Startansicht myStartansichtInstanz = null; 

        if (startansichtInstanz == null) {
            startansichtInstanz = new Startansicht();
        }
        else {
            myStartansichtInstanz = startansichtInstanz;
        }
        return myStartansichtInstanz;
    }
}
