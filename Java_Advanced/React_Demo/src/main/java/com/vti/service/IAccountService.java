package com.vti.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.vti.entity.Account;

public interface IAccountService extends UserDetailsService {

//	public Page<Account> getAllAccounts(Pageable pageable, String search, AccountFilter filter);

//	public Account getAccountByID(short id);

//	public void createAccount(AccountFormForCreating form);
//
//	public void updateAccount(short id, AccountFormForUpdating form);
//
	public void createAccountRegister(Account account);
//
//	public void deleteAccount(short id);
//
//	public void deleteAccounts(List<Short> ids);

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
