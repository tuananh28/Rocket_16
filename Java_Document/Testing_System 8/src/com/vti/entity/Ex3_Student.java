package com.vti.entity;

public class Ex3_Student<T> {
	private T id;
	private String name;

	public Ex3_Student(T id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public T getId() {
		return id;
	}

	public void setId(T id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Ex3_Student [id=" + id + ", name=" + name + "]";
	}

}
