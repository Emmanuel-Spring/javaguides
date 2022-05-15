package com.talentyco.stream;

import static com.talentyco.stream.StreamApiTutorialApplication.employees;

public class ReduceStreamEmployee {
    public static void main(String[] args) {

        // reduce
        Double totalSalary =
                employees
                        .stream()
                        .map(employee -> employee.getSalary())
                        .reduce(0.0, Double::sum);
        System.out.println("\n\n\nStream Reduce Total Salary: \n" + totalSalary);
    }
}
