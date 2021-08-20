package com.vti.dto;

import com.vti.entity.Department;

public class DepartmentDTO {
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public DepartmentDTO() {
		// TODO Auto-generated constructor stub
	}
	public Department toEntity() {
		return new Department(name);
	}
}

