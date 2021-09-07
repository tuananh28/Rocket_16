package com.vti.specification;

import java.util.Date;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.vti.entity.Account;

public class AccountSpecification implements Specification<Account> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String key;
	private String operator;
	private Object value;

	public AccountSpecification(String key, String operator, Object value) {
		this.key = key;
		this.operator = operator;
		this.value = value;
	}

	@Override
	public Predicate toPredicate(Root<Account> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
		if (operator.equalsIgnoreCase("LIKE")) {
			if (key.equalsIgnoreCase("username")) {
				return criteriaBuilder.like(root.get("username"), "%" + value.toString() + "%");
			} else {
				return criteriaBuilder.like(root.get(key), "%" + value.toString() + "%");
			}
		}
		if (operator.equalsIgnoreCase(">=")) {
			return criteriaBuilder.greaterThanOrEqualTo(root.get(key), (Date) value);
		}
		if (operator.equalsIgnoreCase("<=")) {
			if (value instanceof Date) {
				Date today = (Date) value;
				Date tommorrow = new Date(today.getTime()+ (1000 *60*60*24));
				return criteriaBuilder.lessThanOrEqualTo(root.get(key), tommorrow);
			}
		}
		return null;
	}
}
