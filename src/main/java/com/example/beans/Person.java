package com.example.beans;

public class Person {
	private String name;
	private Vehicle vehicle;

	public Person() {
		System.out.println("The Person has been created");
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

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
}
