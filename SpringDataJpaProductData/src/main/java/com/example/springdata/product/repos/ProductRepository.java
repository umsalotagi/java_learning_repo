package com.example.springdata.product.repos;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.springdata.product.entities.Product;

public interface ProductRepository extends PagingAndSortingRepository<Product, Integer> {
	
	List<Product> findByName(String name);
	
	List<Product> findByNameAndDesc(String name, String desc);
	
	List<Product> findByPriceGreaterThan(Double price);
	
	List<Product> findByDescContains(String desc);
	
	// result will have both end including .. price1 and price2 product will be in result
	List<Product> findByPriceBetween(Double price1, Double price2);
	
	// add like in %LG%
	// TODO: difference between contains and Like
	List<Product> findByDescLike(String desc);
	
	List<Product> findByIdIn(List<Integer> ids);
	
	List<Product> findByIdIn(List<Integer> ids, Pageable pageable);

}
