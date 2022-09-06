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
    private EmployeeManager employeeManager = new EmployeeManager();



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
            System.out.println("Enter date: ");
            LocalDate date = LocalDate.parse(scanner.nextLine(), dateTimeFormatter);
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
        System.out.print("Input Name: ");
        String name = scanner.nextLine();
        map.put("name", name);
        System.out.print("Input Phone: ");
        String phone = scanner.nextLine();
        map.put("phone", phone);
        System.out.print("Input Email: ");
        String email = scanner.nextLine();
        map.put("email", email);
        System.out.println("Input date of birth: ");
        String dob = scanner.nextLine();
        map.put("dob", dob);
        return map;
    }

    private Experience insertExperience() {
        Map<String, String> commonInfo = insertCommonInfo();
        System.out.println("Certificates: ");
        List<Certificate> certificateList = insertCertificate();
        scanner.nextLine();
        System.out.println("Exp In Year: ");
        int yearExp = Integer.parseInt(scanner.nextLine());
        System.out.println("Skill: ");
        String skills = scanner.nextLine();
        return new Experience(commonInfo.get("id"),
                commonInfo.get("name"),
                LocalDate.parse(commonInfo.get("dob"), dateTimeFormatter),
                commonInfo.get("phone"),
                commonInfo.get("email"), certificateList, yearExp, skills);
    }

    private Fresher insertFresher() {
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

    private Intern insertIntern() {
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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
