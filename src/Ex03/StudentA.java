package Ex03;


public class StudentA extends Student{
    private final String MATH = "Math";
    private final String PHYSICS = "Physic";
    private final String CHEMISTRY = "Chemistry";

    public StudentA(String id, String name, String address, int priority) {
        super(id, name, address, priority);
    }

    @Override
    public String toString() {
        return "StudentA{" +
                "Subject: " + MATH + PHYSICS + CHEMISTRY +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", priority=" + priority +
                '}';
    }
}
