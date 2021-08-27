package com.vti.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.vti.entity.Category;
import com.vti.utils.HibernateUtils;

public class CategoryReponsitory {
	private HibernateUtils hibernateUtils;

	public CategoryReponsitory() {
		hibernateUtils = HibernateUtils.getInstance();
	}

	// TODO Auto-generated constructor stub
	@SuppressWarnings("unchecked")
	public List<Category> getAllCategories() {
		Session session = null;
		try {
			session = hibernateUtils.openSession();

			Query<Category> query = session.createQuery("FROM Category");

			return query.list();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
}
