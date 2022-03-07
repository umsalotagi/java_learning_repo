package com.udemy.databasedemo.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.udemy.databasedemo.entity.Person;

/*
 * JAP : Java Persistent API
 * transaction management in repository 
 * ideally transaction managed around business service but for this example we are doing in repo
 */

@Repository
@Transactional
public class PersonJpaRepository {
	
	// connect to database
	/*
	 * Entitymanager is interface to PersitentContext. It manages entities. 
	 * all operation stored in @PersistenceContext. all operation have to be going throiugh entity manager.
	 */
	@PersistenceContext
	EntityManager entityManager;
	
	
	public Person findById( int id) {
		return entityManager.find(Person.class, id);
	}
	
	public Person update(Person person) {
		return entityManager.merge(person); // if id present it will update or it will insert
	}
	
	public Person insert(Person person) {
		return entityManager.merge(person); // if id present it will update or it will insert
	}
	
	public void deleteById(int id) {
		Person p=findById(id);
		entityManager.remove(p);
	}
	
	// JPQL : Java persitent Query Langauge . 
	public List<Person> findAll() {
		// Named query to be written in entity , with JPQL at strt of Entity class
		TypedQuery<Person> namedQeury = entityManager.createNamedQuery("find_all_persons", Person.class);
		return namedQeury.getResultList();
	}
	
	
	
}
