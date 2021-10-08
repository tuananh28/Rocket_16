package com.vti.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.vti.entity.Account;
import com.vti.form.AccountFilter;
import com.vti.form.AccountFormForCreating;
import com.vti.form.AccountFormForCreatingRegister;
import com.vti.form.AccountFormForUpdating;

public interface IAccountService extends UserDetailsService {

	public Page<Account> getAllAccounts(Pageable pageable, String search, AccountFilter filter);

	public Account getAccountByID(short id);

	public void createAccount(AccountFormForCreating form);

	public void updateAccount(short id, AccountFormForUpdating form);

	public void createAccountRegister(AccountFormForCreatingRegister form);

	public void deleteAccount(short id);

	public void deleteAccounts(List<Short> ids);

	public Account getAccountByUsername(String username);

	public Account getAccountByEmail(String email);

	public void activeUser(String token);

	public void sendConfirmUserRegistrationViaEmail(String email);

	public boolean existsUserByEmail(String email);

	public boolean existsUserByUsername(String username);

	public void resetPasswordViaEmail(String email);

	public void resetPassword(String token, String newPassword);
	
	public void changePassword(String username,String newPassword);

	public void sendResetPasswordViaEmail(String email);

}
