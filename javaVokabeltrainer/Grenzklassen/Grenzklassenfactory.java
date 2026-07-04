package Grenzklassen;

public class Grenzklassenfactory {
<<<<<<< HEAD
    // static Abfrage getAbfrage() {
    //     return new Abfrage();
    // }

    // static Startansicht getStartansicht() {
    //     return new Startansicht();
    // }


=======
>>>>>>> e45bd6e6c6d29fa1eecdd883e3e97185acf134c1
    public static Startansicht erstelleStartansicht() {
        return new Startansicht();
    }

<<<<<<< HEAD
    public static Abfrage erstelleAbfrage() {
        return new Abfrage(); 
=======
    public static Abfrage erstelleAbfrage(String zielsprache) {
        return new Abfrage(zielsprache); 
>>>>>>> e45bd6e6c6d29fa1eecdd883e3e97185acf134c1
    }
}
