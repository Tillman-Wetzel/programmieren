package Java_homework;

import java.util.ArrayList;

public class ArrayListExercise {
    public static void main(String[] args) {
        ArrayList<String> cars = new ArrayList<String>();
    
    cars.add("BMW");
    cars.add("TOYOTA");
    cars.add("WWI");
    cars.add(0, "Audi");
    cars.addFirst("TemuCar");

    cars.remove("WWI");

    System.out.println("Aktuelle Bedrohung: " + cars.get(0) + "!!!!!!!!!!!!!!!");
    System.out.println("Wir haben" + cars.size() + "Automarken im Autobestand.");
    System.out.println("In unserem Autobestand sind folgende Marken: " + cars);
    
    
    }
}
