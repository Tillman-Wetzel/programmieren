package Grenzklassen;

public class Grenzklassenfactory {
    public static Startansicht erstelleStartansicht() {
        return new Startansicht();
    }

    public static Abfrage erstelleAbfrage(String ausgangssprache, String zielsprache) {
        return new Abfrage(ausgangssprache, zielsprache);
    }
}
