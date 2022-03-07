package com.ds.udemyspringone;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.ds.springcorebasic.BinarySearchImp2;

/**
 * For this example we use Spring without springboot
 * for that we remove following dependency
 * 		<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter</artifactId>
</dependency>

 * and add following two
 * 		<dependency>
	<groupId>org.springframework</groupId>
	<artifactId>spring-core</artifactId>
</dependency>

<dependency>
	<groupId>org.springframework</groupId>
	<artifactId>spring-context</artifactId>
</dependency>

		<dependency>
			<groupId>org.slf4j</groupId>
			<artifactId>slf4j-api</artifactId>
		</dependency>
		
		and implementation for it 
		
				<dependency>
			<groupId>ch.qos.logback</groupId>
			<artifactId>logback-classic</artifactId>
		</dependency>
		
		to remove error in PostConstruct and PreDestroy when used with JDK11. (no need in jdk 8)
				<dependency>
		  <groupId>javax.annotation</groupId>
		  <artifactId>javax.annotation-api</artifactId>
		  <version>1.3.2</version>
		</dependency>
 * 
 */

@Configuration  // java way of defining  (initializing) application context
@ComponentScan("com.ds.springcorebasic") // java core spring does not scan components on its own like spring boot
public class UdemySpringCoreBasicApplication {

	public static void main(String[] args) {
		
		// java way of defining application context
		// to load appcontext by java we use AnnotationConfigApplicationContext
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(UdemySpringCoreBasicApplication.class);
		BinarySearchImp2 binarySearch = applicationContext.getBean(BinarySearchImp2.class);
		System.out.println(binarySearch);
		

		BinarySearchImp2 binarySearch1 = applicationContext.getBean(BinarySearchImp2.class);
		System.out.println(binarySearch1);
		
		int output = binarySearch.binarySearch(new int[] {2,  4, 5, 7}, 4);
		System.out.println(output);
		
		System.out.println("Done .....");
		
		((AnnotationConfigApplicationContext) applicationContext).close();
	}

}
