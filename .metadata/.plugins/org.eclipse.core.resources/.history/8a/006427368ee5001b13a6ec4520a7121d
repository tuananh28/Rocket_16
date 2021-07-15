package com.vti.entity;
import java.time.LocalDate;

public class Account {
    int AccountID;
    String Email;
    String Username;
    String FullName;
    Department Department;
    LocalDate CreateDate;
    Group[] groups;
    
    public Account() {
		// TODO Auto-generated constructor stub
	};
	
	public Account(int id, String email, String username, String firstName, String lastName, LocalDate CreateDate) {
		this.AccountID = id;
		this.Email = email;
		this.Username = username;
		this.FullName = firstName + " " + lastName;
		this.CreateDate = CreateDate;
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
		System.out.println("AccountID : "+AccountID);
		System.out.println("Email : "+Email);
		System.out.println("Username : "+Username);
		System.out.println("FullName : "+FullName);
		return toString();
	}
	
}
