package com.talentyco.stream;

import com.talentyco.stream.entities.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class StreamApiTutorialApplication {

	static List<Employee> employees = new ArrayList<>();
	static {
		employees.add(
				new Employee("Emmanuel", "Nieto", 6500.0, List.of("Project 1", "Project 2"))
		);
		employees.add(
				new Employee("Antonio", "Santibañez", 8500.0, List.of("Project 2", "Project 3"))
		);
		employees.add(
				new Employee("Magdalena", "Rodriguez", 9000.0, List.of("Project 1", "Project 4"))
		);
		employees.add(
				new Employee("Nataly", "Silva", 11000.0, List.of("Project 2", "Project 6"))
		);
		employees.add(
				new Employee("Martina", "Silva", 2300.0, List.of("Project 4", "Project 5"))
		);
		employees.add(
				new Employee("Federico", "Echeñique", 7800.0, List.of("Project 5", "Project 2"))
		);
	}

	public static void main(String[] args) {
		//SpringApplication.run(StreamApiTutorialApplication.class, args);

	// foreach
		System.out.println("\nForEach Stream: \n");
	employees.stream()
			.forEach(employee -> System.out.println(employee));

	// map
	// Collect
	List <Employee> increasedSalary =
		employees.stream()
			.map(employee -> new Employee(
					employee.getLasttName(),
					employee.getFirstName(),
					employee.getSalary() * 1.10,
					employee.getProjects()
			))
			.collect(Collectors.toList());
		System.out.println("\n\n\nStream List (Map): \n" + increasedSalary);

		// Set
		// Collect
		Set<Employee> increasedSalarySet =
				employees.stream()
						.map(employee -> new Employee(
								employee.getLasttName(),
								employee.getFirstName(),
								employee.getSalary() * 1.10,
								employee.getProjects()
						))
						.collect(Collectors.toSet());
		System.out.println("\n\n\nStream Set: \n" + increasedSalarySet);


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


		// filter Stream
		// findFirst
		Employee firstEmployee =
				employees
						.stream()
						.filter(employee -> employee.getSalary() > 8000)
						.map(employee -> new Employee(
								employee.getLasttName(),
								employee.getFirstName(),
								employee.getSalary() * 1.10,
								employee.getProjects()
						))
						.findFirst()
						.orElse(null);
		System.out.println("\n\n\nStream findFirst Salary: \n" + firstEmployee);


		// flatMap
		String projects =
			employees
			.stream()
			.map(employee -> employee.getProjects())
			.flatMap(strings -> strings.stream())
			.collect(Collectors.joining(", "));
		System.out.println("\n\n\nStream flatMap projects: \n" + projects);


		// Short Circuit operations
		List<Employee> shortCircuit =
			employees
			.stream()
			.skip(1)
			.limit(1)
			.collect(Collectors.toList());
		System.out.println("\n\n\nStream Short Circuit: \n" + shortCircuit);


		// Finite Data
		System.out.println("\n\n\nStream Finite Data: ");
		Stream.generate(Math::random)
				.limit(5)
				.forEach(value -> System.out.println(value));


		// Sorting
		List<Employee> sortedEmployees =
				employees
						.stream()
						.sorted((o1, o2) -> o1.getFirstName()
								.compareToIgnoreCase(o2.getFirstName()))
						.collect(Collectors.toList());
		System.out.println("\n\n\nStream Sorting: \n" + sortedEmployees);


		// min or max
		employees
				.stream()
				.max(Comparator.comparing(Employee::getSalary))
				.orElseThrow(NoSuchElementException::new);
		
		
		// reduce
		Double totalSalary = 
				employees
						.stream()
						.map(employee -> employee.getSalary())
						.reduce(0.0, Double::sum);
		System.out.println("\n\n\nStream Reduce Total Salary: \n" + totalSalary);



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