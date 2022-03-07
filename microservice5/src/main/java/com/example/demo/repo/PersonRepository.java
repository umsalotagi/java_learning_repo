package com.example.demo.repo;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

// we do trasaction here and this is repository
@Repository
@Transactional
public class PersonRepository {
	
	/*
	 * To connect to database, use Entity Manager. Entity manager manages the entities. All the operations that you are performing in a specific session. Are all stored inside your Entity Manager. All the operations are not really stored in the entity manager

but in something called persistence context.

Entity Manager is the interface to the persistence context.

All operations have to be going through the Entity Manager.
	 */
	
	@PersistenceContext
	EntityManager entityManager;
	
	public Optional<Person> findById(int id) {
		return Optional.of(entityManager.find(Person.class, id));
	}
	
	public void deleteById(int id) {
		Optional<Person> p = findById(id);
		entityManager.remove(p.get());
	}
	
	// for both update and insert we use merge of entityManager
	public Person save(Person person) {
		return entityManager.merge(person);
	}
	
	// HQL : Hybernate query language (JPQL) : java persitence query language
	// JPQL does not use tables from database but use entities
	public List<Person> findAll() {
		TypedQuery<Person> namedQuery = entityManager.createNamedQuery("get_all", Person.class);
		return namedQuery.getResultList();
	}
	

}
