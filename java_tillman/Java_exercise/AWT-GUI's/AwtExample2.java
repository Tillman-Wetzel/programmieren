import java.awt.*;
import java.awt.event.*;


public class AwtExample2 implements ActionListener, KeyListener{
    Button button;
    TextField textField;
    Label label;

    public static void main(String[] args) {
        AwtExample2 myObjekt = new AwtExample2();
        myObjekt.createHomework();
    }

    void createHomework() {
        Frame f1 = new Frame("Tillman's AWT Demo Application");

        f1.setSize(800, 600);
        f1.setLayout(new BorderLayout());

        Button greetButton = new Button("Greet");
        greetButton.addActionListener(this);
        f1.add(greetButton, BorderLayout.EAST);

        textField = new TextField(20);
        textField.addKeyListener(this);
        f1.add(textField, BorderLayout.WEST);

        label = new Label("");
        
        f1.add(label, BorderLayout.SOUTH);

        f1.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        label.setText("Hello " + textField.getText() + "!");
        //textField.setText(""); 
    }

    public void keyTyped(KeyEvent e) {
        if (e.getKeyChar() == 'a') {
            label.setText("Du hast die Taste 'A' gedrückt.");
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyPressed'");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyReleased'");
    }

}
