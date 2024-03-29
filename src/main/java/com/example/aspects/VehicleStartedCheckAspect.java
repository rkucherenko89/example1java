package com.example.aspects;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@Aspect
@Order(1)
public class VehicleStartedCheckAspect {
	private Logger logger = Logger.getLogger(VehicleStartedCheckAspect.class.getName());

	@Before("execution(* com.example.services.*.*(..)) && args(vehicleStarted, ..)")
	public void checkVehicleStarted(JoinPoint joinPoint, boolean vehicleStarted) throws Throwable {
		if (!vehicleStarted) {
			throw new RuntimeException("Vehicle not started");
		}
	}
}
