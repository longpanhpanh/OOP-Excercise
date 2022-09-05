package Ex11;

import java.util.Scanner;

public class SoPhuc {
    private double phanThuc;
    private double phanAo;

    Scanner sc = new Scanner(System.in);

    public SoPhuc(double phanThuc, double phanAo) {
        this.phanThuc = phanThuc;
        this.phanAo = phanAo;
    }


    public void nhapSoPhuc() {
        System.out.println("Nhap phan thuc: ");
        this.phanThuc = sc.nextDouble();
        System.out.println("Nhap phan ao: ");
        this.phanAo = sc.nextDouble();
    }

    public void showSoPhuc() {
        System.out.println(this);
    }

    public void congSoPhuc(SoPhuc another) {
       SoPhuc ketQua =  new SoPhuc(phanThuc + another.phanThuc, phanAo + another.phanAo);
        System.out.println(ketQua);
    }

    public void truSoPhuc(SoPhuc another) {
        SoPhuc ketQua =  new SoPhuc(phanThuc - another.phanThuc, phanAo - another.phanAo);
        System.out.println(ketQua);
    }

    public void nhanSoPhuc(SoPhuc another) {
        SoPhuc ketQua =  new SoPhuc(
                (phanThuc * another.phanThuc - phanAo * another.phanAo),
                (phanThuc * another.phanAo + phanAo * another.phanThuc)
        );
        System.out.println(ketQua);
    }

    @Override
    public String toString() {
        return "SoPhuc: " + phanThuc + " + " + phanAo + "i";
    }


}
