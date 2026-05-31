package javaVokabeltrainer.EntityKlassen;

public class EntityFactory {
    public static Vokabel vokabelInstanz;
    public static Antwort antwortInstanz;
    public static Score scoreInstanz;

    static Vokabel getVokabel() {
        Vokabel myVokabelInstanz = null; 

        if (vokabelInstanz == null) {
            vokabelInstanz = new Vokabel();
        }
        myVokabelInstanz = vokabelInstanz;
        
        return myVokabelInstanz;
    }

    static Antwort getAntwort() {
        Antwort myAntwortInstanz = null; 

        if (antwortInstanz == null) {
            antwortInstanz = new Antwort();
        }
        myAntwortInstanz = antwortInstanz;
        
        return myAntwortInstanz;
    }
    
    static Score getScore() {
        Score myScoreInstanz = null; 

        if (scoreInstanz == null) {
            scoreInstanz = new Score();
        }
        myScoreInstanz = scoreInstanz;
        
        return myScoreInstanz;
    }
}