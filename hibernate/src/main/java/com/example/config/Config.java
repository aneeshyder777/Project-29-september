package com.example.config;

import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;



import com.example.entity.Student;

public class Config {

	public static Session createSession() {
		Configuration cong = new Configuration();
		
		Properties settings = new Properties();
		settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
		settings.put(Environment.URL, "jdbc:mysql://localhost:3306/khusbu");
		settings.put(Environment.USER, "root");
		settings.put(Environment.PASS, "mysqlct");
		settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");

		settings.put(Environment.SHOW_SQL, "true");

		settings.put(Environment.HBM2DDL_AUTO, "create");

		cong.setProperties(settings);
		cong.addAnnotatedClass(Student.class);
		// cong.addAnnotatedClass(Demo.class);
		SessionFactory sf = cong.buildSessionFactory();
		Session session = sf.openSession();
		return session;

	}

}
