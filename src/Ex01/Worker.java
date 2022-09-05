package Ex01;

public class Worker extends Officer{

    private int level;

    public Worker(String name, int age, String gender, String address, int level) {
        super(name, age, gender, address);
        this.level = level;
    }

    @Override
    public String toString() {
        return "Worker{" + "name: " + name
                + "age: " + age
                + "gender: " + gender
                + "address: " + address
                + "level: " + level
                +
                '}';
    }
}
