package Ex12;

public class Car extends Vehicle{
    private int seatNum;
    private String engine;

    public Car(String id, String brand, int year, double price, String color, int seatNum, String engine) {
        super(id, brand, year, price, color);
        this.seatNum = seatNum;
        this.engine = engine;
    }

    public int getSeatNum() {
        return seatNum;
    }

    public void setSeatNum(int seatNum) {
        this.seatNum = seatNum;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "Car{" +
                "seatNum=" + seatNum +
                ", engine='" + engine + '\'' +
                '}';
    }
}
