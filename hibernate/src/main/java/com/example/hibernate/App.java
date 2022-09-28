package com.example.hibernate;


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


import com.example.config.Config;
import com.example.entity.Student;

public class App {
	public static void main(String[] args) {
		try {
			Session session = Config.createSession();
			System.out.println("Got a session " + session);

			Student ss = new Student();
			ss.setId(101);
			ss.setName("ane");
			ss.setEmail("abe@gmail.com");
			
			ss.setId(102);
			ss.setName("anehyd");
			ss.setEmail("abef@gmail.com");
			System.out.println(ss);
			
			
			Transaction tr = session.beginTransaction();
			session.save(ss);
			tr.commit();
		
			System.out.println("------------------student saved----------------");
			 //show operation 
			Query query = session.createQuery("from Student");
		     List<Student> students= query.list();
		     for(Student std:students) {
		    	 System.out.println("id: "+std.getId()+", name: "+std.getName()+", email:"+std.getEmail());
		     }
		     //update operation
		     Student s1=(Student)session.get(Student.class,102);
		     s1.setName("aneees");
		     System.out.println("successfully updated");
		 	session.close();
		
		}
		   
		
		
		  catch (HibernateException e) {
			// TODO: handle exception
			System.out.println(e);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}

	}
}