package com.sandbox.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sandbox.dto.manager.ColorDTO;
import com.sandbox.entity.manager.Color;
import com.sandbox.logging.recognition.InjectRandomIntAnnotationBeanPostProcessor;
import com.sandbox.logging.recognition.ProfilingHeandlerBeanPostProcessor;
import com.sandbox.util.mapper.abstraction.CommonMapper;

@Configuration
//@ComponentScan(basePackages = "telran.ecommerce.util.manager")
public class ConfigurationApplication {
	@Bean
	public InjectRandomIntAnnotationBeanPostProcessor getInjectRandomIntAnnotationBeanPostProcessor() {
		return new InjectRandomIntAnnotationBeanPostProcessor();
	}
	
	@Bean
	public ProfilingHeandlerBeanPostProcessor getProfilingHeandlerBeanPostProcessor() {
		return new ProfilingHeandlerBeanPostProcessor();
	}

}
