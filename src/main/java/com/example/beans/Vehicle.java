package com.example.beans;


import com.example.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("vehicleBean")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class Vehicle {
	private String name = "Toyota";
	private final VehicleService service;

	@Autowired
	public Vehicle(VehicleService service) {
		this.service = service;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public VehicleService getService() {
		return service;
	}

	public void sayHello() {
		System.out.println("Hello from Component Vehicle B");
	}
}
