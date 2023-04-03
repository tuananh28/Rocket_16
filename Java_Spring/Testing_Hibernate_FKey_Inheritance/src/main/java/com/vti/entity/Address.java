package com.vti.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Address", catalog = "Testing_System_5")
@Setter
@Getter
@NoArgsConstructor
@ToString
public class Address implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "AddressID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short id;

	@Column(name = "AddressName", length = 100, nullable = false, unique = true)
	private String name;

	@OneToOne(mappedBy = "address")
	private DetailDepartment department;

}
