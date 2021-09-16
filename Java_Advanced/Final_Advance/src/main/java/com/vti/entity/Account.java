package com.vti.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Account")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Account implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name = "AccountID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short id;

	@Column(name = "Email", length = 50, nullable = false, unique = true, updatable = false)
	private String email;

	@Column(name = "Username", length = 50, nullable = false, unique = true, updatable = false)
	private String username;

	@Column(name = "FullName", length = 50, nullable = false)
	private String fullname;

	@Column(name = "Password", length = 100, nullable = true)
	private String password;

	@Column(name = "Role", nullable = false)
	@Enumerated(EnumType.STRING)
	private roleName role = roleName.User;

	public enum roleName {
		Admin, User, Manager
	}

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "Status", nullable = false)
	private AccountStatus status = AccountStatus.NOT_ACTIVE;

	@ManyToOne
	@JoinColumn(name = "DepartmentID", nullable = true)
	private Department department;

	@ManyToOne
	@JoinColumn(name = "PositionID", nullable = true)
	private Position position;

	@Column(name = "CreateDate")
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date createDate;

	public Account(String username, String email, String password, String fullname) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.fullname = fullname;
	}
	
}
