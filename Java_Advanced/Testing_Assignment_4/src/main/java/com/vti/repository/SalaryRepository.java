package com.vti.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.vti.entity.Salary;
import com.vti.utils.HibernateUtils;

public class SalaryRepository {
	private HibernateUtils hibernateUtils;
	
	public SalaryRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}
	public List<Salary> getAllSalaries(){
		Session session = null;
		try {
			session = hibernateUtils.openSession();
			
			@SuppressWarnings("unchecked")
			Query<Salary> query = session.createQuery("FROM Salary");
			
			return query.list();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	public void createSalary(Salary salary) {
		Session session = null;
		try {
			session = hibernateUtils.openSession();
			session.beginTransaction();
			
			session.save(salary);
			
			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
}
