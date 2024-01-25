package com.example.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {
	private String name = "Lucy";
	private final Vehicle vehicle;

	@Autowired
	public Person(Vehicle vehicle1) {
		System.out.println("The Person has been created");
		this.vehicle = vehicle1;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}
}
