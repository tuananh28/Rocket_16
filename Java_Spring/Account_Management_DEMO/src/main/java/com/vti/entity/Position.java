package com.vti.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Position", catalog = "TestingSystem")
public class Position implements Serializable {
	private static final long serialVersionUID = 1L;
	@Column(name = "PositionID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short id;

	@Column(name = "PositionName", nullable = false, unique = true)
	@Enumerated(EnumType.STRING)
	private PositionName name;

	public enum PositionName {
		Dev, Test, Scrum_Master, PM
	}

	@OneToMany(mappedBy = "position")
	List<Account> accounts;

	public Position() {
		super();
	}

	/**
	 * @return the id
	 */
	public short getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(short id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public PositionName getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(PositionName name) {
		this.name = name;
	}

	/**
	 * @return the accounts
	 */
	public List<Account> getAccounts() {
		return accounts;
	}

	/**
	 * @param accounts the accounts to set
	 */
	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

}
