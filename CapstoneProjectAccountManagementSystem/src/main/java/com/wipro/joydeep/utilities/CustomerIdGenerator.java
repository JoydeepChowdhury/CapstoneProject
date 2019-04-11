package com.wipro.joydeep.utilities;

import java.io.Serializable;
import java.util.UUID;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class CustomerIdGenerator implements IdentifierGenerator
       {

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		// TODO Auto-generated method stub
		return "CUSTOMER"+UUID.randomUUID().toString();
	}

       }
