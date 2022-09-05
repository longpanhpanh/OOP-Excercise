package Ex03;

public class StudentC extends Student{

    private final String LITERATURE = "Literature";
    private final String HISTORY = "History";
    private final String GEOMETRY = "Geometry";

    public StudentC(String id, String name, String address, int priority) {
        super(id, name, address, priority);
    }

    @Override
    public String toString() {
        return "StudentC{" +
                "Subject: " + LITERATURE + HISTORY + GEOMETRY +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", priority=" + priority +
                '}';
    }
}
