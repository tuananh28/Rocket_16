package com.vti.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the manager database table.
 * 
 */
@Entity
@Table(name="manager")
@NamedQuery(name="Manager.findAll", query="SELECT m FROM Manager m")
public class Manager implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private byte accountID;

	@Column(nullable=false)
	private byte managementNumberOfYear;

	//bi-directional one-to-one association to Account
	@OneToOne
	@JoinColumn(name="AccountID", nullable=false, insertable=false, updatable=false)
	private Account account;

	public Manager() {
	}

	public byte getAccountID() {
		return this.accountID;
	}

	public void setAccountID(byte accountID) {
		this.accountID = accountID;
	}

	public byte getManagementNumberOfYear() {
		return this.managementNumberOfYear;
	}

	public void setManagementNumberOfYear(byte managementNumberOfYear) {
		this.managementNumberOfYear = managementNumberOfYear;
	}

	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

}