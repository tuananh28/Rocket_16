package com.vti.test;

import java.util.List;
import java.util.Scanner;

import com.vti.entity.Department;
import com.vti.repository.DepartmentRepository;

public class Program {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int choose = menu();
		switch (choose) {
		case 1:
			showAllDepartmet();
			break;
		case 2:
			System.out.println("Nhập vào ID của phòng ban");
			short id = scanner.nextShort();
			showDepartmentByID(id);
			break;
		case 3:
			System.out.println("Nhập vào tên phòng ban cần tìm kiếm");
			String nameDep = scanner.nextLine();
			showDepartmentByName(nameDep);
			break;
			
		case 4:
			System.out.println("Tạo mới phòng ban");
			System.out.println("Nhập tên phòng cần tạo:");
			String nameDepCreate = scanner.nextLine();
			Department dep = new Department();
			dep.setName(nameDepCreate);
			createDep(dep);
			showAllDepartmet();
			break;
		default:
			break;
		}

	}

	private static void createDep(Department dep) {
		DepartmentRepository depRepository = new DepartmentRepository();
		depRepository.createDepartment(dep);		
	}

	private static void showDepartmentByName(String nameDep) {
		DepartmentRepository depRepository = new DepartmentRepository();
		Department depByName = depRepository.getDepartmentByName(nameDep);
		if (depByName == null) {
			System.out.println("Không có phòng ban này trên hệ thống");
		} else {
			System.out.println(depByName.toString());
		}

	}

	private static void showDepartmentByID(Short id) {
		DepartmentRepository depRepository = new DepartmentRepository();
		Department dep = depRepository.getDepartmentByID(id);
		System.out.println(dep.toString());
	}

	private static void showAllDepartmet() {
		System.out.println("Danh sách phòng ban trên hệ thống");
		DepartmentRepository depRepository = new DepartmentRepository();
		List<Department> listDep = depRepository.getAllDepartments();
		for (Department department : listDep) {
			System.out.println("ID: " + department.getId() + " Name: " + department.getName());
		}
	}

	@SuppressWarnings("resource")
	private static int menu() {
		while (true) {
			System.out.println("CHương trình quản lý phòng ban..");
			System.out.println("Mời bạn nhập vào chức năng muốn sử dụng");
			System.out.println("1. Lấy danh sách tất cả các phòng ban trên hệ thống");
			System.out.println("2. Tìm phòng ban theo ID");
			System.out.println("3. Tìm phòng ban theo Name");
			System.out.println("4. Tạo mới 1 phòng");
			Scanner sc = new Scanner(System.in);
			if (sc.hasNextInt()) {
				int i = sc.nextInt();
				if ((i == 1) || (i == 2) || (i == 3)|| (i == 4)) {
					return i;
				} else {
					System.out.println("Nhập lại");
				}
			} else {
				System.out.println("Nhập lại");
			}
		}

	}

}
