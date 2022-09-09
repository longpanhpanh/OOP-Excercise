package Ex13.UI;

import Ex13.exception.BirthdayException;
import Ex13.exception.EmailException;
import Ex13.exception.FullnameException;
import Ex13.exception.PhoneException;
import Ex13.model.*;
import Ex13.service.EmployeeManager;
import Ex13.service.ValidatorService;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class UIManager {
    Scanner scanner = new Scanner(System.in);
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
    private final EmployeeManager employeeManager = new EmployeeManager();



    public EmployeeManager getEmployeeManager() {
        return employeeManager;
    }

    public void insert(int type) {
        Employee employee = null;
        try {
            if (type == 0) employee = insertExperience();
            if (type == 1) employee = insertFresher();
            if (type == 2) employee = insertIntern();
            checkData(employee);
            employeeManager.insert(employee);
            Employee.count++;
        } catch (BirthdayException | FullnameException | PhoneException | EmailException | DateTimeParseException e) {
            System.out.println(e.getMessage());

        }

    }


    private List<Certificate> insertCertificate() {
        List<Certificate> certificateList = new ArrayList<>();
        System.out.println("Insert Certificates: ");
        while (true) {
            System.out.println("Enter id: ");
            String id = scanner.nextLine();
            System.out.println("Enter Certificate name: ");
            String name = scanner.nextLine();
            System.out.println("Enter rank: ");
            String rank = scanner.nextLine();
            LocalDate date;
            while(true) {
                try {
                    System.out.println("Enter date: ");
                    String dateStr = scanner.nextLine();
                    date = LocalDate.parse(dateStr, dateTimeFormatter);
                    break;
                } catch (DateTimeParseException e) {
                    System.out.println("Invalid Date Format");
                }
            }
            certificateList.add(new Certificate(id, name, rank, date));
            System.out.println("Press 0 to continue inserting, 1 to back to the Insert Employee");
            int choice = scanner.nextInt();
            switch (choice) {
                case 0:
                    break;
                case 1:
                    return certificateList;
            }
        }
    }


    private Map<String, String> insertCommonInfo() {
        Map<String, String> map = new HashMap<>();

        System.out.print("Input ID: ");
        String id = scanner.nextLine();
        map.put("id", id);

        while(true) {
            System.out.print("Input Name: ");
            String name = scanner.nextLine();
            try {
                if (ValidatorService.checkFullname(name)) {
                    map.put("name", name);
                    break;
                }
            } catch (FullnameException e) {
                System.out.println(e.getMessage());
            }

        }

        while (true) {
            System.out.println("Input Phone Number: ");
            String phone = scanner.nextLine();
            try {
                if (ValidatorService.checkPhone(phone)) {
                    map.put("phone", phone);
                    break;
                }
            } catch (PhoneException e) {
                System.out.println(e.getMessage());
            }
        }

        while(true) {
            System.out.print("Input Email: ");
            String email = scanner.nextLine();
            try {
                if (ValidatorService.checkEmail(email)) {
                    map.put("email", email);
                    break;
                }
            } catch (EmailException e) {
                System.out.println(e.getMessage());
            }

        }

        while(true) {
            System.out.println("Input date of birth: ");
            String dob = scanner.nextLine();
            try {
                if (ValidatorService.checkBirthday(LocalDate.parse(dob, dateTimeFormatter))) {
                    map.put("dob", dob);
                    break;
                }
            } catch (BirthdayException e) {
                System.out.println(e.getMessage());
            } catch (DateTimeParseException e) {
                System.out.println("Invalid birthday format");
            }

        }

        return map;
    }

    private Experience insertExperience() {
        Map<String, String> commonInfo = insertCommonInfo();
        System.out.println("Certificates: ");
        List<Certificate> certificateList = insertCertificate();
        scanner.nextLine();
        int yearExp = 0;
        while(true) {
            try {
                System.out.println("Exp In Year: ");
                yearExp = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid year format. Pls try again");
            }
        }
        System.out.println("Skill: ");
        String skills = scanner.nextLine();
        return new Experience(commonInfo.get("id"),
                commonInfo.get("name"),
                LocalDate.parse(commonInfo.get("dob"), dateTimeFormatter),
                commonInfo.get("phone"),
                commonInfo.get("email"), certificateList, yearExp, skills);
    }

    private Fresher insertFresher() throws PhoneException, BirthdayException, FullnameException, EmailException {
        Map<String, String> commonInfo = insertCommonInfo();
        System.out.println("Certificates: ");
        List<Certificate> certificateList = insertCertificate();
        scanner.nextLine();
        System.out.println("Graduation Date: ");
        LocalDate graduatedDate = LocalDate.parse(scanner.nextLine(), dateTimeFormatter);
        System.out.println("Graduation Rank: ");
        String graduatedRank = scanner.nextLine();
        System.out.println("Education: ");
        String education = scanner.nextLine();
        return new Fresher(
                commonInfo.get("id"),
                commonInfo.get("name"),
                LocalDate.parse(commonInfo.get("dob"), dateTimeFormatter),
                commonInfo.get("phone"),
                commonInfo.get("email"),
                certificateList, graduatedDate, graduatedRank, education
        );

    }

    private Intern insertIntern() throws PhoneException, BirthdayException, FullnameException, EmailException {
        Map<String, String> commonInfo = insertCommonInfo();
        System.out.println("Certificates: ");
        List<Certificate> certificateList = insertCertificate();
        scanner.nextLine();
        System.out.println("Majors: ");
        String major = scanner.nextLine();
        System.out.println("Semester: ");
        int semester = Integer.parseInt(scanner.nextLine());
        System.out.println("University: ");
        String university = scanner.nextLine();
        return new Intern(
                commonInfo.get("id"),
                commonInfo.get("name"),
                LocalDate.parse(commonInfo.get("dob"), dateTimeFormatter),
                commonInfo.get("phone"),
                commonInfo.get("email"),
                certificateList, major, semester, university);
    }

    public void checkData(Employee employee) throws BirthdayException, EmailException, FullnameException, PhoneException {
        ValidatorService.checkBirthday(employee.getBirthday());
        ValidatorService.checkEmail(employee.getEmail());
        ValidatorService.checkPhone(employee.getPhone());
        ValidatorService.checkFullname(employee.getFullname());
    }

    public void saveToFile() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("D:/workspace/Spring Project/OOP/src/Ex13/data.txt"))){
            outputStream.writeObject(employeeManager.findAll());
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFile() {
        try(ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("D:/workspace/Spring Project/OOP/src/Ex13/data.txt"))) {
            List<Employee> list = (List<Employee>) inputStream.readObject();
            System.out.println(list);
            inputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
