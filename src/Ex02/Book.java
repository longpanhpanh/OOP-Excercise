package Ex02;


public class Book extends Document {

    private String author;
    private int pageNum;

    public Book(int id, String publisher, int number, String author, int pageNum) {
        super(id, publisher, number);
        this.author = author;
        this.pageNum = pageNum;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", pageNum=" + pageNum +
                ", id=" + id +
                ", publisher='" + publisher + '\'' +
                ", number=" + number +
                '}';
    }
}
