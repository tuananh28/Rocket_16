package com.vti.dto;

public class PositionDto {
	private short id;

	private String name;

	public PositionDto(short id, String name) {
		this.id = id;
		this.name = name;
	}

	public short getId() {
		return id;
	}

	public String getName() {
		return name;
	}

}
