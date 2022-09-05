package Ex04;

import java.util.ArrayList;
import java.util.List;

public class House {
    private String address;
    private List<Person> members;

    public House(String address) {
        this.address = address;
        members = new ArrayList<>();
    }


    public List<Person> getMembers() {
        return members;
    }

    public void setMembers(List<Person> members) {
        this.members = members;
    }

    public String getAddress() {
        return address;
    }

    public void setNumber(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "House{" +
                "address='" + address + '\'' +
                ", members=" + members +
                '}';
    }
}
