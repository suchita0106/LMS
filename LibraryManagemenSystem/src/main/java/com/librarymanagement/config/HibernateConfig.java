	package com.librarymanagement.config;
	
	import java.util.Properties;
	
	import org.hibernate.HibernateException;
	import org.hibernate.SessionFactory;
	import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
	import org.hibernate.cfg.Configuration;
	import org.hibernate.cfg.Environment;
	import org.hibernate.service.ServiceRegistry;
	import org.springframework.stereotype.Component;
	
	import com.librarymanagement.pojo.Book;
	import com.librarymanagement.pojo.Event;
	import com.librarymanagement.pojo.Request;
	import com.librarymanagement.pojo.Room;
	import com.librarymanagement.pojo.UserAccount;
	import com.librarymanagement.pojo.UserProfile;
	
	@Component
	public class HibernateConfig {
		
		private static SessionFactory sessionFactory;
	    public static SessionFactory getSessionFactory() throws HibernateException {
	        if (sessionFactory == null) {
	            
	                Configuration configuration = new Configuration();
	
	                Properties settings = new Properties();
	                settings.put("hibernate.connection.driver_class", "com.microsoft.sqlserver.jdbc.SQLServerDriver");
	                settings.put("hibernate.connection.url", "jdbc:sqlserver://localhost:1433;database=librarymanagementsystem;encrypt=false;trustServerCertificate=false");
	                settings.put("hibernate.connection.username", "sa");
	                settings.put("hibernate.connection.password", "admin@123DB");
	                settings.put("hibernate.dialect", "org.hibernate.dialect.SQLServer2012Dialect");
	                settings.put("hibernate.show_sql", "true");
	                settings.put("hibernate.current_session_context_class", "thread");
	                settings.put("hibernate.hbm2ddl.auto", "update");

	                configuration.setProperties(settings);
	
	                //Add annotated Pojo's here
	                
	                configuration.addAnnotatedClass(Book.class);
	                configuration.addAnnotatedClass(Event.class);
	                configuration.addAnnotatedClass(Room.class);
	                configuration.addAnnotatedClass(Request.class);
	                configuration.addAnnotatedClass(UserProfile.class);
	                configuration.addAnnotatedClass(UserAccount.class);
	
	                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
	                    .applySettings(configuration.getProperties()).build();
	
	                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	            
	            
	        }
	        return sessionFactory;
	    }
	
	}
