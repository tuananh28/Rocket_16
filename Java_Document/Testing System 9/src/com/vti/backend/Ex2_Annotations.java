package com.vti.backend;

import java.util.Date;

import com.vti.entity.Student;

public class Ex2_Annotations {
	public static void Question1() {
		@SuppressWarnings("deprecation")
		@Deprecated
		Date date = new Date(2020, 05, 18);
		System.out.println(date);
	}

	@SuppressWarnings("deprecation")
	public static void Question2() {
		// Bước 2
		Student student = new Student("Nguyễn Văn A");
		System.out.println(student.getId());
		System.out.println(student.getName());
		// Bước 5
		System.out.println(student.getMSV());
	}
}
