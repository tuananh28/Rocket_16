package com.vti.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.vti.entity.Manager;
import com.vti.utils.HibernateUtils;

public class ManagerRepository {
	private HibernateUtils hibernateUtils;
	
	public ManagerRepository() {
		// TODO Auto-generated constructor stub
		hibernateUtils =  HibernateUtils.getInstance();
	}
	@SuppressWarnings("unchecked")
	public List<Manager> getAllManagers(){
		Session session = null;
		try {
			session = hibernateUtils.openSession();
			
			Query<Manager> query = session.createQuery("FROM Manager");
			
			return query.list();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	public void createManager(Manager Manager) {
		Session session = null;
		try {
			session = hibernateUtils.openSession();
			session.beginTransaction();
			
			session.save(Manager);
			session.getTransaction().commit();
		} finally {
			if (session !=  null) {
				session.close();
			}
		}
	}
	
	
	
}
