package Ex14.service;

import Ex14.UI.ScannerFactory;
import Ex14.model.GoodStudent;
import Ex14.model.NornalStudent;
import Ex14.model.Student;

import java.util.*;

public class StudentManager {
    private List<Student> students;
    private List<GoodStudent> goodStudents;
    private List<NornalStudent> nornalStudents;
    Scanner sc = ScannerFactory.getScanner();

    public StudentManager() {
        this.students = new ArrayList<>();
        this.goodStudents = new ArrayList<>();
        this.nornalStudents = new ArrayList<>();
    }

    public void insert(Student student) {
        students.add(student);
        if (student instanceof GoodStudent) {
            goodStudents.add((GoodStudent) student);
        } else {
            nornalStudents.add((NornalStudent) student);
        }
    }

    public List<? extends Student> recruit(int amount) {
        if (goodStudents.size() > amount) {
            return getSortedGoodStudents(goodStudents);
        }
        if (goodStudents.size() < amount) {
            List<Student> recruitList = new ArrayList<>();
            recruitList.addAll(goodStudents);
            for (int i = 0; i < amount - recruitList.size(); i++) {
                recruitList.add(getSortedNormalStudents(nornalStudents).get(i));
            }
            return recruitList;
        } else {
            return goodStudents;
        }
    }

    public void showStudents() {
        Collections.sort(students, Comparator
                .comparing(Student::getFullname).reversed().thenComparing(Student::getPhoneNumber));
    }

    public List<GoodStudent> getSortedGoodStudents(List<GoodStudent> list) {
        return list.stream()
                .sorted(Comparator.comparing(GoodStudent::getGpa).reversed().thenComparing(GoodStudent::getFullname))
                .toList();

    }

    public List<NornalStudent> getSortedNormalStudents(List<NornalStudent> list) {
        return list.stream()
                .sorted(Comparator.comparing(NornalStudent::getEnglishScore).reversed().thenComparing(NornalStudent::getFullname))
                .toList();

    }


}
