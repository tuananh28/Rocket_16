package com.vti.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.vti.entity.Account;

public interface IAccountService extends UserDetailsService {
	Account getAccountByUsername(String username);
}
