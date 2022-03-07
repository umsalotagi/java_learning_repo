package com.example.springdata.idgenerators;

import java.io.Serializable;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class CustonRandomIDGenerators implements IdentifierGenerator {

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		Random ran = new Random();
		int k = ran.nextInt(1000000);
		//System.out.println(Integer.toUnsignedLong(k) + " data >>>>>>" + k);
		return Integer.toUnsignedLong(k);
	}

}
