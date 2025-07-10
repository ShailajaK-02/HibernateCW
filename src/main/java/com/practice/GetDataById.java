package com.practice;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.practice.Entity.Student;
import com.practice.Utility.HibernateUtility;

public class GetDataById {
	
	public static void main(String[] args) {
		
		SessionFactory factory = HibernateUtility.getSessionFactory();
		
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		//deprecated method
		//student st = session.get(student.class,2);
		
		//new method
		Student st = session.find(Student.class, 2);
		System.out.println(st.toString());
		transaction.commit();
		session.close();
	}
}
