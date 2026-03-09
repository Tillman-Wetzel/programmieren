package Java_homework;

import java.util.Arrays;

import Java_conferenz.system_out_println;

public class MethodsHomework {

    int a = 7;
    final int MY_FINAL_VARIABLE = 7;

    static int c;
    final static int D = 8;

    public static void main(String[] args) {

        MethodsHomework MyObjekt = new MethodsHomework();

        System.out.println(MyObjekt.a);
        System.out.println(MyObjekt.MY_FINAL_VARIABLE);
        System.out.println(c);
        System.out.println(D);




        MyObjekt.printFavoriteAnimalName("die Biene");

        System.out.println(additionCalculator(6, 7));
        System.out.println(subtractionCalculator(7, 5));
        System.out.println(multiplicationCalculator(3, 3));
        System.out.println(divisionCalculator(49, 7));


        int[] Array_to_calculate = {23, 3, 14, 52, 2, 17};

        System.out.println(calculateSum(Array_to_calculate));
        System.out.println(smallest_int_in_Array(Array_to_calculate));

     }


    void printFavoriteAnimalName(String myFavoriteAnimalName) {
        System.out.println(a);
        System.out.println(c);
        System.out.println("Mein Lieblingstier ist " + myFavoriteAnimalName + ".");

    }


    static int additionCalculator(int firstNumber, int secondNumber) {

        MethodsHomework MyObjekt = new MethodsHomework();

        System.out.println(MyObjekt.a);
        System.out.println(c);
        return firstNumber + secondNumber;

    }

    static int subtractionCalculator(int firstNumber, int secondNumber) {
        return firstNumber - secondNumber;

    }

    static int multiplicationCalculator(int firstNumber, int secondNumber) {
        return firstNumber * secondNumber;

    }

    static int divisionCalculator(int firstNumber, int secondNumber) {
        return firstNumber / secondNumber;

    }


    static int calculateSum(int[] intArray) {
        int sum_of_Array = 0;
        
        // for (int i = 0; i < intArray.length; i++) {
        //     sum_of_Array = sum_of_Array + intArray[i];
        // }

        for (int j : intArray) {
            sum_of_Array = sum_of_Array + j;
        }

        return sum_of_Array;
    }

    static int smallest_int_in_Array(int[] intArray) {
        Arrays.sort(intArray);
        return intArray[0];
    }
}
