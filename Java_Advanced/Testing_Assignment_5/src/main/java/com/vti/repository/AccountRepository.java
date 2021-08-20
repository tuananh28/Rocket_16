package com.vti.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.vti.entity.Account;
import com.vti.utils.HibernateUtils;

public class AccountRepository {
	private HibernateUtils hibernateUtils;
	
	public AccountRepository() {
		// TODO Auto-generated constructor stub
		hibernateUtils =  HibernateUtils.getInstance();
	}
	@SuppressWarnings("unchecked")
	public List<Account> getAllAccounts(){
		Session session = null;
		try {
			session = hibernateUtils.openSession();
			
			Query<Account> query = session.createQuery("FROM Account");
			
			return query.list();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	public void createAccount(Account account) {
		Session session = null;
		try {
			session = hibernateUtils.openSession();
			session.beginTransaction();
			
			session.save(account);
			session.getTransaction().commit();
		} finally {
			if (session !=  null) {
				session.close();
			}
		}
	}
	
	
	
}
