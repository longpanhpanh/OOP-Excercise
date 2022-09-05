package Ex14.model;

import java.time.LocalDate;

public class GoodStudent extends Student{
    private String gpa;
    private String bestRewardName;

    public GoodStudent() {
    }

    @Override
    public void showMyInfor() {
        System.out.println(this);
    }

    public GoodStudent(String fullname, LocalDate doB, String sex, String phoneNumber, String universityName, String gradeLevel, String gpa, String bestRewardName) {
        super(fullname, doB, sex, phoneNumber, universityName, gradeLevel);
        this.gpa = gpa;
        this.bestRewardName = bestRewardName;
    }

    public String getGpa() {
        return gpa;
    }

    public void setGpa(String gpa) {
        this.gpa = gpa;
    }

    public String getBestRewardName() {
        return bestRewardName;
    }

    public void setBestRewardName(String bestRewardName) {
        this.bestRewardName = bestRewardName;
    }

    @Override
    public String toString() {
        return "GoodStudent{" +
                "gpa='" + gpa + '\'' +
                ", bestRewardName='" + bestRewardName + '\'' +
                ", fullname='" + fullname + '\'' +
                ", doB=" + doB +
                ", sex='" + sex + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", universityName='" + universityName + '\'' +
                ", gradeLevel='" + gradeLevel + '\'' +
                '}';
    }
}
