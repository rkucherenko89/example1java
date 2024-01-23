package com.example.main;

import com.example.beans.Vehicle;
import com.example.config.ProjectConfig;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Random;
import java.util.function.Supplier;

public class Example1 {
	public static void main(String[] args) {
		var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

		Vehicle honda = new Vehicle();
		honda.setName("Honda");
		Supplier<Vehicle> hondaSupplier = () -> honda;

		Supplier<Vehicle> audiSupplier = () -> {
			Vehicle audi = new Vehicle();
			audi.setName("Audi");
			return audi;
		};

		Random random = new Random();
		int randomNumber = random.nextInt(10);
		System.out.printf("Random number is %s%n", randomNumber);

		if (randomNumber % 2 == 0) {
			context.registerBean("honda", Vehicle.class, hondaSupplier);
		} else {
			context.registerBean("audi", Vehicle.class, audiSupplier);
		}

		Vehicle hondaVehicle = null;
		Vehicle audiVehicle = null;
		try {
			hondaVehicle = context.getBean("honda", Vehicle.class);
		} catch (Exception exception) {
			if (exception instanceof NoSuchBeanDefinitionException) {
				System.out.println("Apparently the random number is odd and Honda vehicle hasn't been created");
			} else {
				System.out.println(exception.getMessage());
			}
		}

		try {
			audiVehicle = context.getBean("audi", Vehicle.class);
		} catch (Exception exception) {
			if (exception instanceof NoSuchBeanDefinitionException) {
				System.out.println("Apparently the random number is even and Audi vehicle hasn't been created");
			} else {
				System.out.println(exception.getMessage());
			}
		}

		if (hondaVehicle != null) {
			System.out.println("Honda was created");
		} else if (audiVehicle != null) {
			System.out.println("Audi was created");
		}
		System.out.println("added second line the right one");
	}
}
