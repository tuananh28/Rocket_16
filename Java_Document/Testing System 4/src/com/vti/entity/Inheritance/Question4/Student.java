package com.vti.entity.Inheritance.Question4;

public abstract class Student extends Person{
	int ID;
	public Student(int ID, String Name) {
		super(Name);
		this.ID = ID;
		// TODO Auto-generated constructor stub
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	
	
}
