package com.vti.entity.Access_Modifier;

import java.time.LocalDate;
import java.util.Arrays;

public class Group {
	int GroupID;
	String GroupName;
	Account Creator;
	Account[] accounts;
	LocalDate CreateDate;

	public Group() {
		// TODO Auto-generated constructor stub
	}

	public Group(int groupID, String groupName, Account creator, Account[] accounts, LocalDate createDate) {
		super();
		GroupID = groupID;
		GroupName = groupName;
		this.Creator = creator;
		this.accounts = accounts;
		CreateDate = createDate;
	}
	
	public Group(int GroupID, String GroupName, Account creator, String[] usernames, LocalDate createDate) {
		this.GroupID = GroupID;
		this.GroupName = GroupName;
		this.Creator = creator;

		// accounts
		Account[] accounts = new Account[usernames.length];
		for (int i = 0; i < usernames.length; i++) {
			accounts[i] = new Account(usernames[i]);
		}
		this.CreateDate = createDate;
	}
	public int getGroupID() {
		return GroupID;
	}

	public void setGroupID(int groupID) {
		GroupID = groupID;
	}

	public String getGroupName() {
		return GroupName;
	}

	public void setGroupName(String groupName) {
		GroupName = groupName;
	}

	public Account getCreator() {
		return Creator;
	}

	public void setCreator(Account creator) {
		Creator = creator;
	}

	public Account[] getAccounts() {
		return accounts;
	}

	public void setAccounts(Account[] accounts) {
		this.accounts = accounts;
	}

	public LocalDate getCreateDate() {
		return CreateDate;
	}

	public void setCreateDate(LocalDate createDate) {
		CreateDate = createDate;
	}

	@Override
	public String toString() {
		return "GroupID : " + GroupID + 
				"\n GroupName : " + GroupName + 
				"\n Creator : " + Creator + 
				"\n Accounts : " + Arrays.toString(accounts) + 
				"\n CreatDate : " + CreateDate + "";
	}

}
