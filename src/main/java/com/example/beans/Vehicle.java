package com.example.beans;

public class Vehicle {
	private String name;

	public Vehicle() {
		System.out.println("The Vehicle has been created");

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
