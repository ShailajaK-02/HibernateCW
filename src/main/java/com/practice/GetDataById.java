package com.practice;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.practice.Entity.Student;
import com.practice.Utility.HibernateUtility;

//get data by id class 
public class GetDataById {
	
	public static void main(String[] args) {
		
		SessionFactory factory = HibernateUtility.getSessionFactory();
		
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		//deprecated method
		//student st = session.get(student.class,2);
		
		//new method
		//Session level cache
		Student st = session.find(Student.class, 2);
		System.out.println(st.toString());
		Student st1 = session.find(Student.class, 2);
		System.out.println(st1.toString());
		Student st2 = session.find(Student.class, 2);
		System.out.println(st2.toString());

		transaction.commit();
		session.close();
		
		//new session creation 
//		Session session2 = factory.openSession();
//		Transaction transaction2 = session2.beginTransaction();
//		
//		Student st3 = session.find(Student.class, 2);
//		System.out.println(st3.toString());
//		
//		transaction2.commit();
//		session2.close();
		
	}
}
