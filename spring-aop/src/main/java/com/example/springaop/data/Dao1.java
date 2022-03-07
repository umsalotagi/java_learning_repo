package com.example.springaop.data;

import org.springframework.stereotype.Repository;

import com.example.springaop.aspect.TrackTime;

@Repository
public class Dao1 {
	
	@TrackTime
	public String retrieveSomething() {
		return "DAO1";
	}

}
