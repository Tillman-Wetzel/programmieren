package Java_homework;

import java.util.Scanner;

import Java_conferenz.system_out_println;

public class schaltjahre {
    public static void main(String [] args){
        Boolean schaltjahr = false;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bitte um Eingabe");
        int jahr = scanner.nextInt();
        scanner.close();

        if(jahr % 4 == 0) {
            
            if (jahr % 100 == 0) {
                if (jahr % 400 == 0) {
                    schaltjahr = true;
                }
            }
            else {
                schaltjahr = true;
            }
        }

    if (schaltjahr) {
        System.out.println("Das Jahr " + jahr + " ist ein Schaltjahr");
    }
    else {
        System.out.println("Das Jahr " + jahr + " ist kein Schaltjahr");
    }
    




    }
}
