package com.vti.entity;

public class Candidate {
	private int ID;
	private String FirstName;
	private String LastName;
	private String Phone;
	private String Email;
	private String Password;
	private Category category;

	public enum Category {
		EXPERIENCECANDIDATE, FRESHERCANDIDATE
	}

	public Candidate(String firstName, String lastName, String phone, String email, String password,
			Category category) {
		super();
		FirstName = firstName;
		LastName = lastName;
		Phone = phone;
		Email = email;
		Password = password;
		this.category = category;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
