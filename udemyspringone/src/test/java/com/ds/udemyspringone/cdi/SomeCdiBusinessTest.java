package com.ds.udemyspringone.cdi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import com.ds.udemyspringone.UdemySpringCDIApplication;

// when we run test with Mockito we do not need contextConfiguration, SpringExtension. So this test will be 10x fatser
// as this will not load spring context at all
// in cases of spring MVC we need to use spring-test, bit most of cases Mockito will be good
@ExtendWith(MockitoExtension.class)
class SomeCdiBusinessTest {
	
	@InjectMocks
	SomeCDIBusiness someCdiBusiness;
	
	@Mock
	SomeCdiDAO someCdiDao;
//
//	@Test
//	void testFindGreatest() {
//		int result = someCdiBusiness.findGreatest();
//		assertEquals(89, result);
//	}
	
	// in this test, we are depending on data layer. this is not good practice, as when data source is down, unit test may fail. 
	// also we will not able to test case with extensive different kinds of data
	// how does this business will react to different data
	// so we will create mocks of someCdiDAO
	
	@Test
	void testFindGreatest2() {
		Mockito.when(someCdiDao.getData()).thenReturn(new int[] {23, 55, 67}).thenReturn(new int[] {0}).thenReturn(new int [] {});
		assertEquals(67, someCdiBusiness.findGreatest());
		assertEquals(0, someCdiBusiness.findGreatest());
		assertEquals(Integer.MIN_VALUE, someCdiBusiness.findGreatest());
	}

}
