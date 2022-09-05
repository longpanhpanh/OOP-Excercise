package Ex02;

import java.time.LocalDate;

public class Newspaper extends Document{

    private LocalDate publishDate;

    public Newspaper(int id, String publisher, int number, LocalDate publishDate) {
        super(id, publisher, number);
        this.publishDate = publishDate;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

    @Override
    public String toString() {
        return "Newspaper{" +
                "publishDate=" + publishDate +
                ", id=" + id +
                ", publisher='" + publisher + '\'' +
                ", number=" + number +
                '}';
    }
}
