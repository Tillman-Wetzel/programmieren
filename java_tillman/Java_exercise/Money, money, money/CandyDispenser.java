public class CandyDispenser extends Dispenser {    
    void start() {
        isStarted = true;
        System.out.println("Candy Dispenser started.");
    }

    
    boolean orderProduct(float prize) {
        System.out.println("Ordering candy with prize: " + prize);
        return false;
    }

}
