package com.talentyco.stream;

import com.talentyco.stream.entities.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

@SpringBootApplication
public class StreamApiTutorialApplication {

	static List<Employee> employees = new ArrayList<>();
	static {
		employees.add(
				new Employee("Emmanuel", "Nieto", 6500.0, List.of("Project 1", "Project 2", "Project 3", "Project 4", "Project 5", "Project 6", "Project 7", "Project 8", "Project 9", "Project 10"))
		);
		employees.add(
				new Employee("Antonio", "Santibañez", 8500.0, List.of("Project 2", "Project 3", "Project 6", "Project 7", "Project 8", "Project 9", "Project 10"))
		);
		employees.add(
				new Employee("Magdalena", "Rodriguez", 9000.0, List.of("Project 9", "Project 6"))
		);
		employees.add(
				new Employee("Nataly", "Silva", 11000.0, List.of("Project 1", "Project 6"))
		);
		employees.add(
				new Employee("Martina", "Silva", 2300.0, List.of("Project 4", "Project 8"))
		);
		employees.add(
				new Employee("Federico", "Echeñique", 7800.0, List.of("Project 5", "Project 6", "Project 7", "Project 8", "Project 9", "Project 10"))
		);
		employees.add(
				new Employee("Marianela", "Echeñique", 7800.0, List.of("Project 5", "Project 3"))
		);
		employees.add(
				new Employee("Javier", "Escobar", 17800.0, List.of("Project 5", "Project 6", "Project 6", "Project 7", "Project 8", "Project 9", "Project 10", "Project 6", "Project 7", "Project 8", "Project 9", "Project 10"))
		);
		employees.add(
				new Employee("Andreina", "Betancurt", 8900.0, List.of("Project 9", "Project 7"))
		);
		employees.add(
				new Employee("Alely", "Zaldivar", 12900.0, List.of("Project 9", "Project 7", "Project 10"))
		);
	}

	public static void main(String[] args) {
		//SpringApplication.run(StreamApiTutorialApplication.class, args);

	}
}