package Ex01;

public class Engineer extends Officer{

    private String faculty;

    public Engineer(String name, int age, String gender, String address, String faculty) {
        super(name, age, gender, address);
        this.faculty = faculty;
    }

    @Override
    public String toString() {
        return "Engineer{" +
                "name: " + name
                + "age: " + age
                + "gender: " + gender
                + "address: " + address
                + "faculty: " + faculty +
                '}';
    }
}
