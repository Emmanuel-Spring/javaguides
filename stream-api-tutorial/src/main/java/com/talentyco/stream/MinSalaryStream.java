package com.talentyco.stream;

import com.talentyco.stream.entities.Employee;

import java.util.Comparator;
import java.util.NoSuchElementException;

import static com.talentyco.stream.StreamApiTutorialApplication.employees;

public class MinSalaryStream {
    public static void main(String[] args) {
        // min or max
        Employee minSalary =
        employees
                .stream()
                .min(Comparator.comparing(Employee::getSalary))
                .orElseThrow(NoSuchElementException::new);

        System.out.println("\n\n\nStream Sorting: \n" + minSalary);
    }
}
