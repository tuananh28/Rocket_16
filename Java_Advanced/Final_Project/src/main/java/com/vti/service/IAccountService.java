package com.vti.service;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.vti.entity.Account;
import com.vti.form.AccountFilter;
import com.vti.form.AccountFormForCreating;
import com.vti.form.AccountFormForCreatingRegister;
import com.vti.form.AccountFormForUpdating;

public interface IAccountService extends UserDetailsService{
	
	public Page<Account> getAllAccounts(Pageable pageable, String search, AccountFilter filter);

	public Account getAccountByID(short id);

	public void createAccount(AccountFormForCreating form);

	public void updateAccount(short id, AccountFormForUpdating form);
	
	public void createAccountRegister(AccountFormForCreatingRegister form);

	public void deleteAccount(short id);

	public void deleteAccounts(List<Short> ids);
	
	public Account getAccountByUsername(String username);
	
	public Account findUserByEmail(String email);

	public void activeUser(String token);

	public void sendConfirmUserRegistrationViaEmail(String email);

	public boolean existsUserByEmail(String email);

	public boolean existsUserByUsername(String username);

}
