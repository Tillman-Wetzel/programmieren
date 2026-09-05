import java.util.ArrayList;

public class ArrayListExersize {

    static ArrayList<String> bestFriends;

    public static void main(String[] args) {
        bestFriends = new ArrayList<String>();
        
        bestFriends.add("Jacob S.");
        bestFriends.add("Paul");
        bestFriends.add("Max");
        bestFriends.add("Jaron");
        bestFriends.add("Leopold");

        printBestFriends();

        bestFriends.remove("Leopold");

        printBestFriends();

        System.out.println(bestFriends.get(1));

        System.out.println("===========================");

        ArrayList arrayList2 = new ArrayList<>();
        arrayList2.add("Hi!");
        System.out.println(arrayList2);
        
        ArrayList<String> arraylist5 = printBestFriends();

        for (String string3 : arraylist5) {
            arrayList2.add(string3);
        }
        System.out.println(arrayList2);


        
    }


    private static ArrayList<String> printBestFriends() {
        ArrayList<String> arraylist5 = new ArrayList<>();
        arraylist5.add("Hello");
        arraylist5.add(" World!");
        System.out.println(arraylist5);
        return arraylist5;
    }
}
