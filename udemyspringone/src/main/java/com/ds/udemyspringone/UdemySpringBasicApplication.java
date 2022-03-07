package com.ds.udemyspringone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.ds.udemyspringone.basic.BinarySearchImp;
import com.ds.udemyspringone.config.DataClass;
import com.ds.udemyspringone.config.OneConfig;

@SpringBootApplication  // initialize application context (configuration ) - spring boot
public class UdemySpringBasicApplication {

	public static void main(String[] args) {
		
		// Binary search is dependent on  sortAlgorithm.
		// sortAlgorithm is dependency of Binary search
		
		// BinarySearchImp binarySearch = new BinarySearchImp(new QuickSortAlgorithm()); // Spring will do this ****
		// application context will manage beans, we need to get beans from application context. called container.
		ApplicationContext applicationContext = SpringApplication.run(UdemySpringBasicApplication.class, args);
		// above line will create lot of beans
		BinarySearchImp binarySearch = applicationContext.getBean(BinarySearchImp.class);
		BinarySearchImp binarySearch1 = applicationContext.getBean(BinarySearchImp.class);
		
		// by default any bean is singleton 
		System.out.println(binarySearch);
		System.out.println(binarySearch1);
		
		
		
		int output = binarySearch.binarySearch(new int[] {2,  4, 5, 7}, 4);
		System.out.println(output);
		
		// sparing manage beans, and wire dependency
		
		// beans : objects managed by spring
		// what are beans, @Component
		// it's dependency, @AutoWired
		// where to search for beans ? => no need as we are in same package
		System.out.println("Done .....  UdemySpringBasicApplication");
		
		
		/*
		 * Step 24 : different term used to refer to application context
		 * 1. IOC Container , 2. Application Context , 3. Bean Factory
		 * .... creating instances of dependency was with bean , with spring we shifting resp to sprng is IOC (inversion of control)
		 * framework which provides this is IOC container
		 * n spring there are 2 implementation of IOC container. 1. bean factory, 2. application context
		 * application context is bean factory++ ( AOP, internationalization feature, WebApplicationContext)
		 * use application context in most cases, only when memory is at stake, in IOT use bean factory
		 */
		
		/*
		 * step 25: different component annotation
		 * @Component : generic component
		 * @Contoller : controller in web layer, model is populated and view is rendered, UI layer
		 * @service: business layer
		 * @Repository : encapsulating storage retrieval from relational database layer, data layer
		 */
		
		DataClass d = applicationContext.getBean(DataClass.class);
		System.out.println("Data got111 ..." + d.getData());
		OneConfig con = applicationContext.getBean(OneConfig.class);
		con.changeData();
		d = applicationContext.getBean(DataClass.class);
		System.out.println("Data got222 ..." + d.getData());
	}

}
