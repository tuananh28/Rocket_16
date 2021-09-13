package com.vti.service;

import com.vti.entity.Account;

public interface IUserService {

	void createUser(Account user);

	Account findUserByEmail(String email);

	void activeUser(String token);

	void sendConfirmUserRegistrationViaEmail(String email);

	boolean existsUserByEmail(String email);

	boolean existsUserByUserName(String username);

}
