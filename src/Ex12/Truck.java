package Ex12;

public class Truck extends Vehicle{
    private double load;

    public Truck(String id, String brand, int year, double price, String color, double load) {
        super(id, brand, year, price, color);
        this.load = load;
    }

    public double getLoad() {
        return load;
    }

    public void setLoad(double load) {
        this.load = load;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "load=" + load +
                '}';
    }
}
