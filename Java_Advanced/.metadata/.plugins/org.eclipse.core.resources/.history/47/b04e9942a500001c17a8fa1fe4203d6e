package com.vti.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the groupaccount database table.
 * 
 */
@Entity
@Table(name="groupaccount")
@NamedQuery(name="Groupaccount.findAll", query="SELECT g FROM Groupaccount g")
public class Groupaccount implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private GroupaccountPK id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date joinDate;

	//bi-directional many-to-one association to Account
	@ManyToOne
	@JoinColumn(name="AccountID", nullable=false, insertable=false, updatable=false)
	private Account account;

	//bi-directional many-to-one association to Group
	@ManyToOne
	@JoinColumn(name="GroupID", nullable=false, insertable=false, updatable=false)
	private Group group;

	public Groupaccount() {
	}

	public GroupaccountPK getId() {
		return this.id;
	}

	public void setId(GroupaccountPK id) {
		this.id = id;
	}

	public Date getJoinDate() {
		return this.joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Group getGroup() {
		return this.group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

}