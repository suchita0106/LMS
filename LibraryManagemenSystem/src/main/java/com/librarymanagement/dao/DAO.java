package com.librarymanagement.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.librarymanagement.config.HibernateConfig;

public class DAO {
	
	private static final SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
	
	protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public void beginTransaction() {
        getSession().beginTransaction();
    }

    public void commitTransaction() {
        getSession().getTransaction().commit();
    }

    public void rollbackTransaction() {
        getSession().getTransaction().rollback();
    }

    public void closeSession() {
        getSession().close();
    }

}
