package com.vti.entity;

public class AccountProject {
	private Project project;
	private Account account;
	
	public AccountProject(Project project, Account account) {
		super();
		this.project = project;
		this.account = account;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
}
