package com.udemy.databasedemo.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.udemy.databasedemo.entity.Person;

// as this class is also component but it connects to db so repository
@Repository
public class PersonJdbcDAO {
	
	/*
	 *  spring provides way to connect to database. this is spring jdbc. very easy compared to raw jdbc without spring
	 *  in raw jdbc we need to create connection and also make sure it get scloses even in exception.
	 *  also manually map values
	 *  
	 *  in spring jdbc making connection, closing connection when exception and mapping values is all handled by spring
	 */
	@Autowired
	JdbcTemplate jdbcTemplate ;
	
	/*
	 * when properties of bran and column names matches then default Mapper works well
	 * In cases where both do not match then we need to create out own Mapper. Custom mapper
	 */
	public class PersonRowMapper implements RowMapper<Person> {

		@Override
		public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
			Person person = new Person();
			person.setId(rs.getInt("id"));
			person.setName(rs.getString("name"));
			person.setLocation(rs.getString("location"));
			person.setBirthDate(rs.getTimestamp("birth_date")); // sets to - 2021-06-15 00:00:00.0
			//person.setBirthDate(rs.getDate("birth_date")); // this also works and sets to -  2021-06-15
			return person;
		}
		
	}
	
	public List<Person> findAll() {
		// a way to map data returned by query to class objects (entity)
		//return jdbcTemplate.query("SELECT * FROM person", new BeanPropertyRowMapper(Person.class));
		return jdbcTemplate.query("SELECT * FROM person", new PersonRowMapper());
	}
	
	public Person find(int id) {
		return jdbcTemplate.queryForObject("SELECT * FROM person WHERE id=?", new Object[] {id}, new BeanPropertyRowMapper<Person>(Person.class));
	}
	
	public int deleteById(int id) {
		return jdbcTemplate.update("DELETE FROM person WHERE id=?", new Object[] {id});
	}
	
	public int insert(Person person) {
		return jdbcTemplate.update("INSERT INTO person VALUES (?,?,?,?)", 
				new Object[] {person.getId(), person.getName(), person.getLocation(), new Timestamp(person.getBirthDate().getTime()) });
	}
	
	public int update(Person person) {
		return jdbcTemplate.update("UPDATE person SET name=?, location=?, birth_date=? WHERE id=?", 
				new Object[] { person.getName(), person.getLocation(), new Timestamp(person.getBirthDate().getTime()) , person.getId()});
	}

}
