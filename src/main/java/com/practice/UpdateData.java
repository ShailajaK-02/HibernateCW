package com.practice;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.practice.Entity.Student;
import com.practice.Utility.HibernateUtility;

//update data
public class UpdateData {
	
	public static void main(String[] args) {
		
		SessionFactory factory = HibernateUtility.getSessionFactory();
		
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		//update data -> 1st fetch the data 
		//write before commit and after transaction
		Student s = session.find(Student.class, 2);
		s.setFname("Kajal");		
		s.setLname("Jagtap");
		s.setCity("Pune");
		s.setMobilenum(9993333);
		s.setState("Maharashtra");
		
		transaction.commit();
		session.close();
	}
}
