package com.vti.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the groupaccount database table.
 * 
 */
@Embeddable
public class GroupaccountPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false, unique=true, nullable=false)
	private byte groupID;

	@Column(insertable=false, updatable=false, unique=true, nullable=false)
	private byte accountID;

	public GroupaccountPK() {
	}
	public byte getGroupID() {
		return this.groupID;
	}
	public void setGroupID(byte groupID) {
		this.groupID = groupID;
	}
	public byte getAccountID() {
		return this.accountID;
	}
	public void setAccountID(byte accountID) {
		this.accountID = accountID;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof GroupaccountPK)) {
			return false;
		}
		GroupaccountPK castOther = (GroupaccountPK)other;
		return 
			(this.groupID == castOther.groupID)
			&& (this.accountID == castOther.accountID);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) this.groupID);
		hash = hash * prime + ((int) this.accountID);
		
		return hash;
	}
}