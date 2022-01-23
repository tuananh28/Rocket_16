package com.vti.dto;

import com.vti.entity.User;

import lombok.Data;

@Data
public class UserDTO {

	// check not null, check length, check exists, check format (regex)...
	private String userName;

	// check not null, check length, check exists on database, check format
	// (regex)...
	private String email;

	// check not null, check length, check format (regex)...
	private String password;

	// check not null, check length, check format (regex)...
	private String firstName;

	// check not null, check length, check format (regex)...
	private String lastName;

	public User toEntity() {
		return new User(userName, email, password, firstName, lastName);
	}
}