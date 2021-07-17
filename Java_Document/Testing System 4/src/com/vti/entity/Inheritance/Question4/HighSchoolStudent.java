package com.vti.entity.Inheritance;

public class HighSchoolStudent extends Student{
	String Clazz;
	String desiredUniversity;
	public HighSchoolStudent(int ID, String Name, String Clazz, String desiredUniversity) {
		super(ID, Name);
		this.Clazz = Clazz;
		this.desiredUniversity = desiredUniversity;
		// TODO Auto-generated constructor stub
	}
	public String getClazz() {
		return Clazz;
	}
	public void setClazz(String clazz) {
		Clazz = clazz;
	}
	public String getDesiredUniversity() {
		return desiredUniversity;
	}
	public void setDesiredUniversity(String desiredUniversity) {
		this.desiredUniversity = desiredUniversity;
	}
	@Override
	public String toString() {
		return "\nID : "+super.ID+
				"\nName : "+super.Name+
				"\nClazz : " + Clazz + 
				"\ndesiredUniversity : " + desiredUniversity + "";
	}
	
}
