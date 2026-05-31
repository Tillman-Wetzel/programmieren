package javaVokabeltrainer.Steuerungsklassen;

public class Steuerungsklassenfactory {
    public static BeendeTrainingSteuerung beendeTrainingSteuerungInstanz;
    public static ErstelleOberflaecheSteuerung erstelleOberflaecheSteuerungInstanz;
    public static ErstelleScoreSteuerung erstelleScoreSteuerungInstanz;
    public static GetAntwortSteuerung getAntwortSteuerungInstanz;
    public static GetWortSteuerung getWortSteuerungInstanz;
    public static PruefeAntwortSteuerung pruefeAntwortSteuerungInstanz;
    public static SammleAntwortSteuerung sammleAntwortSteuerungInstanz;

    static BeendeTrainingSteuerung getBeendeTrainingSteuerung() {
        BeendeTrainingSteuerung myBeendeTrainingSteuerungInstanz = null; 

        if (beendeTrainingSteuerungInstanz == null) {
            beendeTrainingSteuerungInstanz = new BeendeTrainingSteuerung();
            
        }
        myBeendeTrainingSteuerungInstanz = beendeTrainingSteuerungInstanz;
        
        return myBeendeTrainingSteuerungInstanz; 
    }

    static ErstelleOberflaecheSteuerung getErstelleOberflaecheSteuerung() {
        ErstelleOberflaecheSteuerung myErstelleOberflaecheSteuerungInstanz = null; 

        if (erstelleOberflaecheSteuerungInstanz == null) {
            erstelleOberflaecheSteuerungInstanz = new ErstelleOberflaecheSteuerung();
            myErstelleOberflaecheSteuerungInstanz = erstelleOberflaecheSteuerungInstanz;
        }
            myErstelleOberflaecheSteuerungInstanz = erstelleOberflaecheSteuerungInstanz;
        
        return myErstelleOberflaecheSteuerungInstanz;
    }

    static ErstelleScoreSteuerung getErstelleScoreSteuerung() {
        ErstelleScoreSteuerung myErstelleScoreSteuerungInstanz = null; 

        if (erstelleScoreSteuerungInstanz == null) {
            erstelleScoreSteuerungInstanz = new ErstelleScoreSteuerung();
        }
        myErstelleScoreSteuerungInstanz = erstelleScoreSteuerungInstanz;
        
        return myErstelleScoreSteuerungInstanz;
    }

    static GetAntwortSteuerung getGetAntwortSteuerung() {
        GetAntwortSteuerung myGetAntwortSteuerungInstanz = null; 

        if (getAntwortSteuerungInstanz == null) {
            getAntwortSteuerungInstanz = new GetAntwortSteuerung();
        }
        myGetAntwortSteuerungInstanz = getAntwortSteuerungInstanz;
        
        return myGetAntwortSteuerungInstanz;
    }

    static GetWortSteuerung getGetWortSteuerung() {
        GetWortSteuerung myGetWortSteuerungInstanz = null; 

        if (getWortSteuerungInstanz == null) {
            getWortSteuerungInstanz = new GetWortSteuerung();
        }
            myGetWortSteuerungInstanz = getWortSteuerungInstanz;
        
        return myGetWortSteuerungInstanz;
    }

    static PruefeAntwortSteuerung getPruefeAntwortSteuerung() {
        PruefeAntwortSteuerung myPruefeAntwortSteuerungInstanz = null; 

        if (pruefeAntwortSteuerungInstanz == null) {
            pruefeAntwortSteuerungInstanz = new PruefeAntwortSteuerung();
        }
            myPruefeAntwortSteuerungInstanz = pruefeAntwortSteuerungInstanz;
        
        return myPruefeAntwortSteuerungInstanz;
    }

    static SammleAntwortSteuerung getSammleAntwortSteuerung() {
        SammleAntwortSteuerung mySammleAntwortSteuerungInstanz = null; 

        if (sammleAntwortSteuerungInstanz == null) {
            sammleAntwortSteuerungInstanz = new SammleAntwortSteuerung();
        }
            mySammleAntwortSteuerungInstanz = sammleAntwortSteuerungInstanz;
        
        return mySammleAntwortSteuerungInstanz;
    }
}