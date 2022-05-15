package com.talentyco.stream;

import com.talentyco.stream.entities.Employee;

import java.util.Set;
import java.util.stream.Collectors;

import static com.talentyco.stream.StreamApiTutorialApplication.employees;

public class EmployeeIncreasedSalaryStream {
    public static void main(String[] args) {
        // Set
        // Collect
        Set<Employee> increasedSalarySet =
                employees.stream()
                        .map(employee -> new Employee(
                                employee.getLasttName(),
                                employee.getFirstName(),
                                employee.getSalary() * 1.10,
                                employee.getProjects()
                        ))
                        .collect(Collectors.toSet());
        System.out.println("\n\n\nStream Set: \n" + increasedSalarySet);
    }
}
