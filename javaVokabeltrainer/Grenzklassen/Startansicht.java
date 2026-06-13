package Grenzklassen;

import Steuerungsklassen.Steuerungsklassenfactory;

import java.awt.*;
import java.awt.event.*;

public class Startansicht implements ActionListener{
    Frame vokabeltrainerStartansicht;

    Button startknopf;

    Label willkommesText, ausgangssprache, zielsprache;

    Choice ausgangssprache, zielsprache;

    void erstelleStartansicht() {
        new Startansicht();
    }

    void beiStartKnopfdruck() {
        setzeSprachen();
        Steuerungsklassenfactory.erstelleGetWortSteuerung(ausgangssprache, zielsprache);
    }

    void setzeSprachen() {
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}
