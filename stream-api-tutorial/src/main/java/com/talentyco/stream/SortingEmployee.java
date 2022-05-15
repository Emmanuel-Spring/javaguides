package com.talentyco.stream;

import com.talentyco.stream.entities.Employee;

import java.util.List;
import java.util.stream.Collectors;

import static com.talentyco.stream.StreamApiTutorialApplication.employees;

public class SortingEmployee {
    public static void main(String[] args) {

        // Sorting
        List<Employee> sortedEmployees =
                employees
                        .stream()
                        .sorted((o1, o2) -> o1.getFirstName()
                                .compareToIgnoreCase(o2.getFirstName()))
                        .collect(Collectors.toList());
        System.out.println("\n\n\nStream Sorting: \n" + sortedEmployees);

    }
}
