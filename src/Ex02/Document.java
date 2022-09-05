package Ex02;

public class Document {

    protected int id;
    protected String publisher;
    protected int number;

    public Document(int id, String publisher, int number) {
        this.id = id;
        this.publisher = publisher;
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", publisher='" + publisher + '\'' +
                ", number=" + number +
                '}';
    }
}

