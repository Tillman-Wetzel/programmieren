package Java_homework;

import java.util.Scanner;

public class fakultaet {
    public static void main(String [] args){
        int ergebnis = 1;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Bitte um Eingabe");
        int fakultaet = scanner.nextInt();
        scanner.close();
        for (int i = 1; i <= fakultaet; i++) {
            ergebnis = ergebnis * i;
            //System.out.println(ergebnis);
        }
        /* 
        for (int i = fakultaet; i > 0; i--) {
            ergebnis *= i;
        }
        */
        System.out.println(ergebnis);

    }
}