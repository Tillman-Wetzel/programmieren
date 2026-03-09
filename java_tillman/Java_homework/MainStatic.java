package Java_homework;
public class MainStatic {
    public static void main(String[] args) {
    System.out.println(myMethod(5, 3));
    System.out.println(5 + 3);
    intArrayMethod();
 }


    static int myMethod(int a, int b) {
        return a+b;
    }

    static int[] intArrayMethod() {
        int[] zahlenArray = {5, 3, 5, 78};
        return zahlenArray;
    }
}
