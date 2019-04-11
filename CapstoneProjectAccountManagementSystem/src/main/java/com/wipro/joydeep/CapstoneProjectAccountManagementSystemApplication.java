package com.wipro.joydeep;

import java.util.List;

import javax.annotation.PostConstruct;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class CapstoneProjectAccountManagementSystemApplication {
    @Autowired
	private SessionFactory sf;
	public static void main(String[] args) {
		SpringApplication.run(CapstoneProjectAccountManagementSystemApplication.class, args);
	}
	
	/*
	 * @PostConstruct public void init() { Session session=sf.getCurrentSession();
	 * String sql = "SELECT * FROM TRANSFER_ENTITY_TABLE"; SQLQuery query =
	 * session.createSQLQuery(sql); List results = query.list();
	 * System.out.println(results); }
	 */

}
