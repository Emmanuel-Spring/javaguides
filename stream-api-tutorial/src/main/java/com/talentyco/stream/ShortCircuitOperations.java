package com.talentyco.stream;

import com.talentyco.stream.entities.Employee;

import java.util.List;
import java.util.stream.Collectors;

import static com.talentyco.stream.StreamApiTutorialApplication.employees;

public class ShortCircuitOperations {
    public static void main(String[] args) {
        // Short Circuit operations
        List<Employee> shortCircuit =
                employees
                        .stream()
                        .skip(1)
                        .limit(1)
                        .collect(Collectors.toList());
        System.out.println("\n\n\nStream Short Circuit: \n" + shortCircuit);

    }
}
