package com.talentyco.stream;

import com.talentyco.stream.entities.Employee;

import java.util.List;
import java.util.stream.Collectors;

import static com.talentyco.stream.StreamApiTutorialApplication.employees;

public class FilterEmployeeStream {
    public static void main(String[] args) {
        // filter Stream
        // findFirst
        List<Employee> filterEmployee =
                employees
                        .stream()
                        .filter(employee -> employee.getSalary() > 5000)
                        .map(employee -> new Employee(
                                employee.getLasttName(),
                                employee.getFirstName(),
                                employee.getSalary() * 1.10,
                                employee.getProjects()
                        ))
                        .collect(Collectors.toList());
        System.out.println("\n\n\nStream Filter Salary: \n" + filterEmployee);
    }
}
