package com.vti.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.vti.entity.Exam;
import com.vti.utils.HibernateUtils;

public class ExamRepository {

	private HibernateUtils hibernateUtils;

	public ExamRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}

	@SuppressWarnings("unchecked")
	public List<Exam> getAllExams() {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query<Exam> query = session.createQuery("FROM Exam");

			return query.list();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void createExam(Exam exam) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create
			session.save(exam);

			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@SuppressWarnings({ "unchecked" })
	public short getCountOfExamCode(short duration) {
		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			String sql;

			if (duration >= 180) {
				sql = "SELECT COUNT(1) FROM Exam WHERE Duration >= 180";
			} else if (duration >= 90) {
				sql = "SELECT COUNT(1) FROM Exam WHERE Duration >= 90 AND Duration < 180";
			} else {
				sql = "SELECT COUNT(1) FROM Exam WHERE Duration < 90";
			}

			// create hql query
			Query<Long> query = session.createQuery(sql);

			// get result
			return query.uniqueResult().shortValue();

		} finally {
			if (session != null) {
				session.close();
			}
		}

	}
}
