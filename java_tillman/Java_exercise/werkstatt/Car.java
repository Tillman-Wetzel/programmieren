package werkstatt;

public class Car extends Vehicle {
    //-------------------------------
    //no constructor

    //-------------------------------
    //empty constructor

    public Car(){
        //super(); obwohl nicht aufgerufen
    }

    Car(int numberWeels, int numberEngines, String honkSound, Engine engine) {
        super(numberWeels, numberEngines, honkSound, engine);
    }

    public void fuelVehicle() {
        super.fuelVehicle();
        System.out.println("Fueled with Gasoline <7");
    }

    public void zahleKFZSteuern() {
        System.out.println("Zahle 18% KFZ-Steuern!");
    }

    //-------------------------------
    //constructor with super
//     public Car(){
//     super();
// }

}
