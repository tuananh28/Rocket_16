package com.vti.entity.Polymorphism.Question1;

public class Student implements IStudent{
	private int ID;
	private String Name;
	private int Group;
	@Override
	public void DiemDanh() {
		System.out.println(Name + "Điểm danh");
		
	}

	@Override
	public void HocBai() {
		System.out.println(Name + "Học Bài");
		
	}

	@Override
	public void DonVeSinh() {
		System.out.println(Name + "Dọn vệ sinh");
		
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

	public int getGroup() {
		return Group;
	}

	public void setGroup(int group) {
		Group = group;
	}


	public Student( String name, int group) {
		super();
		ID = ID++;
		Name = name;
		Group = group;
	}
	

}
