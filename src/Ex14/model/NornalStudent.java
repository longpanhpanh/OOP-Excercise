package Ex14.model;

import java.time.LocalDate;

public class NornalStudent extends Student{
    private double englishScore;
    private double entryTestScore;

    public NornalStudent() {

    }

    @Override
    public void showMyInfor() {
        System.out.println(this);
    }

    public NornalStudent(String fullname, LocalDate doB, String sex, String phoneNumber, String universityName, String gradeLevel, double englishScore, double entryTestScore) {
        super(fullname, doB, sex, phoneNumber, universityName, gradeLevel);
        this.englishScore = englishScore;
        this.entryTestScore = entryTestScore;
    }


    public double getEnglishScore() {
        return englishScore;
    }

    public void setEnglishScore(double englishScore) {
        this.englishScore = englishScore;
    }

    public double getEntryTestScore() {
        return entryTestScore;
    }

    public void setEntryTestScore(double entryTestScore) {
        this.entryTestScore = entryTestScore;
    }

    @Override
    public String toString() {
        return "NornalStudent{" +
                "englishScore=" + englishScore +
                ", entryTestScore=" + entryTestScore +
                ", fullname='" + fullname + '\'' +
                ", doB=" + doB +
                ", sex='" + sex + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", universityName='" + universityName + '\'' +
                ", gradeLevel='" + gradeLevel + '\'' +
                '}';
    }
}
