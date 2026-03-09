package Bauerhof;

public class Kuh {
    private static final int maxAge = 15;
    private static final int minWeight = 35;
    private static final int maxWeight = 1000;

    private String name;
    private int weight;
    private int yearOfBirth;
    private int hayEaten;
    private int waterDrank;
    private double milkProduset;
    

    Kuh(String name, int weight, int yearOfBirth) {
        setName(name);
        setWeight(weight);
        setYearOfBirth(yearOfBirth);
        hayEaten = 0;
        waterDrank = 0;
        milkProduset = 0.0;
    }

    public String getName() {
        return name;
    }
    public int getWeight() {  
        return weight;
    }
    public int getYearOfBirth() {
        return yearOfBirth;
    }
    public int getHayEaten() {
        return hayEaten;
    }
    public int getWaterDrank() {
        return waterDrank;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setWeight(int weight) {
        if (weight > minWeight && weight <= maxWeight) {
            this.weight = weight;
        }
        else {
            System.err.println("Diese Kuh ist zu leicht / schwer für die Wage.");
        }
    }
    public void setMilk(double milk) {
        this.milkProduset = milk;
    }
    public void setYearOfBirth(int yearOfBirth) {
        int aktuellesJahr = getAktuellesJahr();

        if (yearOfBirth <= aktuellesJahr && yearOfBirth >= aktuellesJahr - maxAge) {
            this.yearOfBirth = yearOfBirth;
        }
        else {
            System.err.println("Die Kuh gibt es noch nicht / ist zu alt um zu Leben.");
        }
    }

    public void fresseHeu(int hayEaten) {
        this.hayEaten = hayEaten;
    }

    public void trinkeWasser(int waterDrank) {
        this.waterDrank = waterDrank;
    }
    public void getStatus() {
        getString();
    }

    public void getMilkStatus() {
        System.out.println(getName() + " hat " + milkProduset + " Liter Milch Produziert.");
    }

    public void produziereMilch() {
        double milchFaktor = 0.5;
        double minHayEatenForMilk = 5.0;
        double minWaterDrunkForMilk = 7.5;

        double maxMilk = Math.min(getHayEaten() / minHayEatenForMilk, getWaterDrank() / minWaterDrunkForMilk);

        setMilk(maxMilk * milchFaktor);
    }

    private void getString() {
        System.out.println(getName() + ":");
        System.out.println("wiegt " + getWeight() + " Kg.");
        System.out.println("wurde " + getYearOfBirth() + " geboren.");
        System.out.println("hat " + getHayEaten() + " Kg heu gegessen.");
    }

    private int getAktuellesJahr() {
        return java.time.Year.now().getValue();
    }
}