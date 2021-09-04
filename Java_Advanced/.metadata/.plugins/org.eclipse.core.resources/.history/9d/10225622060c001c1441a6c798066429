package com.vti.datalayer;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.vti.entity.Account;
import com.vti.utils.HibernateUtils;

public class AccountRepository {
	private HibernateUtils hibernateUtils;

	public AccountRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}

	@SuppressWarnings("unchecked")
	public List<Account> getAllAccount() {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query<Account> query = session.createQuery("FROM Account");

			return query.list();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void createAccount(Account Account) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create
			session.save(Account);

			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public boolean isAccountExistsByEmail(String email) {
		// get account
		Account account = getAccountByEmail(email);

		// return result
		if (account == null) {
			return false;
		}

		return true;
	}

	public Account getAccountByEmail(String email) {
		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query<Account> query = session.createQuery("FROM Account WHERE email = :emailParameter");

			// set parameter
			query.setParameter("emailParameter", email);

			// get result
			Account account = query.uniqueResult();

			return account;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

}
