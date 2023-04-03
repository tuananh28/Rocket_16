package com.vti.dto;

public class UserDTO {
	private int id;

	private String userName;

	private String email;

	private String firstName;

	private String lastName;

	private String fullName;

	private String role;

	public UserDTO(int id, String userName, String email, String firstName, String lastName, String fullName,
			String role) {
		this.id = id;
		this.userName = userName;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.fullName = fullName;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public String getUserName() {
		return userName;
	}

	public String getEmail() {
		return email;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getFullName() {
		return fullName;
	}

	public String getRole() {
		return role;
	}

}
