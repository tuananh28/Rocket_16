package com.vti.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.vti.entity.User;

public interface IUserService extends UserDetailsService {
	public User findByUserName(String username);
	public Page<User> getAllUsers(Pageable pageable);
}
