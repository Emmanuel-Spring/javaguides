package com.talentyco.stream;

import com.talentyco.stream.entities.Employee;

import java.util.List;
import java.util.stream.Collectors;

import static com.talentyco.stream.StreamApiTutorialApplication.employees;

public class EmployeeCollect {
    public static void main(String[] args) {

        // Map Collect Order Salary Increased in 10%
        // collect(Collectors.toList())
        List<Employee> increasedSalary =
                employees.stream()
                        .map(employee -> new Employee(
                                employee.getLasttName(),
                                employee.getFirstName(),
                                employee.getSalary() * 1.20,
                                employee.getProjects()))
                        .collect(Collectors.toList());
        System.out.println("\n\n\nStream List (Map): \n" + increasedSalary);

    }
}
