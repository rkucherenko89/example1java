package com.example.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.logging.Level;
import java.util.logging.Logger;

@Aspect
@Component
@Order(2)
public class LoggerAspect {
	private final Logger logger = Logger.getLogger(LoggerAspect.class.getName());

	@Around("execution(* com.examplssssssssssse.services.*.*(..))")
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

	@Around("@annotation(com.example.interfaces.LogAspect)")
	public Object logWithAnnotation(ProceedingJoinPoint joinPoint) throws Throwable {
		logger.info(joinPoint.getSignature().toString() + " method execution start");
		Instant start = Instant.now();
		Object returnValue = joinPoint.proceed();
		Instant finish = Instant.now();
		long timeElapsed = Duration.between(start, finish).toMillis();
		logger.info(joinPoint.getSignature().toString() + " method execution finish");
		logger.info("Time took to execute the method " + timeElapsed + " milliseconds");
		return returnValue;
	}

	@AfterThrowing(value = "execution(* com.example.services.*.*(..))", throwing = "exception")
	public void logException(JoinPoint joinPoint, Exception exception) {
		logger.log(Level.SEVERE, joinPoint.getSignature() + " An exception thrown with the help of" +
				" @AfterThrowing which happened due to: " + exception.getMessage()
		);
	}

	@AfterReturning(value = "execution(* com.example.services.*.*(..))", returning = "returnValue")
	public void logStatus(JoinPoint joinPoint, Object returnValue) {
		logger.log(Level.INFO, MessageFormat.format("{0} method successfully processed with the status \"{1}\"",
				joinPoint.getSignature(), returnValue.toString())
		);
	}
}
