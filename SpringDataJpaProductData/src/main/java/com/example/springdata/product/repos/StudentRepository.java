package com.example.springdata.product.repos;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.example.springdata.product.entities.Student;

public interface StudentRepository extends PagingAndSortingRepository<Student, Long> {
	
	@Query("from Student") // similar to select * from Student, do not add select or * in JPQL
	List<Student> findAllStudents();
	
	@Query("from Student") // to support paging just add Pageable
	List<Student> findAllStudents2(Pageable pageable);
	
	@Query("select st.firstName, st.lastName from Student st") // as is alias
	List<Object[]> findAllStudentPartialData();
	
	@Query("from Student where firstName=:firstName") 
	List<Student> findAllStudentByFirstName(@Param("firstName") String firstName);
	
	@Query("from Student where score>:min and score<:max")
	List<Student> findStudentForGivenScore(@Param("min") int min, @Param("max") int max);
	
	@Modifying
	@Query("delete from Student where firstName = :firstName")
	void deleteStudentByFirstName(@Param("firstName") String firstName);

}
