package Ex03;

import java.util.ArrayList;
import java.util.List;

public class Recruit {
    private List<Student> students;

    public Recruit() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void displayStudent() {
        students.forEach(System.out::println);
    }

    public Student getStudentById(String id) {
        return students.stream()
                .filter(student -> student.id.equals(id))
                .findFirst()
                .orElseThrow();
    }




}
