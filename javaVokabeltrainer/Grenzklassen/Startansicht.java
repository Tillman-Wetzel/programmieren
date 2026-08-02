package Grenzklassen;

import Steuerungsklassen.Steuerungsklassenfactory;

import java.awt.*;
import java.awt.event.*;

public class Startansicht implements ActionListener{
    Frame vokabeltrainerStartansicht;
    Button startknopf;
    Label willkommesText, ausgangsspracheLabel, zielspracheLabel, platzhalter1;
    Choice ausgangsspracheChoice, zielspracheChoice;

    Startansicht() {
        this.erstelleGui();
    }

    void erstelleGui() {
        vokabeltrainerStartansicht = new Frame("Tillman's AWT Super Vokabeltrainer App");
        
        vokabeltrainerStartansicht.setSize(800, 600);
        vokabeltrainerStartansicht.setLayout(new GridLayout(4, 2, 10, 10));
        
        erstelleInhalt();

        vokabeltrainerStartansicht.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                vokabeltrainerStartansicht.dispose();
                System.exit(0);
            }
        });
        
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
        startknopf.addActionListener(this);
        vokabeltrainerStartansicht.add(startknopf);
    }

    public void actionPerformed(ActionEvent e) {
    if (e.getSource() == startknopf) {
        String ausgangssprache = ausgangsspracheChoice.getSelectedItem();
        String zielsprache = zielspracheChoice.getSelectedItem();
        Grenzklassenfactory.erstelleAbfrage(ausgangssprache, zielsprache);
        vokabeltrainerStartansicht.setVisible(false);
    }
}
}
