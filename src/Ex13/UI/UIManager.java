package Ex13.UI;

import Ex13.exception.BirthdayException;
import Ex13.exception.EmailException;
import Ex13.exception.FullnameException;
import Ex13.exception.PhoneException;
import Ex13.model.Employee;
import Ex13.model.Experience;
import Ex13.model.Fresher;
import Ex13.model.Intern;
import Ex13.service.EmployeeManager;
import Ex13.service.ValidatorService;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UIManager {
    Scanner scanner = new Scanner(System.in);
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
    private EmployeeManager employeeManager = new EmployeeManager();


    public void loadData() {
        try(ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("./data.txt"))) {
            Object inObject = inputStream.readObject();
            if (inObject.getClass() == ArrayList.class) {
                employeeManager.setEmployees((List<Employee>) inObject);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public EmployeeManager getEmployeeManager() {
        return employeeManager;
    }

    public void insert(int type) {
        Employee employee = null;
        if (type == 0) employee = insertExperience();
        if (type == 1) employee = insertFresher();
        if (type == 2) employee = insertIntern();

        try {
            checkData(employee);
        } catch (BirthdayException | FullnameException | PhoneException | EmailException e) {
            insert(type);
        }

       employeeManager.insert(employee);
    }



    private Experience insertExperience() {
        System.out.print("Input ID: ");
        String id = scanner.nextLine();
        System.out.print("Input Name: ");
        String name = scanner.nextLine();
        System.out.print("Input Phone: ");
        String phone = scanner.nextLine();
        System.out.print("Input Email: ");
        String email = scanner.nextLine();
        System.out.println("Input date of birth: ");
        LocalDate birthday = LocalDate.parse(scanner.nextLine(), dateTimeFormatter);
        System.out.println("Exp In Year: ");
        int yearExp = scanner.nextInt();
        System.out.println("Skill: ");
        String skills = scanner.nextLine();
        Experience experience = new Experience(id, name, birthday, phone, email, new ArrayList<>(), yearExp, skills);
        return experience;
    }

    private Fresher insertFresher() {
        System.out.print("Input ID: ");
        String id = scanner.nextLine();
        System.out.print("Input Name: ");
        String name = scanner.nextLine();
        System.out.print("Input Phone: ");
        String phone = scanner.nextLine();
        System.out.print("Input Email: ");
        String email = scanner.nextLine();
        System.out.println("Input date of birth: ");
        LocalDate birthday = LocalDate.parse(scanner.nextLine(), dateTimeFormatter);
        System.out.println("Graduation Date: ");
        LocalDate graduatedDate = LocalDate.parse(scanner.nextLine(), dateTimeFormatter);
        System.out.println("Graduation Rank: ");
        String graduatedRank = scanner.nextLine();
        System.out.println("Education: ");
        String education = scanner.nextLine();
        Fresher fresher = new Fresher(
                id, name, birthday, email, phone, new ArrayList<>(), graduatedDate, graduatedRank, education
        );
        return fresher;

    }

    private Intern insertIntern() {
        System.out.print("Input ID: ");
        String id = scanner.nextLine();
        System.out.print("Input Name: ");
        String name = scanner.nextLine();
        System.out.print("Input Phone: ");
        String phone = scanner.nextLine();
        System.out.print("Input Email: ");
        String email = scanner.nextLine();
        System.out.println("Input date of birth: ");
        LocalDate birthday = LocalDate.parse(scanner.nextLine(), dateTimeFormatter);
        System.out.println("Graduation Date: ");
        LocalDate graduatedDate = LocalDate.parse(scanner.nextLine(), dateTimeFormatter);
        System.out.println("Majors: ");
        String major = scanner.nextLine();
        System.out.println("Semester: ");
        int semester = scanner.nextInt();
        System.out.println("University: ");
        String university = scanner.nextLine();
        Intern intern = new Intern(id, name, birthday, email, phone, new ArrayList<>(), major, semester, university);
        return intern;
    }

    public void checkData(Employee employee) throws BirthdayException, EmailException, FullnameException, PhoneException {
        ValidatorService.checkBirthday(employee.getBirthday());
        ValidatorService.checkEmail(employee.getEmail());
        ValidatorService.checkPhone(employee.getPhone());
        ValidatorService.checkFullname(employee.getFullname());
    }


}
