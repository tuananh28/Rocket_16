package com.vti.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.vti.entity.Address;
import com.vti.utils.HibernateUtils;

public class AddressRepository {

	private HibernateUtils hibernateUtils;

	public AddressRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}

	@SuppressWarnings("unchecked")
	public List<Address> getAllAddresses() {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query<Address> query = session.createQuery("FROM Address");

			return query.list();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	public Address getAddressByID(short id) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// get Address by id
			Address Address = session.get(Address.class, id);

			return Address;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void createAddress(Address Address) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create
			session.save(Address);

			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
}