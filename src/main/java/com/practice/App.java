package com.practice;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.practice.Entity.Student;

//
import org.hibernate.SessionFactory;
//import org.hibernate.cfg.Configuration;

import com.practice.Utility.HibernateUtility;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Student s = new Student();
    	Student s1 = new Student();
    	Student s2 = new Student();
    	
    	s.setId(8);
    	s.setFname("riya");
    	s.setLname("raut");
    	s.setCity("pune");
    	s.setMobilenum(7754782);
    	s.setState("Maharashtra");
    	
    	s1.setId(6);
    	s1.setFname("shravani");
    	s1.setLname("M");
    	s1.setCity("pune");
    	s1.setMobilenum(997622);
    	s1.setState("Maharashtra");
    	
    	s2.setId(7);
    	s2.setFname("srushti");
    	s2.setLname("k");
    	s2.setCity("pune");
    	s2.setMobilenum(997866);
    	s2.setState("Maharashtra");
    	
    	List<Student> Studentlist = Arrays.asList(s,s1,s2);
    	
    	//s1.session factory
        SessionFactory factory = HibernateUtility.getSessionFactory();
        
        //2.session from session factory
        Session session = factory.openSession();
        
        //3.Transaction from session
       // Transaction transaction = session.beginTransaction();
        
        //part 1 -> to save single obj
        
        //4.save process
        //session.persist(s);
        //5.pass to database
        //transaction.commit();
        
        //part 2-> to save list of student
        for(Student stu :Studentlist) {
            Transaction transaction = session.beginTransaction();
            session.persist(stu);
            transaction.commit();
        }
        //6.session ended
        session.close();
    }
    
}
