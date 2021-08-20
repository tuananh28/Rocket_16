package com.vti.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.vti.entity.Group;
import com.vti.utils.HibernateUtils;

public class GroupRepository {
	private HibernateUtils hibernateUtils;
	
	public GroupRepository() {
		// TODO Auto-generated constructor stub
		hibernateUtils =  HibernateUtils.getInstance();
	}
	@SuppressWarnings("unchecked")
	public List<Group> getAllGroups(){
		Session session = null;
		try {
			session = hibernateUtils.openSession();
			
			Query<Group> query = session.createQuery("FROM Group");
			
			return query.list();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	public void createGroup(Group Group) {
		Session session = null;
		try {
			session = hibernateUtils.openSession();
			session.beginTransaction();
			
			session.save(Group);
			session.getTransaction().commit();
		} finally {
			if (session !=  null) {
				session.close();
			}
		}
	}
	
	
	
}
