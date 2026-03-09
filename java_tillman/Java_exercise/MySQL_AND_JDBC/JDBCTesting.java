package Java_exercise.MySQL_AND_JDBC;

import java.util.ArrayList;
import jdbc.src.App;

public class JDBCTesting {
    public static void main(String[] args) {
        String[] myCoulums = {"ID", "firstname"};
        for (String i : App.getDatabaseItem("Users", myCoulums, "")) {
            System.out.println(i);   
        }
    }
}