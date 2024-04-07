package com.sandbox.aop;

import org.aspectj.lang.annotation.Pointcut;

public class Pointcuts {

//	@Pointcut("execution(* telran.ecommerce.service.manager.ColorService.get*(..))")
//	public void allGetMethodsColorService() {
//	}
//
//	@Pointcut("execution(* telran.ecommerce.service.manager.ColorService.add*(..))")
//	public void allAddMethodsColorService() {}
	
//	@Pointcut("execution(* telran.ecommerce.service.manager.ColorService.addColor(..))")
//	public void allAddMethodsColorService() {}
//	
//	@Before("execution(public String getName())")
//	public void getNameAdvice(){
//		System.out.println("Executing Advice on getName()");
//	} 
	@Pointcut("within(@org.springframework.stereotype.Service *)")
	public void serviceClassMethods() {
	}

	// All methods of all services from package telran.ecommerce.service.manager
	@Pointcut("within(telran.ecommerce.service.manager.*)")
	public void allServicesManagerClassesMethods() {
	}
	
	// All methods of all controllers from package telran.ecommerce.service.manager
	@Pointcut("within(telran.ecommerce.controller.manager.*)")
	public void allControllersManagerClassesMethods() {
	}
	
	// All methods of all controllers from package telran.ecommerce.service.manager
	@Pointcut("within(telran.ecommerce.controller.generic.*)")
	public void allControllersGenericClassesMethods() {
	}

	@Pointcut("@annotation(telran.ecommerce.annotation.Loggable)")
	public void loggableMethods() {
	}

}
