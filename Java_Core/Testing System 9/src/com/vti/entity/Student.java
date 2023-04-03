package com.vti.entity;

public class Student {
	private int id;
	private String Name;
	private static int dem = 0;

	/**
	 * 
	 * @return the id // Bước 4
	 */
	@Deprecated
	public int getId() {// Bước 1
		return id;
	}

	public String getMSV() {// Bước 3
		return "MSV : " + id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public Student(String name) {
		super();
		this.id = ++dem;
		Name = name;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", Name=" + Name + "]";
	}

}
