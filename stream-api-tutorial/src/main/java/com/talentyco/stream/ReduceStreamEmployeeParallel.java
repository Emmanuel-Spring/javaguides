package com.talentyco.stream;

import static com.talentyco.stream.StreamApiTutorialApplication.employees;

public class ReduceStreamEmployeeParallel {
    public static void main(String[] args) {

        // reduce
        // ParalelStream
        Double totalSalaryParalel =
                employees
                        .parallelStream()
                        .map(employee -> employee.getSalary())
                        .reduce(0.0, Double::sum);
        System.out.println("\n\n\nStream Reduce Total Salary with ParalelStream() : \n" + totalSalaryParalel);

    }
}
