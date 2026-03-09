package Bauerhof;

import java.util.Scanner;

public class Spielwiese {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Kuh Berta = new Kuh("Berta", 650, 2015);
        Kuh Elsa = new Kuh("Elsa", 720, 2011);
        Kuh Kunigunde = new Kuh("Kunigunde", 690, 2013);
        Kuh Milka = new Kuh("Milka", 710, 2012);
        Kuh Rosalinde = new Kuh("Rosalinde", 680, 2014);







        while (true) {
        menü();
        int choice = scanner.nextInt();
            if (choice == 1) {
                
            }
            else if (choice == 2) {

            }
            else if (choice == 3) {
                
            }
            else if (choice == 4) {
                
            }
            else if (choice == 5) {
                break;
            }
        }
        scanner.close();
    }

    private static void menü() {
        System.out.println("Menü:");
        System.out.println("1. Heu füttern");
        System.out.println("2. Einer Kuh Wasser geben");
        System.out.println("3. Eine Kuh melken");
        System.out.println("4. Die gesamte Herde melken");
        System.err.println("5. Exit");
        System.out.print("Wählen Sie eine Option: ");
    } 
}

