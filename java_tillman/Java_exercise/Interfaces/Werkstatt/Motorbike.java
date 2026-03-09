package Interfaces.Werkstatt;

public class Motorbike implements CarInterface {

    
    public void startEngine() {
        //isMotorStarted = true;
        System.out.println("Motor is started: Wrooooooooooooooom Wrooooooooooooooooom!");
    }

    
    public void honk() {
        System.out.println("MOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOP!!!!!!!");
    }
   
}
