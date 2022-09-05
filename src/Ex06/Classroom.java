package Ex06;

import java.util.ArrayList;
import java.util.List;

public class Classroom {
    private final List<Student> students;

    public Classroom() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public List<Student> getStudentsByAge(int age) {
        return students.stream()
                .filter(student -> student.getAge() == age)
                .toList();
    }

//    public List<Student> getStudentsByAddress(String address) {
//
//    }
}
