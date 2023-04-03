package com.vti.dto;

public class DepartmentDTO {

	private String name;
	private int id;

	public DepartmentDTO(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

}
