package com.sandbox.aop;

import java.time.LocalDateTime;

//import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.After;
//import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import lombok.Setter;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
@Setter
public class LoggingAspect {
	private final static String START_TEMPLATE = "{}  START {}, arguments: {}.";
	private final static String END_TEMPLATE = "{}  END {}, result: {}.";


	@Around("Pointcuts.allControllersManagerClassesMethods()") // || Pointcuts.allServicesManagerClassesMethods()
	public Object aroundAllServicesManagerClassesMethodsAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		StringBuilder stringArgs = new StringBuilder();
		for (Object argument : joinPoint.getArgs()) {
			stringArgs.append(argument);
		}

		
		log.info(START_TEMPLATE,LocalDateTime.now(), methodSignature.getMethod(), stringArgs);

		Object result = null;
//		try {
			result = joinPoint.proceed();
//		} catch (Throwable e) {
//			log.error(e.getMessage(), e);
//			result = new CustomResponse<>(null, CustomStatus.EXCEPTION);
//		}

		log.info(END_TEMPLATE,LocalDateTime.now(), methodSignature.getMethod(), result);
		return result;
	}

}
