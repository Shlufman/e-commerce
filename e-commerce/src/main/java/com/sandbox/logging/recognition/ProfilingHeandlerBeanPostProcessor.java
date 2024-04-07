package com.sandbox.logging.recognition;

import java.lang.management.ManagementFactory;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

import javax.management.MBeanServer;
import javax.management.ObjectName;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import com.sandbox.logging.Profiling;
import com.sandbox.logging.controller.ProfilingController;

public class ProfilingHeandlerBeanPostProcessor implements BeanPostProcessor {

	private Map<String, Class<?>> map = new HashMap<>();
	private ProfilingController controller = new ProfilingController();

	public ProfilingHeandlerBeanPostProcessor() {
		MBeanServer platformMBeanServer = ManagementFactory.getPlatformMBeanServer();
		try {
			platformMBeanServer.registerMBean(controller, new ObjectName("profiling", "name", "controller"));
		} catch (Exception ex) {
		}
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		Class<?> beanClass = bean.getClass();
		if (beanClass.isAnnotationPresent(Profiling.class)) {
			map.put(beanName, beanClass);
		}
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		Class<?> beanClass = map.get(beanName);
//		System.out.println();
		if (beanClass != null) {
			System.out.println("beanName " + beanName);
			return Proxy.newProxyInstance(beanClass.getClassLoader(), beanClass.getInterfaces(),
					new InvocationHandler() {

						@Override
						public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
							System.out.println("!");
							if (controller.isEnabled()) {
								System.out.println("Profiling!!!!");
								long before = System.nanoTime();
								Object retVal = method.invoke(bean, args);
								long after = System.nanoTime();
								System.out.println(after - before);
								System.out.println("End profiling!!!");
								return retVal;
							} else {
								return method.invoke(bean, args);
							}
						}
					});
		}

		return bean;
	}

}
