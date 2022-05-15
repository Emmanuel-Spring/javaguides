package com.talentyco.stream;

import com.talentyco.stream.entities.Employee;

import static com.talentyco.stream.StreamApiTutorialApplication.employees;

public class FilterFirstEmployee {
    public static void main(String[] args) {
        // filter Stream
        // findFirst
        Employee firstEmployee =
                employees
                        .stream()
                        .filter(employee -> employee.getSalary() > 8000)
                        .map(employee -> new Employee(
                                employee.getLasttName(),
                                employee.getFirstName(),
                                employee.getSalary() * 1.10,
                                employee.getProjects()
                        ))
                        .findFirst()
                        .orElse(null);
        System.out.println("\n\n\nStream findFirst Salary: \n" + firstEmployee);
    }
}
