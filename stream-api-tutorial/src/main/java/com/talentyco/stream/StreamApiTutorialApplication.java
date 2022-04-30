package com.talentyco.stream;

import com.talentyco.stream.entities.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

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
				new Employee("Martina", "Silva Nieto", 2300.0, List.of("Project 4", "Project 5"))
		);
		employees.add(
				new Employee("Federico", "Echeñique", 7800.0, List.of("Project 5", "Project 2"))
		);
	}

	public static void main(String[] args) {
		//SpringApplication.run(StreamApiTutorialApplication.class, args);

		// foreach
	employees.stream()
			.forEach(employee -> System.out.println(employee));

	}
}
