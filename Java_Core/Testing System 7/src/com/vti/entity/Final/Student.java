package com.vti.entity.Final;

public class Student {
	private final int ID;
	private String Name;
	
	public Student(int ID, String Name) {
		super();
		this.ID = ID;
		this.Name = Name;
		
	
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getID() {
		return ID;
	}

	@Override
	public String toString() {
		return "Student \nID : " + ID + "\nName : " + Name + "";
	}
	
	 void name() {
		
	}public static void study() {
		System.out.println("Đang học bài ....");
	}
	
}
