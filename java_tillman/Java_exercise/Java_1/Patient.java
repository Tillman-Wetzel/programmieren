package Java_1;

public class Patient {
    private String kvNummer;
    private String name;
    private String vorname;

    Patient() {
        // Constructor for Behandlung class
    }

    Patient(String kvNummer, String name, String vorname) {
        this.kvNummer =kvNummer; // Overloaded constructor for Behandlung class with a name parameter
        this.name = name;
        this.vorname = vorname;
    }

    String getKvNummer() {
        return this.kvNummer;
    }

    String getName() {
        return this.name;
    }

    String getVorname() {
        return this.vorname;
    }
}
