package Grenzklassen;

import Steuerungsklassen.GetWortSteuerung;

import java.awt.*;
import java.awt.event.*;

public class Abfrage implements ActionListener{
    Frame vokabeltrainerAnsicht;

    Label titelLabel;
    Label uebersetzenLabel;
    Label wortIstLabel;
    Label wortLabel;

    TextField eingabeFeld;

    Button abgebenButton;

    public static void dreuckeNochEinWort() {
        GetWortSteuerung.getWort();
    }

    void erstelleAbfrage() {
        vokabeltrainerAnsicht = new Frame("Tillman's AWT Super Vokabeltrainer");

        vokabeltrainerAnsicht.setSize(800, 600);
        vokabeltrainerAnsicht.setLayout(new GridLayout(6, 1, 10, 10));

        erstelleInhalt();

        vokabeltrainerAnsicht.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                vokabeltrainerAnsicht.dispose();
                System.exit(0);
            }
        });

        vokabeltrainerAnsicht.setVisible(true);
    }

    void erstelleInhalt() {

        titelLabel = new Label("Tillman's Vokabeltrainer", Label.CENTER);
        titelLabel.setFont(new Font("Arial", Font.BOLD, 28));
        vokabeltrainerAnsicht.add(titelLabel);

        uebersetzenLabel = new Label("Übersetze ins Englische", Label.CENTER);
        uebersetzenLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        vokabeltrainerAnsicht.add(uebersetzenLabel);

        wortIstLabel = new Label("Das Wort ist:", Label.CENTER);
        vokabeltrainerAnsicht.add(wortIstLabel);

        wortLabel = new Label("Auto", Label.CENTER);
        wortLabel.setFont(new Font("Arial", Font.BOLD, 22));
        vokabeltrainerAnsicht.add(wortLabel);

        eingabeFeld = new TextField();
        vokabeltrainerAnsicht.add(eingabeFeld);

        abgebenButton = new Button("Abgeben");
        abgebenButton.addActionListener(this);
        vokabeltrainerAnsicht.add(abgebenButton);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == abgebenButton) {
            String eingabe = eingabeFeld.getText();

            System.out.println("Eingegeben: " + eingabe);

            // Hier kannst du später deine Steuerung aufrufen
            // Steuerungsklassenfactory.erstellePruefenSteuerung(eingabe);
        }
    }

}
