package com.ds.udemyspringone;

import java.util.Arrays;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ds.udemyspringone.basic.BinarySearchImp;
import com.ds.udemyspringone.xmlcontext.XmlPersonDAO;

//here we do not add any annotation as all the beans are specified in applicationCOntext xml file
//autowiring is also defined there.

//Defining Spring application context with xml. This was before spring 2.
//there are 3 ways to define spring application context
//1. spring boot way, 2. java core spring way , 3. xml way
// to launch xml application context this is application file.

public class UdemySpringXmlContextApplication {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		XmlPersonDAO xmlPersonDAO = applicationContext.getBean(XmlPersonDAO.class);
		
		System.out.println(xmlPersonDAO);
		System.out.println(xmlPersonDAO.getXmlJdbcConnection());
		
		System.out.println("Done .....******UdemySpringXmlContextApplication ");
		
		// component scan added in application context xml.
		BinarySearchImp binarySearch = applicationContext.getBean(BinarySearchImp.class);
		System.out.println(binarySearch);
		System.out.println(binarySearch.binarySearch(new int[] {3,  4, 6}, 5));
		
		System.out.println(Arrays.toString(applicationContext.getBeanDefinitionNames()));
		
		applicationContext.close();
		
	}

}
