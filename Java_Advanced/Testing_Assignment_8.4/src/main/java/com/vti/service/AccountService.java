package com.vti.service;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.entity.Account;
import com.vti.repository.IAccountRepository;
import com.vti.specification.SpecificationBuilder;

@Service
public class AccountService implements IAccountService {

	@Autowired
	private IAccountRepository repository;

	public List<Account> getAllAccounts(String search) throws ParseException {

		SpecificationBuilder<Account> specificationBuilder = new SpecificationBuilder<Account>(search);
		return repository.findAll(specificationBuilder.build());
	}

}