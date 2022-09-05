package Ex13.model;

import java.time.LocalDate;
import java.util.List;

public class Intern extends Employee{
    private String majors;
    private int semester;
    private String university;



    public Intern() {

    }

    public Intern(String id, String fullname, LocalDate birthday, String phone, String email, List<Certificate> certificates, String majors, int semester, String university) {
        super(id, fullname, birthday, phone, email, certificates);
        this.majors = majors;
        this.semester = semester;
        this.university = university;
    }

    @Override
    public void showInfo() {
        System.out.println(this);
    }

    public String getMajors() {
        return majors;
    }

    public void setMajors(String majors) {
        this.majors = majors;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    @Override
    public String toString() {
        return "Intern{" +
                "majors='" + majors + '\'' +
                ", semester=" + semester +
                ", university='" + university + '\'' +
                ", id='" + id + '\'' +
                ", fullname='" + fullname + '\'' +
                ", birthday='" + birthday + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", certificates=" + certificates +
                '}';
    }
}
