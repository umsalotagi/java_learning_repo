package com.interviewtests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class Temp {
	
	public static void main(String[] args) {
		
		
		System.out.println("ok");
		//const cart = [{order: 123,category: 'Clothing',price: 999},{order: 234,category: 'Footware',price: 799},{order: 456,category: 'Clothing',price: 599},{order: 789,category: 'Home Appliances',price: 5000}];
		
		List<OrderDetails> orders = new ArrayList<>();
		int deliveryCharge = ( (int)orders.stream().filter(x -> x.price<800).count() * 50);
		
		ArrayList<Integer> ok = new ArrayList<>();
		//ok.
		//Function x = (p) -> {System.out.println("in lambda"+p);}; it returns something
		Consumer y = (p) -> {System.out.println("in lambda"+p);};
		y.accept("ok");
		
		Runnable r = () -> System.out.println("in thread");
		Thread t = new Thread(r);
		t.start();
		//ok.stream().
		

	}
	
	public static class OrderDetails {
		private int order;
		private String category;
		private double price;
		
		public OrderDetails(int order, String category, double price) {
			this.order = order;
			this.category = category;
			this.price = price;
		}
	}
	
	/*
	 * 
	 * @ModelAttribute FileSystemItemFilter filter
	 * @RequestParam(value = "versionId", required = false) Long versionId,
	
	@RestController
	@RequestMapping("/api/books")
	public class Book{
		
		@GetMapping
		public ResponseEntity<List<BookEntity>> getBooks() {
			
		}
		
		@GetMapping("/{id}")
		public ResponseEntity<BookEntity> getBooks(@PathVariable("id") String id ) {
			
		}
		
		@GetMapping("/{id}/authors")
		public ResponseEntity<List<AuthorEntity> getBooks(@PathVariable("id") String id ) {
			
		}
		
		@PostMapping
		
		
		@DeleteMapping("/{id}")
		public ResponseEntity<BookEntity> getBooks(@PathParam("id") String id ) {
			
		}*/
		
		
	

}


