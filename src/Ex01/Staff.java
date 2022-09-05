package Ex01;

public class Staff extends Officer{
    private String task;

    public Staff(String name, int age, String gender, String address, String task) {
        super(name, age, gender, address);
        this.task = task;
    }

    @Override
    public String toString() {
        return "Staff{" + "name: " + name
                + "age: " + age
                + "gender: " + gender
                + "address: " + address
                + "task: " +  task
                +
                '}';
    }
}
