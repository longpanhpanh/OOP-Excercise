package Ex13.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public abstract class Employee implements Serializable {
    public static int count = 0;
    protected String id;
    protected String fullname;
    protected LocalDate birthday;
    protected String phone;
    protected String email;
    protected List<Certificate> certificates;

    public Employee() {
    }

    public Employee(String id, String fullname, LocalDate birthday, String phone, String email, List<Certificate> certificates) {
        this.id = id;
        this.fullname = fullname;
        this.birthday = birthday;
        this.phone = phone;
        this.email = email;
        this.certificates = certificates;

    }

    public abstract void showInfo();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Certificate> getCertificates() {
        return certificates;
    }

    public void setCertificates(List<Certificate> certificates) {
        this.certificates = certificates;
    }
}
