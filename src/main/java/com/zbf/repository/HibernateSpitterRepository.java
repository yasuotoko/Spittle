package com.zbf.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

//@Repository
public class HibernateSpitterRepository {

	private SessionFactory sessionFactory;
	
	public HibernateSpitterRepository(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	private Session currentSession(){
		return sessionFactory.getCurrentSession();
	}
	
	public long count(){
		return 1;
	}
}
