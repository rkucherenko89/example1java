package com.example.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;
import java.util.logging.Logger;

@Aspect
@Component
public class LoggerAspect {
	private final Logger logger = Logger.getLogger(LoggerAspect.class.getName());

	@Around("execution(* com.example.services.*.*(..))")
	public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
		logger.info(joinPoint.getSignature().toString() + " method execution start");
		Instant start = Instant.now();
		Object returnValue = joinPoint.proceed();
		Instant finish = Instant.now();
		long timeElapsed = Duration.between(start, finish).toMillis();
		logger.info(joinPoint.getSignature().toString() + " method execution finish");
		logger.info("Time took to execute the method " + timeElapsed + " milliseconds");
		return returnValue;
	}
}
