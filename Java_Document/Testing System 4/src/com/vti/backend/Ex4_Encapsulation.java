package com.vti.backend;

import com.vti.entity.Encapsulation.Student;

public class Ex4_Encapsulation {

	public void Question1() {
		
		Student student1 = new Student(1,"Bùi Tuấn Anh","Bắc Ninh");
		student1.setMark((float) 8.0);
		System.out.println(student1.toString());
		
		Student student2 = new Student(2,"Bùi Thị Hoa Mai","Hải Dương");
		student2.setMark((float) 9.0);
		System.out.println("\n"+student2.toString());
		
		Student student3 = new Student(3,"Phạm Ngọc Diễn","Thái Bình");
		student3.setMark((float) 3.6);
		System.out.println("\n"+student3.toString());
	}
}
