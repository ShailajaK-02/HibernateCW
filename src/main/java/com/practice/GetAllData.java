package com.practice;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.practice.Entity.Student;
import com.practice.Utility.HibernateUtility;

//getalldata class

public class GetAllData {
	 public static void main(String[] args) {
		
		 SessionFactory factory = HibernateUtility.getSessionFactory();
		 
		 Session session =factory.openSession();
		 
		 Transaction transaction = session.beginTransaction();
		 
		 List<Student> stulist = session.createQuery("select s from Student s",Student.class).getResultList();
		 
		 stulist.stream().forEach(a -> System.out.println(a.toString()));
		 
		 transaction.commit();
		 
		 session.close();
		 
		 
		 
	}
}
