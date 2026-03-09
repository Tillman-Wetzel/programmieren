public class CoffeeDispenser extends Dispenser {
    void start() {
        isStarted = true;
        System.out.println("Coffee Dispenser started.");
    }

    
    boolean orderProduct(float prize) {
        System.out.println("Ordering coffee with prize: " + prize);
        return false;
    }

}
