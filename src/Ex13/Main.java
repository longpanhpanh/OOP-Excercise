package Ex13;

import Ex13.UI.UIManager;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UIManager uiManager = new UIManager();
        uiManager.loadData();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Employee Management App");
            System.out.println("Enter 1: Insert Employee");
            System.out.println("Enter 2: Search");
            System.out.println("Enter 0: Exit");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("0: Insert Experience");
                    System.out.println("1: Insert Fresher");
                    System.out.println("2: Insert Intern");
                    int type = sc.nextInt();
                    uiManager.insert(type);
                    break;
                case 0:
                    try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("./data.txt"))) {
                        outputStream.writeObject(uiManager.getEmployeeManager());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.exit(100);

                default:
                    System.out.println("Invalid");

            }
        }
    }
}
