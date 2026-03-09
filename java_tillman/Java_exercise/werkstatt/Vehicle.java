// package werkstatt;

// import java.util.ArrayList;

// public abstract class Vehicle {
//     private int numberWeels;
//     private int numberEngines;
//     public String honkSound;
//     Engine engine;

//     List<Rider> riders;

//     Vehicle() {
//         numberWeels = 0;
//         numberEngines = 1;
//         honkSound = "Quiiiiiiiiiisch!!!";
//         }

//     Vehicle(int numberWeels, int numberEngines, String honkSound, Engine engine) {
//         this.numberWeels = numberWeels;
//         this.numberEngines = numberEngines;
//         this.honkSound = honkSound;
//         this.engine = engine;
//         this.riders = new ArrayList<Rider>();
//     }

//     public int getNumberWeels() {
//         return this.numberWeels;
//     }

//     public int getNumberEngines() {
//         return this.numberEngines;
//     }

//     void addRider(Rider rider) {
//         riders.add(rider);

//     }

//     public void honk(String honkSound) {
//         System.out.println(honkSound);
//     }

//     public void fuelVehicle() {
//         System.out.println("Fueled with love <3");
//     }

//     public abstract void zahleKFZSteuern();


// }