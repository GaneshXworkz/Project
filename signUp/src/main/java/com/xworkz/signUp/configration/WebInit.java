package com.xworkz.signUp.configration;

import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WebInit extends AbstractAnnotationConfigDispatcherServletInitializer implements WebMvcConfigurer{

	public WebInit() {
		log.info("Running WebInt.......!");
	}

	@Override
	protected Class<?>[] getRootConfigClasses() {
		log.info("Running getRootConfigClasses....!");
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		log.info("Running getServletConfigClasses....!");
		return new Class[] {SpringConigration.class};
	}

	@Override
	protected String[] getServletMappings() {
		log.info("Running getServletMappings....!");
		return new String[] {"/"};	
		
		}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		log.info("created configureDefaultServletHandling");
	configurer.enable();
	
	}	

}
