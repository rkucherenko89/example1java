package com.example.main;

import com.example.beans.Vehicle;
import com.example.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example1 {
	public static void main(String[] args) {
		var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
		Vehicle vehicle1 = context.getBean(Vehicle.class);
		Vehicle vehicle2 = context.getBean("vehicleBean", Vehicle.class);
		System.out.println(vehicle1.hashCode());
		System.out.println(vehicle2.hashCode());
	}
}
