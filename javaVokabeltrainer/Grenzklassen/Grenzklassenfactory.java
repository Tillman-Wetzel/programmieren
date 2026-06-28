package Grenzklassen;

public class Grenzklassenfactory {
    // static Abfrage getAbfrage() {
    //     return new Abfrage();
    // }

    // static Startansicht getStartansicht() {
    //     return new Startansicht();
    // }


    public static Startansicht erstelleStartansicht() {
        return new Startansicht();
    }

    public static Abfrage erstelleAbfrage() {
        return new Abfrage(); 
    }
}
