package com.vti.entity;

public class Student implements Comparable<Student>{
	private int ID;
	private String Name;
	private static int dem = 0;

	public Student(String name) {
		super();
		ID = ++dem;
		Name = name;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	@Override
	public String toString() {
		return "Student [ID=" + ID + ", Name=" + Name + "]";
	}

	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		return this.Name.compareTo(o.getName());
	}

}
