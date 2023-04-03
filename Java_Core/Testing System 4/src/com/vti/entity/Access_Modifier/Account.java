package com.vti.entity.Access_Modifier;

import java.time.LocalDate;

public class Account {
	int AccountID;
	String Email;
	String Username;
	String FullName;
	Department Department;
	LocalDate CreateDate;
	PositionName position;
	Group[] groups;

	public Account() {
		// TODO Auto-generated constructor stub
	}

	public Account(int AccountID, String Email, String Username, String firstName, String lastName) {
		this.AccountID = AccountID;
		this.Email = Email;
		this.Username = Username;
		this.FullName = firstName + " " + lastName;
	}

	public Account(int AccountID, String Email, String Username, String firstName, String lastName, Position position) {
		this.AccountID = AccountID;
		this.Email = Email;
		this.Username = Username;
		this.FullName = firstName + " " + lastName;
		this.position = position.PositionName;
		this.CreateDate = LocalDate.now();
	}

	public Account(int AccountID, String Email, String Username, String firstName, String lastName, Position position,
			LocalDate createDate) {
		this.AccountID = AccountID;
		this.Email = Email;
		this.Username = Username;
		this.FullName = firstName + " " + lastName;
		this.position = position.PositionName;
		this.CreateDate = createDate;
	}
	
	public Account(String username) { // B�i 3
		this.Username = username;
	}
	public int getAccountID() {
		return AccountID;
	}

	public void setAccountID(int accountID) {
		AccountID = accountID;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getFullName() {
		return FullName;
	}

	public void setFullName(String fullName) {
		FullName = fullName;
	}

	public Department getDepartment() {
		return Department;
	}

	public void setDepartment(Department department) {
		Department = department;
	}

	public LocalDate getCreateDate() {
		return CreateDate;
	}

	public void setCreateDate(LocalDate createDate) {
		CreateDate = createDate;
	}

	public Group[] getGroups() {
		return groups;
	}

	public void setGroups(Group[] groups) {
		this.groups = groups;
	}
	public String toString() {
		return "\nAccountID : " + AccountID +
				" \nEmail : " + Email + 
				"\n UserName : " + Username + 
				"\n FullName : " + FullName +
				"\n Position : " + position + 
				"\n CreateDate : " + CreateDate + "";
	}

}
