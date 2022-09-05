package Ex02;

import java.util.ArrayList;
import java.util.List;

public class DocumentManagement {
    private List<Document> documentList;

    public DocumentManagement() {
        this.documentList = new ArrayList<>();
    }

    public void addDocument(Document document) {
        documentList.add(document);
    }

    public boolean deleteById(int id) {
        return documentList.removeIf(document -> document.id == id);
    }

    public void printInfo() {
        documentList.forEach(System.out::println);
    }


    public void searchByBook() {
        documentList.stream()
                .filter(document -> document instanceof Book)
                .forEach(System.out::println);
    }

    public void searchByMagazine() {
        documentList.stream()
                .filter(document -> document instanceof Magazine)
                .forEach(System.out::println);
    }

    public void searchByNewspaper() {
        documentList.stream()
                .filter(document -> document instanceof Newspaper)
                .forEach(System.out::println);
    }
}
