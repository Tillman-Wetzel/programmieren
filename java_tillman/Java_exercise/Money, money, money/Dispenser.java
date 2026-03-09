public abstract class Dispenser {
    boolean isStarted = false;

    abstract void start();
    abstract boolean orderProduct(float prize);
}
