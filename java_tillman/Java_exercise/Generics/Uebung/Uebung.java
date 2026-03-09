package Java_exercise.Generics.Uebung;

public class Uebung {
    public static void main(String[] args) {
    String [] stringArray = {"Wilhelm", "Thorsten", "Markus"};
    Integer[] intArray = {13,14,15};

    printArray(stringArray);
    printArray(intArray);
    }

    public static <T> void printArray(T[] array) { 
        for (T i : array) {
            System.out.println(i);
        }
    }
}
