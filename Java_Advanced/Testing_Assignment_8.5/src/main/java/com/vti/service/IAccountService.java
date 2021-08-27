package com.vti.service;

import java.text.ParseException;
import java.util.List;

import com.vti.entity.Account;

public interface IAccountService {

	public List<Account> getAllAccounts(String search) throws ParseException;
}
