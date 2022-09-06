package Ex13;

import Ex13.UI.UIManager;
import Ex13.model.Employee;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UIManager uiManager = new UIManager();

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Employee Management App");
            System.out.println("Enter 1: Insert Employee");
            System.out.println("Enter 2: Search");
            System.out.println("Enter 3: Edit Employee");
            System.out.println("Enter 4: List All Experience");
            System.out.println("Enter 5: List All Fresher");
            System.out.println("Enter 6: List All Intern");
            System.out.println("Enter 7: List All Employee and count");
            System.out.println("Enter 8: Save to file");
            System.out.println("Enter 0: Exit");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    sc.nextLine();
                    System.out.println("0: Insert Experience");
                    System.out.println("1: Insert Fresher");
                    System.out.println("2: Insert Intern");
                    int type = sc.nextInt();
                    uiManager.insert(type);
                    break;

                case 2:
                    sc.nextLine();
                    System.out.println("Enter employee's id: ");
                    String id = sc.nextLine();
                    System.out.println(uiManager.getEmployeeManager().findById(id));
                    break;

                case 3:
                    sc.nextLine();
                    System.out.println("Enter employee's id: ");
                    String eID = sc.nextLine();
                    uiManager.getEmployeeManager().editEmployee(eID);
                    break;

                case 4:
                    sc.nextLine();
                    uiManager.getEmployeeManager().findByType(0)
                            .forEach(System.out::println);
                    break;

                case 5:
                    sc.nextLine();
                    uiManager.getEmployeeManager().findByType(1)
                            .forEach(System.out::println);
                    break;

                case 6:
                    sc.nextLine();
                    uiManager.getEmployeeManager().findByType(2)
                            .forEach(System.out::println);
                    break;

                case 7:
                    sc.nextLine();
                    System.out.println("Employees: " + Employee.count);
                    uiManager.getEmployeeManager().findAll()
                            .forEach(System.out::println);

                case 8:
                    sc.nextLine();
                    uiManager.saveToFile();
                    break;
                case 0:
                    System.exit(100);

                default:
                    System.out.println("Invalid");
            }
        }
    }
}
