package com.vti.entity.Access_Modifier;

public class Department {
	int DepartmentID;
	String DepartmentName;

	public Department() {

	};

	public Department(int DepartmentID, String DepartmentName) {
		this.DepartmentID = DepartmentID;
		this.DepartmentName = DepartmentName;
	}

	public int getDepartmentID() {
		return DepartmentID;
	}

	public void setDepartmentID(int departmentID) {
		DepartmentID = departmentID;
	}

	public String getDepartmentName() {
		return DepartmentName;
	}

	public void setDepartmentName(String departmentName) {
		DepartmentName = departmentName;
	}

	@Override
	public String toString() {
		return " DepartmentID : " + DepartmentID + 
				"\n DepartmentName : " + DepartmentName + "";
	}
}
