package Java_homework;

public class ArrayExercise {
    public static void main(String[] args) {
        int[] grades = {85, 92, 78, 90, 88, 76, 95, 89};
        float notendurchschnitt = 0;
        int notenSumme = 0;

        for( int grade : grades) {
            notenSumme = notenSumme + grade;
        }

        notendurchschnitt = notenSumme / grades.length;


        System.out.println("Notensumme:" + notenSumme);
        System.out.println("notendurchschnitt: " + notendurchschnitt);
        System.out.println("test");
    }
    
}
