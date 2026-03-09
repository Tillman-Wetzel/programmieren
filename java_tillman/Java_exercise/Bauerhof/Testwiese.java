package Bauerhof;

public class Testwiese {
    public static void main(String[] args) {
        Kuh Berta = new Kuh("Berta", 81, 2017);
        Berta.getStatus();
        Berta.fresseHeu(19);
        Berta.setWeight(85); // wir haben Berta nochmal gewogen ;)
        Berta.getStatus();

        Berta.trinkeWasser(50);
        Berta.produziereMilch();
        Berta.getMilkStatus();
    }
}