package com.vti.dto;

import com.vti.entity.Account;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class UserDTO {

	// check not null, check length, check exists, check format (regex)...
	private String username;

	// check not null, check length, check exists on database, check format
	// (regex)...
	private String email;

	// check not null, check length, check format (regex)...
	private String password;

	// check not null, check length, check format (regex)...
	private String fullname;

	public Account toEntity() {
		return new Account(username, email, password, fullname);
	}
}