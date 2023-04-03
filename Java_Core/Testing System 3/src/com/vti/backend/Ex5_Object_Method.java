package com.vti.backend;

import com.vti.entity.Department;

public class Ex5_Object_Method {

	public static void main(String[] args) {

		Department[] departments = new Department[5];
		// department1
		Department department1 = new Department();
		department1.DepartmentID = 1;
		department1.DepartmentName = "Sale";
		// department2
		Department department2 = new Department();
		department2.DepartmentID = 2;
		department2.DepartmentName = "Marketing";
		// department3
		Department department3 = new Department();
		department3.DepartmentID = 3;
		department3.DepartmentName = "Boss of director";
		// department4
		Department department4 = new Department();
		department4.DepartmentID = 4;
		department4.DepartmentName = "Waiting room";
		// department5
		Department department5 = new Department();
		department5.DepartmentID = 5;
		department5.DepartmentName = "Accounting";

		departments[0] = department1;
		departments[1] = department2;
		departments[2] = department3;
		departments[3] = department4;
		departments[4] = department5;

		Question1(department1);
		Question2(departments);
		Question3(department1);
		Question4(department1);
		Question5(department1, department2);
		Question6(departments);
		Question7(departments);
	}

	private static void Question1(Department department) {
		// In ra thông tin củaphòng ban thứ 1 (sử dụng toString())
		System.out.println("--- Question 1 ---");
		System.out.println("DepartmentID : " + department.DepartmentID);
		System.out.println("DepartmentName : " + department.DepartmentName);
	}

	private static void Question2(Department[] departments) {
		// In ra thông tin của tất cả phòng ban (sử dụng toString())
		System.out.println("--- Question 2 ---");
		for (Department department : departments) {
			System.out.println("DepartmentID : " + department.DepartmentID);
			System.out.println("DepartmentName : " + department.DepartmentName);
		}
	}

	private static void Question3(Department department) {
		// In ra địa chỉ của phòng ban thứ 1
		System.out.println("--- Question 3 ---");
		System.out.println(department.hashCode());
	}

	private static void Question4(Department department) {
		// Kiểm tra xem phòng ban thứ 1 có tên là "Phòng A" không?
		System.out.println("--- Question 4 ---");
		if (department.DepartmentName.equals("Phòng A")) {
			System.out.println("Phòng ban 1 có Phòng A");
		} else {
			System.out.println("Không có");
		}
	}

	private static void Question5(Department department1, Department department2) {
		/*
		 * So sánh 2 phòng ban thứ 1 và phòng ban thứ 2 xem có bằng nhau không (bằng
		 * nhau khi tên của 2 phòng ban đó bằng nhau)
		 */
		System.out.println("--- Question 5 ---");
		if (department1.DepartmentName == department2.DepartmentName) {
			System.out.println("Bằng nhau");
		} else {
			System.out.println("Không bằng nhau");
		}

	}

	private static void Question6(Department[] departments) {
		//Khởi tạo 1 array phòng ban gồm 5 phòng ban, sau đó in ra danh 
		//sách phòng ban theo thứ tự tăng dần theo tên (sắp xếp theo vần ABCD)
		//VD: 
		//Accounting
		//Boss of director
		//Marketing
		//Sale
		//Waiting room
		System.out.println("--- Question 6 ---");
		for (int i = 0; i < departments.length; i++) {
			for (int j = 0; j < departments.length - 1; j++) {
				if (departments[i].DepartmentName.compareToIgnoreCase(departments[j].DepartmentName) < 0) {
					Department temp = departments[i];
					departments[i] = departments[j];
					departments[j] = temp;
				}
			}
		}
		for (Department department : departments) {
			System.out.println(department.DepartmentName);
		}
	}

	private static void Question7(Department[] departments) {
		System.out.println("--- Question 7 ---");
		//Khởi tạo 1 array học sinh gồm 5 Phòng ban, sau đó in ra danh 
		//sách phòng ban được sắp xếp theo tên
		//VD: 
		//Accounting
		//Boss of director
		//Marketing
		//waiting room
		//Sale
		for (int i = 0; i < departments.length; i++) {
			String reverseNameDepartment = reverseWords(departments[i].DepartmentName);
			for (int j = 0; j < departments.length - 1; j++) {
			String reverseNameComparingDepartment = 
			reverseWords(departments[j].DepartmentName);
			if
			(reverseNameDepartment.compareToIgnoreCase(reverseNameComparingDepartment) < 0) {
			// swap
			Department temp = departments[i];
			departments[i] = departments[j];
			departments[j] = temp;
			}
			}
			}
			// print departments
			for (Department department : departments) {
			System.out.println(department.DepartmentName);
			}
			}
			private static String reverseWords(String str) {
			str = str.trim();
			str = str.replaceAll("\\s+", " ");
			String[] words = str.split(" ");
			str = "";
			for (int i = words.length - 1; i >= 0; i--) {
			str += words[i] + " ";
			}
			return str.substring(0, str.length() - 2);
			}
	}
