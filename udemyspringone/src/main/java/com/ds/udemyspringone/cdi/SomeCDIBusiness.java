package com.ds.udemyspringone.cdi;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Named
public class SomeCDIBusiness {
	
	@Inject
	SomeCdiDAO someCdiDAO;

	public SomeCdiDAO getSomeCdiDAO() {
		return someCdiDAO;
	}

	public void setSomeCdiDAO(SomeCdiDAO someCdiDAO) {
		this.someCdiDAO = someCdiDAO;
	}
	
	public int findGreatest() {
		int[] data = someCdiDAO.getData();
		int out = Integer.MIN_VALUE;
		
		for (int i : data) {
			if (i>out)
				out=i;
		}
		return out;
	}

}
