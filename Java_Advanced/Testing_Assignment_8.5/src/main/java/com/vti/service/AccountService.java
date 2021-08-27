package com.vti.service;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.vti.entity.Account;
import com.vti.filter.AccountFilter;
import com.vti.repository.IAccountRepository;
import com.vti.specification.CustomSpecification;
import com.vti.specification.SearchCriteria;
import com.vti.specification.SpecificationBuilder;

@Service
public class AccountService implements IAccountService {

	@Autowired
	private IAccountRepository repository;

	public List<Account> getAllAccounts(String search) throws ParseException {

		return repository.findAll(new SpecificationBuilder<Account>().build(search));
	}

	@SuppressWarnings("deprecation")
	public List<Account> getAllAccounts(String search, AccountFilter filter) throws ParseException {

		Specification<Account> specification = null;

		if (filter.getId() != 0) {
			specification = new CustomSpecification<>(new SearchCriteria("id", ">=", filter.getId()));
		}

		if (!StringUtils.isEmpty(filter.getUsername())) {

			Specification<Account> spec = new CustomSpecification<>(
					new SearchCriteria("username", "~", filter.getUsername()));

			if (specification == null) {
				specification = spec;
			} else {
				specification = Specification.where(specification).or(spec);
			}
		}

		if (!StringUtils.isEmpty(filter.getDepartmentPosition())) {

			Specification<Account> spec = new CustomSpecification<>(
					new SearchCriteria("department.positionName", "=", filter.getDepartmentPosition()));

			if (specification == null) {
				specification = spec;
			} else {
				specification = Specification.where(specification).and(spec);
			}
		}

		return repository.findAll(specification);
	}

}