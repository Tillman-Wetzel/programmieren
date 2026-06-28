

public class test {

    public static String command;


    // public static void main(String[] args) {
    //     String[] myCouloms = {"firstname"};
    //     System.out.println(App.getDatabaseItem("Users", myCouloms, ""));
    // }

    public static void main(String[] args) {
        command = "test.helloWorld()";

        System.out.println(command);
    }

    private static void helloWorld() {
        System.out.println("Hello World!");
    }
    
    
}
