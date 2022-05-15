package com.talentyco.stream;

import com.talentyco.stream.entities.Employee;

import java.util.Comparator;
import java.util.NoSuchElementException;

import static com.talentyco.stream.StreamApiTutorialApplication.employees;

public class MaxSalaryStream {
    public static void main(String[] args) {
        // min or max
        Employee maxSalary =
        employees
                .stream()
                .max(Comparator.comparing(Employee::getSalary))
                .orElseThrow(NoSuchElementException::new);

        System.out.println("\n\n\nStream Sorting: \n" + maxSalary);
    }
}
