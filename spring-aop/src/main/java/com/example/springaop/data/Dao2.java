package com.example.springaop.data;

import org.springframework.stereotype.Repository;

@Repository
public class Dao2 {
	
	public String retrieveSomething() {
		return "DAO1";
	}

}
