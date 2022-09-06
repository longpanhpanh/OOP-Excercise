package Ex13.service;

import Ex13.exception.BirthdayException;
import Ex13.exception.EmailException;
import Ex13.exception.FullnameException;
import Ex13.exception.PhoneException;
import Ex13.model.Employee;
import Ex13.model.Experience;
import Ex13.model.Fresher;
import Ex13.model.Intern;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeManager {
    Scanner sc = new Scanner(System.in);
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("d/MM/yyyy");

    private List<Employee> employees;

    public EmployeeManager() {
        this.employees = new ArrayList<>();
    }

    public void insert(Employee employee) {
        employees.add(employee);
    }


    public Employee findById(String id) {
        return employees.stream()
                .filter(employee -> employee.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public boolean deleteById(String id) {
        Employee employee = findById(id);
        if (employee == null) {
            return false;
        }
        employees.remove(employee);
        return true;
    }

    public List<Employee> findByType(int type) {
        return employees.stream()
                .filter(employee -> {
                            if (type == 0) return employee instanceof Experience;
                            if (type == 1) return employee instanceof Fresher;
                            if (type == 2) return employee instanceof Intern;

                            return false;
                        })
                .toList();

    }

    public Employee editEmployee(String id) {
        Employee employee = findById(id);
        if (employee == null) return null;
        System.out.println("Edit name: ");
        String name = sc.nextLine();
        System.out.println("Edit email");
        String email = sc.nextLine();
        System.out.println("Edit phone");
        String phone = sc.nextLine();
        System.out.println("Edit birthday: ");
        LocalDate birthday = LocalDate.parse(sc.nextLine(), dateTimeFormatter);
        try {
            ValidatorService.checkFullname(name);
            ValidatorService.checkPhone(phone);
            ValidatorService.checkBirthday(birthday);
            ValidatorService.checkEmail(email);
            employee.setFullname(name);
            employee.setBirthday(birthday);
            employee.setPhone(phone);
            employee.setEmail(email);
        } catch (FullnameException | BirthdayException | PhoneException | EmailException e) {
            System.out.println(e.getMessage());

        }
        return employee;
    }


    public List<Employee> findAll() {
        return employees;
    }


    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
