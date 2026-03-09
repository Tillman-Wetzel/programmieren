package Java_exercise.Generics.Uebung;

public class Limit<T extends Number>{

    public static void main(String[] args) {
        Integer[] intArray = {10, 20, 30};
        Double[] doubleArray = {40.5, 50.5, 60.5};
        Limit<Integer> intClass = new Limit<Integer>(intArray);
        System.out.println(intClass.calcAverage());
        Limit<Double> doubleClass = new Limit<Double>(doubleArray);
        System.out.println(doubleClass.calcAverage());
    }

    private T[] arrayValue;

    public Limit(T [] arrayValue) {
        this.arrayValue = arrayValue;
    }

    double calcAverage() {
        int arraySum = 0;
        for (T t : arrayValue) {
            arraySum = arraySum + t;
        }
        return arraySum / arrayValue.length;
    }
    
}
