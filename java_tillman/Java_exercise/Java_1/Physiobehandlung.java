package Java_1;

public class Physiobehandlung extends Behandlung {


    Physiobehandlung() {
        super();
    }

    Physiobehandlung(String kvNummer, String beschreibung, double kostensatz) {
        super(kvNummer, beschreibung, kostensatz);
    }

    
    double getKosten() {
        return getKostensatz() * 1.5;
    }
}
