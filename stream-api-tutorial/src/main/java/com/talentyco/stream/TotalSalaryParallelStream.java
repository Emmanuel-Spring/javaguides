package com.talentyco.stream;

import static com.talentyco.stream.StreamApiTutorialApplication.employees;

public class TotalSalaryParallelStream {
    public static void main(String[] args) {

        // reduce
        // ParalStream
        Double totalSalaryParallelStream =
                employees.
                        parallelStream()
                        .map(employee -> employee.getSalary())
                        .reduce(0.0, Double::sum);
        System.out.println("\n\n\nStream Reduce Total Salary with ParalelStream() : \n" + totalSalaryParallelStream);

    }
}
