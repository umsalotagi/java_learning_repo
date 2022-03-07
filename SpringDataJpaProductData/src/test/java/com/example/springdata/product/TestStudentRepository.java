package com.example.springdata.product;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.annotation.Rollback;

import com.example.springdata.product.entities.Student;
import com.example.springdata.product.repos.StudentRepository;

@SpringBootTest
public class TestStudentRepository {
	
	@Autowired
	StudentRepository studentRepository;
	
	@Test
	void testStudentCreation() {
		Student entity = new Student();
		entity.setFirstName("Umesh");
		entity.setLastName("Salotagi");
		entity.setScore(94);
		
		studentRepository.save(entity);
		
		Student entity2 = new Student();
		entity2.setFirstName("Bill");
		entity2.setLastName("Gates");
		entity2.setScore(86);
		
		studentRepository.save(entity2);
	}
	
	@Test
	void findAllStudents() {
		studentRepository.findAllStudents().forEach(System.out::println);
	}
	
	@Test
	void findAllStudents2() {
		studentRepository.findAllStudents2(PageRequest.of(0, 3, Sort.by(Direction.DESC, "firstName"))).forEach(System.out::println);
	}
	
	@Test
	void testFindAllStudentPartialData() {
		List<Object[]> partialData = studentRepository.findAllStudentPartialData();
		partialData.forEach(x -> {
			System.out.println(x[0]); // firstName
			System.out.println(x[1]); // lastName
		});
	}
	
	@Test
	void findAllStudentByFirstNameJPQL() {
		List<Student> findAll = studentRepository.findAllStudentByFirstName("Umesh");
		findAll.forEach(System.out::println);
	}
	
	@Test
	void findAllStudentByScoreJPQL() {
		List<Student> findAll = studentRepository.findStudentForGivenScore(75, 87);
		findAll.forEach(System.out::println);
	}
	
	@Test
	@Transactional // while performing Delete operation, we need to mark as transactional
	@Rollback(false) 
	// by default transaction in test context is rolled back. to avoid rollback we can use rolllback annotation
	void deleteStudentByFirstNameJPQL() {
		studentRepository.deleteStudentByFirstName("Umesh");
	}
	

}
