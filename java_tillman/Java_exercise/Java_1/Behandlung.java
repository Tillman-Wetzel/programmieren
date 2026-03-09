package Java_1;

public abstract class Behandlung {
    private String kvNummer;
    private String beschreibung;
    private double kostensatz;

    Behandlung() {
        // Constructor for Behandlung class
    }

    Behandlung(String kvNummer, String beschreibung, double kostensatz) {
        this.kvNummer =kvNummer; // Overloaded constructor for Behandlung class with a name parameter
        this.beschreibung = beschreibung;
        this.kostensatz = kostensatz;
    }

    String getKvNummer() {
        return this.kvNummer;
    }

    String getBeschreibung() {
        return this.beschreibung;
    }

    double getKostensatz() {
        return this.kostensatz;
    }

    abstract double getKosten();
}
