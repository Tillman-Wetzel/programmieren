package Java_1;

import java.util.List;
import java.util.ArrayList;

public class Praxis {

    private List<Patient> patientenListe;
    private List<Behandlung> behandlungen;


    Praxis() {
        patientenListe = new ArrayList<Patient>();
        behandlungen = new ArrayList<Behandlung>();
    }

    void addPatient(Patient patient) {
        patientenListe.add(patient); 
    }

    void addBehandlung(Behandlung behandlung) {
        behandlungen.add(behandlung);
    }

    List<Patient> getPatient(String name) {
        ArrayList<Patient> ergebnisListe = new ArrayList<Patient>();
        for (Patient patient : patientenListe) {
            if (patient.getName() == name) {
                ergebnisListe.add(patient);
            }
        }
        
        if (ergebnisListe.size() == 0) {
            System.out.println("Patient konnte nicht gefunden werden.");
        }

        return ergebnisListe;
    }

    List<Behandlung> getBehandlung(String kvNummer) {
        ArrayList<Behandlung> ergebnisListe = new ArrayList<Behandlung>();
        for (Behandlung behandlung : behandlungen) {
            if (behandlung.getKvNummer() == kvNummer) {
                ergebnisListe.add(behandlung);
            }
        }
        
        if (ergebnisListe.size() == 0) {
            System.out.println("Behandlung konnte nicht gefunden werden.");
        }

        return ergebnisListe;
    }

    int getAnzahlBehandlungen(String kvNummer) {
        return getBehandlung(kvNummer).size();
    }

    double ermittleKosten() {
        double gesamtKosten = 0;

        for (Behandlung behandlung : behandlungen) {
            gesamtKosten += behandlung.getKosten();
        }

        return gesamtKosten;
    }
}
