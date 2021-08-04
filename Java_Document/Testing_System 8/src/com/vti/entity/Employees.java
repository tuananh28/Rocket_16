package com.vti.entity;

public class Employees<T> {
	private int id;
	private String name;
	private T[] salaries;
	private static int dem = 0;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public T[] getSalaries() {
		return salaries;
	}

	public void setSalaries(T[] salaries) {
		this.salaries = salaries;
	}

	public Employees(String name, T[] salaries) {
		super();
		this.id = ++dem;
		this.name = name;
		this.salaries = salaries;
	}

	@Override
	public String toString() {
		return "Employees [id=" + id + ", name=" + name + "]";
	}

}
