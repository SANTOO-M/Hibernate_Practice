package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.model.Customer;


public class InsertRecord {

	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		Customer customerObj=new Customer();
		customerObj.setCustomerId(1001);
		customerObj.setCustomerName("Santoo 2.0");
		customerObj.setAddress("akn");
		customerObj.setCity("Paris");
		customerObj.setState("Pakistan");
		customerObj.setCountry("United States");
		customerObj.setPincode(004123);
		session.save(customerObj);
		tx.commit();
		System.out.println("Record Successfully inserted...");
		session.close();
	}
}
