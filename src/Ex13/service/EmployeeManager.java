package Ex13.service;

import Ex13.model.Employee;
import Ex13.model.Experience;
import Ex13.model.Fresher;
import Ex13.model.Intern;

import java.util.ArrayList;
import java.util.List;

public class EmployeeManager {
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


    public List<Employee> findAll() {
        return employees;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
