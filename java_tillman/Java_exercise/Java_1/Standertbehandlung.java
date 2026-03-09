package Java_1;

public class Standertbehandlung extends Behandlung {


    Standertbehandlung() {
        super();
    }

    Standertbehandlung(String kvNummer, String beschreibung, double kostensatz) {
        super(kvNummer, beschreibung, kostensatz);
    }

    
    double getKosten() {
        return getKostensatz();
    }
}
