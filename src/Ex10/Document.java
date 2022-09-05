package Ex10;

public class Document {
    private String content;

    public Document(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int wordCount() {
        int wc = 0;
        for (int i = 0; i < content.length(); i++) {
            if (content.charAt(i) == ' ' || content.charAt(i) == '\n' || content.charAt(i) == '\t') {
                wc++;
            }
        }
        return wc;
    }

    public int countA() {
        int count = 0;
        for (int i = 0; i < content.length(); i++) {
            if (content.charAt(i) == 'A' || content.charAt(i) == 'a') {
                count++;
            }
        }

        return count;
    }

    public void standardize() {
       content = content.trim().replaceAll("\\s+", " ");
    }


}
