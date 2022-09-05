package Ex05;

public class Customer {
    private int bookingPeriod;
    private Room roomType;
    private String name;
    private String id;
    private int age;

    public Customer(int bookingPeriod, Room roomType, String name, String id, int age) {
        this.bookingPeriod = bookingPeriod;
        this.roomType = roomType;
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public int getBookingPeriod() {
        return bookingPeriod;
    }

    public void setBookingPeriod(int bookingPeriod) {
        this.bookingPeriod = bookingPeriod;
    }

    public Room getRoomType() {
        return roomType;
    }

    public void setRoomType(Room roomType) {
        this.roomType = roomType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "bookingPeriod=" + bookingPeriod +
                ", roomType=" + roomType +
                ", name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", age=" + age +
                '}';
    }
}
