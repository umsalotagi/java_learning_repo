package com.springboot.basic.springbootin10steps;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// registered as component.
@RestController
public class BooksController {
	
	@GetMapping("/books")
	public List<Book> getAllBooks() {
		return Arrays.asList(
				new Book(1l, "My Experiements On Truth", "M. K. Gandhi"),
				new Book(2l, "Maji Janmathep", "V. D. Savarkar")
				);
	}
	
	/*  whenever we make some changes in java code, it does not get reflected to web url immediately. we need to restart app.
	  to avoid this and enable runtime update of app, we need to add dependency of developer tool.
	 java changes updated immediately
	 * 
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
		</dependency>
	 */
}
