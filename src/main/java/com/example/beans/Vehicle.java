package com.example.beans;

import org.springframework.stereotype.Component;

@Component
public class Vehicle {
	private String name = "Toyota";

	public Vehicle() {
		System.out.println("The Vehicle has been created");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void sayHello() {
		System.out.println("Hello from Component Vehicle Bea");
	}
}
