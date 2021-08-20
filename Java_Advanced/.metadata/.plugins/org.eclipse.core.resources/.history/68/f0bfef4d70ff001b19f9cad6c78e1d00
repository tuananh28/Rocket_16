package com.vti.entity.generator;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import com.vti.entity.Exam;
import com.vti.repository.ExamRepository;

public class ExamCodeGenerator implements IdentifierGenerator {

	private ExamRepository repository;

	public ExamCodeGenerator() {
		repository = new ExamRepository();
	}

	/*
	 * @see org.hibernate.id.IdentifierGenerator#generate(org.hibernate.engine.spi.
	 * SharedSessionContractImplementor, java.lang.Object)
	 */
	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		Exam exam = (Exam) object;

		String prefix;

		if (exam.getDuration() >= 180) {
			prefix = "L";
		} else if (exam.getDuration() >= 90) {
			prefix = "M";
		} else {
			prefix = "S";
		}

		int count = repository.getCountOfExamCode(exam.getDuration());

		return prefix + "-" + (count + 1);
	}

}
