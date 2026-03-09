import java.awt.*;
import java.awt.event.*;


public class AwtExample implements ActionListener {
    Button button;
    TextField textField;
    Label label;

    public static void main(String[] args) {
        AwtExample myObjekt = new AwtExample();
        myObjekt.createHomework();
    }

    void createHomework() {
        Frame f1 = new Frame("Tillman's AWT Demo Application");

        f1.setSize(800, 600);
        f1.setLayout(new FlowLayout());

        button = new Button("Click Me");
        button.addActionListener(this);
        f1.add(button);

        textField = new TextField(20);
        f1.add(textField);

        label = new Label("This is a label.");
        
        f1.add(label);

        f1.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        label.setText(textField.getText());
        textField.setText("Button Clicked"); 
    }

}
