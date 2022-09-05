package Ex01;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class OfficeManagement {
    private final List<Officer> officerList;

    public OfficeManagement() {
        this.officerList = new ArrayList<>();
    }

    public void addOfficer(Officer o) {
        officerList.add(o);
    }

    public List<Officer> getOfficerListByName(String name) {
        return officerList.stream()
                .filter(officer -> officer.getName().toLowerCase().contains(name.toLowerCase()))
                .toList();
    }

    public void printOfficers() {
        officerList.forEach(System.out::println);
    }
}
