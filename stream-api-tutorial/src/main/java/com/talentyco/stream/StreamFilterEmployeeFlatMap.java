package com.talentyco.stream;

import java.util.stream.Collectors;

import static com.talentyco.stream.StreamApiTutorialApplication.employees;

public class StreamFilterEmployeeFlatMap {
    public static void main(String[] args) {
        // flatMap
        String projects =
                employees
                        .stream()
                        .map(employee -> employee.getProjects())
                        .flatMap(strings -> strings.stream())
                        .collect(Collectors.joining(", "));
        System.out.println("\n\n\nStream flatMap projects: \n" + projects);
    }
}
