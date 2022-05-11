package com.talentyco.stream;

import static com.talentyco.stream.StreamApiTutorialApplication.employees;

public class EmployeeForEach {
    public static void main(String[] args) {

        // foreach
        // All Employee
        System.out.println("\nForEach Stream: \n");
        employees.stream()
                .forEach(employee -> System.out.println(employee));
    }
}
