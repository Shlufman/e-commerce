package com.sandbox.logging.recognition;

import java.lang.reflect.Field;
import java.util.Random;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import com.sandbox.logging.InjectRandomInt;

public class InjectRandomIntAnnotationBeanPostProcessor implements BeanPostProcessor{

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		Field[] fields= bean.getClass().getDeclaredFields();
		for(Field field: fields) {
			InjectRandomInt annotation= field.getAnnotation(InjectRandomInt.class);
			if(annotation!= null) {
				int min= annotation.min();
				int max =annotation.max();
				Random random = new Random();
				int i = random.nextInt(min, max);
				field.setAccessible(true);
				ReflectionUtils.setField(field, bean, i); // without try catch!!!!!
			}
		}
		return bean;
	}
	
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}
	
}
