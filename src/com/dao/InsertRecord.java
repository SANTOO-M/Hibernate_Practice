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
		customerObj.setCustomerId(1005);
		customerObj.setCustomerName("Ben Stokes");
		customerObj.setAddress("North Street");
		customerObj.setCity("London");
		customerObj.setState("England");
		customerObj.setCountry("United Kingdoms");
		customerObj.setPincode(004113);
		session.save(customerObj);
		tx.commit();
		System.out.println("Record Successfully inserted...");
		session.close();
	}
}
