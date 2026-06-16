package Grenzklassen;

import Steuerungsklassen.Steuerungsklassenfactory;

import java.awt.*;
import java.awt.event.*;

public class Startansicht implements ActionListener{
    Frame vokabeltrainerStartansicht;
    Button startknopf;
    Label willkommesText, ausgangsspracheLabel, zielspracheLabel, platzhalter1;
    Choice ausgangsspracheChoice, zielspracheChoice;

    static void erstelleStartansicht() {
        Startansicht myStartansicht = new Startansicht();
        myStartansicht.erstelleGui();
        




    }

    void erstelleGui() {
        vokabeltrainerStartansicht = new Frame("Tillman's AWT Super Vokabeltrainer App");
        
        vokabeltrainerStartansicht.setSize(800, 600);
        vokabeltrainerStartansicht.setLayout(new GridLayout(4,3));
        
        erstelleInhalt();

        vokabeltrainerStartansicht.setVisible(true);
    }

    void erstelleInhalt() {
        willkommesText = new Label("Willkommen zu Tillman's Vokabeltrainer");
        vokabeltrainerStartansicht.add(willkommesText);

        platzhalter1 = new Label("");
        vokabeltrainerStartansicht.add(platzhalter1);
        
        ausgangsspracheLabel = new Label("Ausgangssprache:");
        vokabeltrainerStartansicht.add(ausgangsspracheLabel);

        zielspracheLabel = new Label("Zielsprache:");
        vokabeltrainerStartansicht.add(zielspracheLabel);
        
        ausgangsspracheChoice = new Choice();
        ausgangsspracheChoice.add("Deutsch");
        ausgangsspracheChoice.add("Englisch");
        ausgangsspracheChoice.add("Spanisch");
        ausgangsspracheChoice.add("Schwedisch");
        vokabeltrainerStartansicht.add(ausgangsspracheChoice);

        zielspracheChoice = new Choice();
        zielspracheChoice.add("Deutsch");
        zielspracheChoice.add("Englisch");
        zielspracheChoice.add("Spanisch");
        zielspracheChoice.add("Schwedisch");
        vokabeltrainerStartansicht.add(zielspracheChoice);

        startknopf = new Button("Start");
        vokabeltrainerStartansicht.add(startknopf);
    }

    void beiStartKnopfdruck() {
        setzeSprachen();
        //Steuerungsklassenfactory.erstelleGetWortSteuerung();
    }

    void setzeSprachen() {
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}
