package Ex09;

public class Customer {
    private String name;
    private String address;
    private String code;
    private Bill bill;

    public Customer(String name, String address, String code, Bill bill) {
        this.name = name;
        this.address = address;
        this.code = code;
        this.bill = bill;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }


}
