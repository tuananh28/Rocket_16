package com.vti.entity.primarykey;

import java.io.Serializable;

import javax.persistence.Column;

public class GroupAccountKey implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name = "GroupID")
	private short groupID;
	
	@Column(name = "AccountID")
	private short accountID;

	public GroupAccountKey() {
		// TODO Auto-generated constructor stub
	}
	public short getGroupID() {
		return groupID;
	}

	public void setGroupID(short groupID) {
		this.groupID = groupID;
	}

	public short getAccountID() {
		return accountID;
	}

	public void setAccountID(short accountID) {
		this.accountID = accountID;
	}
	
	
}
