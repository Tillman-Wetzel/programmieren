package werkstatt;

abstract public class VehicleNew {
    final int numberEngine = 1;
    private int numberWeels;

    abstract void startEngine();

    public VehicleNew() {
        setNumberWeels(4);
    }

    public VehicleNew(int numberWeels) {
        setNumberWeels(numberWeels);
    }

    int getNumberWeels() {
        return this.numberWeels;
    }

    void setNumberWeels(int numberWeels) {
        this.numberWeels = numberWeels;
    }
}
