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
        
        System.out.println(getFriendsListSize());
    }


    private static void printBestFriends() {
        for(String friend : bestFriends) {
            System.out.println(friend);
        }
    }
    private static int getFriendsListSize() {
        return bestFriends.size();
    }
}
