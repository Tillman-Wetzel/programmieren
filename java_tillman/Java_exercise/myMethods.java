import java.util.Random;

public class myMethods {
    public static int getRandomNumer(int minNumber, int maxNumber) {
        Random rand = new Random();
        return rand.nextInt(maxNumber - minNumber + 1) + minNumber;
    }
}
