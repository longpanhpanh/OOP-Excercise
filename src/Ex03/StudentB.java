package Ex03;

public class StudentB extends Student{
    private final String MATH = "Math";
    private final String CHEMISTRY = "Chemistry";
    private final String BIOLOGY = "Biology";

    public StudentB(String id, String name, String address, int priority) {
        super(id, name, address, priority);
    }


    @Override
    public String toString() {
        return "StudentB{" +
                "Subject: " + MATH + CHEMISTRY + BIOLOGY +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", priority=" + priority +
                '}';
    }
}
