package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.model.Customer;

public class SelectRecord {

	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		Session session=factory.openSession();
		Customer customerObj=session.get(Customer.class, 1001);
		System.out.println("Show Customer");
		System.out.println("-------------------");
		System.out.println("Customer ID= "+customerObj.getCustomerId());
		System.out.println("Customer Name= "+customerObj.getCustomerName());
		System.out.println("Address= "+customerObj.getAddress());
		System.out.println("City= "+customerObj.getCity());
		System.out.println("State= "+customerObj.getState());
		System.out.println("Country= "+customerObj.getCountry());
		System.out.println("Pincode= "+customerObj.getPincode());
		session.close();
	}
}
