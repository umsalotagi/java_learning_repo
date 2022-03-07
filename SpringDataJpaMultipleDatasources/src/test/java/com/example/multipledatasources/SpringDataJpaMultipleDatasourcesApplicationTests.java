package com.example.multipledatasources;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.multipledatasources.coupon.entities.Coupon;
import com.example.multipledatasources.coupon.repos.CouponRepository;
import com.example.multipledatasources.product.entities.Product;
import com.example.multipledatasources.product.repos.ProductRepository;

@SpringBootTest
class SpringDataJpaMultipleDatasourcesApplicationTests {
	
	@Autowired
	CouponRepository couponRepository;
	
	@Autowired
	ProductRepository productRepository;

	@Test
	void testSaveCoupon() {
		Coupon c = new Coupon();
		c.setCode("SUPERCODE55");
		c.setDiscount(new BigDecimal(20));
		c.setExpDate("2/2/2022");
		System.out.println(couponRepository.save(c));
	}
	
	@Test
	void testSaveProduct() {
		Product p = new Product();
		p.setName("MacBook Pro");
		p.setDescription("Its colls");
		p.setPrice(new BigDecimal(2000));
		// this is transient property, not stored n ==in database, but useful for REST services.
		p.setCouponCode("SUPERCODE");
		System.out.println(productRepository.save(p));
	}

}
