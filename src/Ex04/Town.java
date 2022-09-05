package Ex04;

import java.util.ArrayList;
import java.util.List;

public class Town {
    private List<House> families;

    public Town() {
        families = new ArrayList<>();
    }

    public List<House> getFamilies() {
        return families;
    }

    public void setFamilies(List<House> families) {
        this.families = families;
    }

    @Override
    public String toString() {
        return "Town{" +
                "families=" + families +
                '}';
    }
}
