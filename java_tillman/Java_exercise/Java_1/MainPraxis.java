package Java_1;

public class MainPraxis {
    public static void main(String[] args) {
        Praxis praxis = new Praxis();

        Physiobehandlung chiropractic = new Physiobehandlung("A12345", "Chiropractic", 12.87);
        Physiobehandlung heat_application = new Physiobehandlung("A12345", "Heat application", 4.23);

        Standertbehandlung osteoarthritis = new Standertbehandlung("A12345", "Osteoarthritis", 45.12);
        Standertbehandlung ultrasound = new Standertbehandlung("A12345", "Ultrasound", 26.80);
        
        
        praxis.addBehandlung(chiropractic);
        praxis.addBehandlung(heat_application);

        praxis.addBehandlung(osteoarthritis);
        praxis.addBehandlung(ultrasound);


        System.out.println(praxis.ermittleKosten());
    }



}
