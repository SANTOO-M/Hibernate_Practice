package com.dao;

import java.util.ArrayList;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.model.Customer;

public class CustomerDAO {
	
	public static void customerUpdate(String city,int customerId) {
		try {
			Configuration cfg=new Configuration();
			cfg.configure("hibernate.cfg.xml");
			SessionFactory factory=cfg.buildSessionFactory();
			Session session=factory.openSession();
			Transaction tx=session.beginTransaction();
			Query query=session.createQuery("Update Customer c set c.city='"+city+"' where customerId="+customerId);
			int success=query.executeUpdate();
			if(success>=1)System.out.println("Successfully Updated");
			else System.out.println("Record Updation Failed!!!");
			tx.commit();
			session.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void selectAll() {
		try{
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		Session session=factory.openSession();
		Query query=session.createQuery("from Customer");
		ArrayList<Customer> allCustomer=(ArrayList<Customer>)query.getResultList();
		
		for(int i=0;i<allCustomer.size();i++) {
			System.out.println(allCustomer.get(i).getCustomerId()+"\t"+allCustomer.get(i).getCustomerName()+
					"\t"+allCustomer.get(i).getAddress()+"\t"+allCustomer.get(i).getCity()+
					"\t"+allCustomer.get(i).getState()+"\t"+allCustomer.get(i).getCountry()+
					"\t"+allCustomer.get(i).getPincode());
		}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void selectCustomerByState(String state) {
		try{
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		Session session=factory.openSession();
		Query query=session.createQuery("from Customer c where c.state='"+state+"'");
		ArrayList<Customer> allCustomer=(ArrayList<Customer>)query.getResultList();
		System.out.println("TamilNadu Customer Details...\n-----------------------------------------");		
		for(int i=0;i<allCustomer.size();i++) {
			System.out.println(allCustomer.get(i).getCustomerId()+"\t"+allCustomer.get(i).getCustomerName()+
					"\t"+allCustomer.get(i).getAddress()+"\t"+allCustomer.get(i).getCity()+
					"\t"+allCustomer.get(i).getState()+"\t"+allCustomer.get(i).getCountry()+
					"\t"+allCustomer.get(i).getPincode());
		}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) 
	{
		customerUpdate("Majestic",1001);
		selectAll();
		selectCustomerByState("TamilNadu");
	}

}
