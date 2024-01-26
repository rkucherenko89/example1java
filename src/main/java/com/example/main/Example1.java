package com.example.main;

import com.example.beans.Person;
import com.example.config.ProjectConfig;
import com.example.services.VehicleService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example1 {
	public static void main(String[] args) {
		var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
		VehicleService service1 = context.getBean(VehicleService.class);
		VehicleService service2 = context.getBean("service", VehicleService.class);
		System.out.println("Service1 hashCode is " + service1.hashCode());
		System.out.println("Service2 hashCode is " + service2.hashCode());
		if (service1 == service2) {
			System.out.println("They are the singleton");
		}
	}
}
