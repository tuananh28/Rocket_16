package com.vti.entity.Inheritance.Question4;

public abstract class Person {
	String Name;
	
	public Person(String Name) {
		this.Name = Name;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}
	
}
