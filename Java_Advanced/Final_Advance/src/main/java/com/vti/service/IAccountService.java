package com.vti.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.vti.entity.Account;
import com.vti.form.AccountFilter;
import com.vti.form.AccountFormForCreating;
import com.vti.form.AccountFormForUpdating;

public interface IAccountService {
	public Page<Account> getAllAccounts(Pageable pageable, String search, AccountFilter filter);

	public Account getAccountByID(short id);

	public void createAccount(AccountFormForCreating form);

	public void updateAccount(short id, AccountFormForUpdating form);

	public void deleteAccount(short id);

	public void deleteAccounts(List<Short> ids);
}
