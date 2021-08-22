package com.vti.utils;

public class Sorting {

	private String sortField;
	private String sortType;

	public Sorting() {
	}

	public Sorting(String sortField, String sortType) {
		this.sortField = sortField;
		this.sortType = sortType;
	}

	public String getSortField() {
		return sortField;
	}

	public void setSortField(String sortField) {
		this.sortField = sortField;
	}

	public void setSortType(String sortType) {
		this.sortType = sortType;
	}

	public String getSortType() {
		return sortType;
	}

}
