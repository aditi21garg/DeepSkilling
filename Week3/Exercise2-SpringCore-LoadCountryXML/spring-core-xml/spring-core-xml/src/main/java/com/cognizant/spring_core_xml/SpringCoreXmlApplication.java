package com.cognizant.spring_core_xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.spring_core_xml.model.Country;

public class SpringCoreXmlApplication {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Country country = (Country) context.getBean("country");
		System.out.println("country=" + country);
	}
}
