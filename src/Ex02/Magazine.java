package Ex02;

import java.time.Month;

public class Magazine extends Document{

    private int publishtNum;
    private Month publishMonth;

    public Magazine(int id, String publisher, int number, int publishtNum, Month publishMonth) {
        super(id, publisher, number);
        this.publishtNum = publishtNum;
        this.publishMonth = publishMonth;
    }

    public int getPublishtNum() {
        return publishtNum;
    }

    public void setPublishtNum(int publishtNum) {
        this.publishtNum = publishtNum;
    }

    public Month getPublishMonth() {
        return publishMonth;
    }

    public void setPublishMonth(Month publishMonth) {
        this.publishMonth = publishMonth;
    }

    @Override
    public String toString() {
        return "Magazine{" +
                "publishtNum=" + publishtNum +
                ", publishMonth=" + publishMonth +
                ", id=" + id +
                ", publisher='" + publisher + '\'' +
                ", number=" + number +
                '}';
    }
}
