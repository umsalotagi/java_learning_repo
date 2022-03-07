package com.example.springdata.product;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.transaction.annotation.Transactional;

import com.example.springdata.product.entities.Product;
import com.example.springdata.product.repos.ProductRepository;

@SpringBootTest
class SpringDataJpaProductDataApplicationTests {
	
	@Autowired
	ProductRepository productRepository;

	@Test
	void contextLoads() {
		assertEquals(true, true);
	}
	
	@Test
	void testCreate() {
		Product p = new Product();
		p.setId(2);
		p.setName("iphone");
		p.setDesc("This is phone");
		p.setPrice(1000d);
		productRepository.save(p);
	}
	
	@Test
	void testRead() {
		Optional<Product> ok = productRepository.findById(2);
		assertNotNull(ok.get());
		assertEquals("iphone", ok.get().getName());
	}
	
	@Test
	void testUpdate() {
		Product product = productRepository.findById(2).get();
		product.setPrice(1200d);
		productRepository.save(product);
	}
	
	@Test
	@Disabled
	void testDelete() {
		// as we have optional returned by find methods ... no need to check exists
		// optional will avoid 2 db calls, and will get only one db call
		if (productRepository.existsById(2)) {
			productRepository.deleteById(2);
		}
	}
	
	@Test
	void testCount() {
		System.out.println("Total count : >>>>>>> " + productRepository.count());
	}
	
	@Test
	void testFindByName() {
		List<Product> findByName = productRepository.findByName("iWatch");
		findByName.forEach(p -> System.out.println("Product found : " + p.getPrice()));
	}
	
	@Test
	void testFindByNameAndDesc() {
		List<Product> findByName = productRepository.findByNameAndDesc("TV", "From Samsung Inc.");
		findByName.forEach(p -> System.out.println("Product found : " + p.getPrice()));
	}
	
	
	@Test
	void testPriceGreaterThan() {
		List<Product> findByName = productRepository.findByPriceGreaterThan(1000d);
		findByName.forEach(p -> System.out.println("Product found : " + p.getPrice()));
	}
	
	@Test
	void testFindByDescContains() {
		List<Product> findByName = productRepository.findByDescContains("Apple");
		findByName.forEach(p -> System.out.println("Product found : " + p.getPrice() + " " + p.getName()));
	}
	
	
	@Test
	void testFindByPriceBetween() {
		List<Product> findByName = productRepository.findByPriceBetween(1500d, 2000d);
		findByName.forEach(p -> System.out.println("Product found : " + p.getPrice() + " " + p.getName()));
	}
	
	@Test
	void testFindByDescLike() {
		List<Product> findByName = productRepository.findByDescLike("%LG%");
		findByName.forEach(p -> System.out.println("Product found : " + p.getPrice() + " " + p.getName()));
	}
	
	@Test
	void testFindByIdsIn() {
		List<Product> findByName = productRepository.findByIdIn(Arrays.asList(1, 2, 3));
		findByName.forEach(p -> System.out.println("Product found : " + p.getPrice() + " " + p.getName()));
	}
	
	@Test
	void testFindByIdsInPageable() {
		List<Product> findByName = productRepository.findByIdIn(Arrays.asList(1, 2, 3, 4), PageRequest.of(0, 2));
		findByName.forEach(p -> System.out.println("Product found : " + p.getPrice() + " " + p.getName()));
	}
	
	@Test
	void testFindAll() {
		Iterable<Product> findAll = productRepository.findAll();
		findAll.forEach(p -> System.out.println("Product find All : " + p.getPrice() + " " + p.getName()));
	}
	
	@Test
	void testFindAllPaging() {
		// Page start with index 0
		Page<Product> findAll = productRepository.findAll(PageRequest.of(0, 2));
		findAll.forEach(p -> System.out.println("Product find All : " + p.getPrice() + " " + p.getName()));
	}
	
	@Test
	void testFindAllSorting() {
		Iterable<Product> findAll = productRepository.findAll(Sort.by(new Sort.Order(Direction.DESC, "name"), new Sort.Order(Direction.ASC, "price")));
		//Iterable<Product> findAll = productRepository.findAll(Sort.by(Direction.DESC, "name", "price"));
		findAll.forEach(p -> System.out.println("Product find All : " + p.getPrice() + " " + p.getName()));
	}
	
	
	@Test
	void findAllPagingAndSorting() {
		Page<Product> findAll = productRepository.findAll(PageRequest.of(0, 2, Sort.by(Direction.DESC, "price")));
		findAll.forEach(p -> System.out.println("Product find All : " + p.getPrice() + " " + p.getName()));
	}
	
	// ##################################################################
	// ##################################################################
	// ##################################################################
	// ##################################################################
	// ##################################################################
	
	@Test
	@Transactional // this is transactional from spring needed for level 1 caching to work
	void testCaching() {
		// level 1 caching : session level 
		// for following 3 queries, only 1 select query is run, for other it will fetch data from cache
		productRepository.findById(1);
		productRepository.findById(1);
		productRepository.findById(1);
	}
	
	// JPA equivalent of hybernate session. used internally y repository classes.
	@Autowired
	EntityManager entityManager;
	// we can access hybernate session from this entity manager
	
	
	@Test
	@Transactional
	void testCachingEvict() {
		Session session = entityManager.unwrap(Session.class); // this is hybernate Session class
		Product product = productRepository.findById(1).get();
		productRepository.findById(1);
		
		session.evict(product); // removing object from session cache
		
		productRepository.findById(1); // again select query is run as object is removed from cache
		// effectively 2 queries will run
	}
	
	
	@Test
	@Transactional
	void testCachingEvict2() {
		Session session = entityManager.unwrap(Session.class); // this is hybernate Session class
		Product product = productRepository.findById(1).get();
		productRepository.findById(1);
		
		session.evict(product); // removing object from session cache
		// Product entity is annotated with @Cache(usage = CacheConcurrencyStrategy.READ_ONLY) 
		// as now Product entity uses level 2 cache, removing from object from session cache will not impact it
		// object will be restored from level 2 SessionFactory cache and put back in level 2 cache
		// so effectively only one query will be triggered.
		productRepository.findById(1); 
	}

}
