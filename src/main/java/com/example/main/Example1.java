package com.example.main;

import com.example.beans.Person;
import com.example.beans.Vehicle;
import com.example.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example1 {
	public static void main(String[] args) {
		var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
		Person person = context.getBean(Person.class);
		Vehicle vehicle = context.getBean(Vehicle.class);

		System.out.printf("Person name is %s%n", person.getName());
		System.out.printf("%s's vehicle name is %s%n", person.getName(), person.getVehicle().getName());
 	}
}
