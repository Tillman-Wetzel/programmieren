package Grenzklassen;

public class Grenzklassenfactory {
    // static Abfrage getAbfrage() {
    //     return new Abfrage();
    // }

    // static Startansicht getStartansicht() {
    //     return new Startansicht();
    // }


    public static void erstelleStartansicht() {
        Startansicht.erstelleStartansicht();
    }

    public static void erstelleAbfrage() {
        Abfrage.erstelleAbfrage(); 
    }
}
