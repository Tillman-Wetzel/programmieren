package Java_homework;

public class Animal {

    String name;
    int age;
    int weightInGrams;
    final String BLA_BLI_BLUB = "Living Thing";
    final static String SCREAM = "ahhhhhhhhhhh";
    static String sleepingNoise = "Snore";

    public static void main(String[] args) {
        Animal dog = new Animal();
        Animal bee = new Animal();
        dog.name = "Dog";
        dog.age = 4;
        dog.weightInGrams = 12000;
        bee.name = "Bee";
        bee.age = 2;
        bee.weightInGrams = 8;

        dog.discribe();
        bee.discribe();

        System.out.println(dog.name + " is " + dog.calcWeightDifferents(12254) + " grams heavier than before.");
        System.out.println(bee.name + " is " + bee.calcWeightDifferents(9) + " grams heavier than before.");

        System.out.println(SCREAM);

        System.out.println(getSleepingNoise(null));
        System.out.println(getSleepingNoise("Schnarch"));
        System.out.println(sleepingNoise);


        System.out.println(bee.getSleepingNoise2(null));
        System.out.println(dog.getSleepingNoise2("Schnarch"));
        System.out.println(sleepingNoise);
    }

    void discribe(){
        System.out.println(name + " is:");
        System.out.println(age + " Years old,");
        System.out.println("weighs " + weightInGrams + " grams,");
        System.out.println("and is a " + BLA_BLI_BLUB);
    }

    static String getSleepingNoise(String noise) {
        if (noise == null) {
            noise = sleepingNoise;
        }

        return noise;
    }

    String getSleepingNoise2(String noise) {
        if (noise == null) {
            noise = sleepingNoise;
        }

        return noise;
    }

    void add1Year() {

        this.age ++;

    }


    int calcWeightDifferents(int newWeight) {
        return newWeight - weightInGrams;
    }
}
