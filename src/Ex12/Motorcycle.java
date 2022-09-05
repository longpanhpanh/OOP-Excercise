package Ex12;

public class Motorcycle extends Vehicle {
    private int power;

    public Motorcycle(String id, String brand, int year, double price, String color, int power) {
        super(id, brand, year, price, color);
        this.power = power;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return "Motorcycle{" +
                "power=" + power +
                '}';
    }
}
