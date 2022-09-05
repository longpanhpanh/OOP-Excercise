package Ex03;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Recruit rc = new Recruit();

        while (true) {
            System.out.println("Student Management Application: ");
            System.out.println("Enter 1: Insert Student");
            System.out.println("Enter 2: Show All Student's Info");
            System.out.println("Enter 3: To Search A Student By Id");
            System.out.println("Enter 0: Exit");

            String choice = sc.nextLine();
            switch (choice) {
                case "1": {
                    System.out.println("Enter a: Insert Student A");
                    System.out.println("Enter a: Insert Student B");
                    System.out.println("Enter a: Insert Student C");

                    String type = sc.nextLine();
                    switch (type) {
                        case "a" -> rc.addStudent(createStudent(sc, "a"));

                        case "b" -> rc.addStudent(createStudent(sc, "b"));

                        case "c" -> rc.addStudent(createStudent(sc, "c"));

                    }
                }

                case "2": {
                    rc.displayStudent();
                    break;
                }

                case "3": {
                    System.out.println("Enter id: ");
                    String id = sc.nextLine();
                    Student foundStudent = rc.getStudentById(id);
                    if (foundStudent == null) {
                        System.out.println("Student not found");
                    }
                    System.out.println(foundStudent);
                    break;
                }

                case "0":
                    System.exit(100);

                default:
                    System.out.println("Invalid");
            }
        }
    }

    public static Student createStudent(Scanner scanner, String cate) {
        System.out.print("Enter ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter address: ");
        String address = scanner.nextLine();
        System.out.print("Enter Priotity: ");
        int priority = scanner.nextInt();
        scanner.nextLine();
        if (cate.equals("a")) {
            return new StudentA(id, name, address, priority);
        } else if (cate.equals("b")) {
            return new StudentB(id, name, address, priority);
        } else {
            return new StudentC(id, name, address, priority);
        }

    }
}
