package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.model.Customer;

public class UpdateRecord {

	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		Customer customer=session.get(Customer.class,1000);
		customer.setAddress("Mallur po");
		customer.setCountry("India");
		tx.commit();
		System.out.println("Record Successfully Updated...");
		session.close();
	}

}
