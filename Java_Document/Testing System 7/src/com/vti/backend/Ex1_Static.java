package com.vti.backend;

import java.util.Scanner;

import com.vti.entity.Static.HinhChuNhat;
import com.vti.entity.Static.HinhTron;
import com.vti.entity.Static.MyMath;
import com.vti.entity.Static.PrimaryStudent;
import com.vti.entity.Static.SecondaryStudent;
import com.vti.entity.Static.Student;
import com.vti.ultis.ScannerUltis;

public class Ex1_Static {
	Student[] students = new Student[3];
	Scanner scanner = new Scanner(System.in);

	public void Question1() {
		System.out.println("Khởi tạo 3 sinh viên ");
		for (int i = 0; i < students.length; i++) {
			System.out.println("\nSinh viên thứ " + (i + 1));
			Student st = new Student();
			students[i] = st;
		}
		System.out.println("Thông tin các sinh viên vừa nhập : ");
		for (int i = 0; i < students.length; i++) {
			System.out.println(students[i].toString());
		}
		System.out.println("\nChuyển các sinh viên sang Đại học Công Nghệ");
		Student.college = "Đại học Công Nghệ";
		System.out.println("Thông tin sinh viên sau khi chuyển ");
		for (int i = 0; i < students.length; i++) {
			System.out.println(students[i].toString());
		}
	}

	public void Question2() {

		System.out.println("Khởi tạo 3 sinh viên ");
		for (int i = 0; i < students.length; i++) {
			System.out.println("\nSinh viên thứ " + (i + 1));
			Student st = new Student();
			students[i] = st;
		}
		while (true) {
			System.out.println("\t\t --- Chương trình --- \t\t");
			System.out.println("\t 1. Các sinh viên nộp quỹ, mỗi bạn 100K: ");
			System.out.println("\t 2. Student thứ 1 lấy 50k đi mua bim bim, kẹo về liên hoan");
			System.out.println("\t 3. Student thứ 2 lấy 20k đi mua bánh mì");
			System.out.println("\t 4. Student thứ 3 lấy 150k đi mua đồ dùng học tập cho nhóm: ");
			System.out.println("\t 5. Cả nhóm mỗi người lại đóng quỹ mỗi người 50k: ");
			System.out.println("\t ------------------------ \t");
			System.out.print("Lựa chọn : ");
			int lc = scanner.nextInt();
			switch (lc) {
			case 1:
				System.out.println("Tổng quỹ : " + (Student.moneyGroup += 300));
				break;
			case 2:
				System.out.println("Tổng quỹ : " + (Student.moneyGroup -= 50));
				break;
			case 3:
				System.out.println("Tổng quỹ : " + (Student.moneyGroup -= 20));
				break;
			case 4:
				System.out.println("Tổng quỹ: " + (Student.moneyGroup -= 150));
				break;
			case 5:
				System.out.println("Tổng quỹ: " + (Student.moneyGroup += 50));
				break;
			case 6:
				System.out.println("Thoát Chương trình");
				break;
			}
		}
	}

	public void Question3() {
		System.out.print("Nhập số thứ nhất : ");
		int a = ScannerUltis.inputInt();
		System.out.print("Nhập vào số thứ hai : ");
		int b = ScannerUltis.inputInt();
		System.out.println("Max a và b : " + MyMath.max(a, b));
		System.out.println("Min a và b : " + MyMath.min(a, b));
		System.out.println("Sum a và b : " + MyMath.sum(a, b));
	}

	@SuppressWarnings("static-access")
	public void Question4() {
		Student st = new Student();
		System.out.println("Collect ban đầu là : " + st.getCollege());
		st.setCollege("Đại học Kinh tế kỹ thuật Công Nghiệp");
		System.out.println("Collect sau khi thay đổi là : " + st.getCollege());
	}

	public void Question5() {
		for (int i = 0; i < students.length; i++) {
			System.out.println("Sinh viên thứ " + (i + 1));
			Student st = new Student();
			st.toString();
		}
		System.out.println("Số Sinh viên được tạo ra là : " + Student.dem);
	}

	@SuppressWarnings("unused")
	public void Quesiton6() {
		System.out.println("Tạo 2 Primary Student: ");
		PrimaryStudent priSt1 = new PrimaryStudent();
		PrimaryStudent priSt2 = new PrimaryStudent();
		System.out.println("Tạo 6 Secondary Student: ");
		SecondaryStudent secondST1 = new SecondaryStudent();
		SecondaryStudent secondST2 = new SecondaryStudent();
		SecondaryStudent secondST3 = new SecondaryStudent();
		SecondaryStudent secondST4 = new SecondaryStudent();
		SecondaryStudent secondST5 = new SecondaryStudent();
		SecondaryStudent secondST6 = new SecondaryStudent();
		System.out.println("Thông tin số lượng sinh viên");
		String leftAlignFormat = "| %-18s | %-4d |%n";
		System.out.format("+--------------------+------+%n");
		System.out.format("| Category | SL |%n");
		System.out.format("+--------------------+------+%n");
		System.out.format(leftAlignFormat, "Student", Student.dem);
		System.out.format(leftAlignFormat, "PrimaryStudent", PrimaryStudent.demPri);
		System.out.format(leftAlignFormat, "SecondaryStudent", SecondaryStudent.demSecon);
		System.out.format("+--------------------+------+%n");
	}

	public void Question7() {
		try {
			for (int i = 0; i < 6; i++) {
				Student student = new Student();
				student.toString();
			}
			System.out.println("Tạo Primary Student: ");
			PrimaryStudent priSt = new PrimaryStudent();
			System.out.println("Sinh viên Primary Student: " + priSt);
			System.out.println("Tạo Secondary Student: ");
			SecondaryStudent secondSt = new SecondaryStudent();
			System.out.println("Sinh viên Secondary Student: " + secondSt);
		} catch (Exception e) {
			System.out.println("Chỉ được phép tối đa 7 user");
		}
	}

	public void Question8() throws Exception {
		System.out.println("Tạo 4 Hình Chữ Nhật");
		HinhChuNhat[] hcns = new HinhChuNhat[4];
		for (int i = 0; i < hcns.length; i++) {
			System.out.println(" Hình thứ " + (i + 1));
			System.out.print("Cạnh a : ");
			float a = ScannerUltis.inputFloat();
			System.out.print("Cạnh b : ");
			float b = ScannerUltis.inputFloat();
			HinhChuNhat hcn = new HinhChuNhat(a, b);
			hcns[i] = hcn;
			System.out.println("Chu vi HCN là : " + hcn.tinhChuVi(a, b));
			System.out.println("Diện tích HCN là : " + hcn.tinhDientich(a, b));
		}
		
		//Hình tròn 1		
		System.out.println(" Hình tròn thứ 1 ");
		System.out.print("Nhập bán kinh : ");
		float r1 = ScannerUltis.inputFloat();
		HinhTron hinhTron1 = new HinhTron(r1, r1);
		System.out.println("Chu vi Hình Tròn = " + hinhTron1.tinhChuVi(r1, r1));
		System.out.println("Diện tích Hình Tròn = " + hinhTron1.tinhDientich(r1, r1));
		
		//Hình tròn 2
		System.out.println("Hình tròn thứ 2 ");
		System.out.println("Nhập bán kính : ");
		float r2 = ScannerUltis.inputFloat();
		HinhTron hinhTron2 = new HinhTron(r2, r2);
		System.out.println("Chu vi Hình Tròn = " + hinhTron2.tinhChuVi(r2, r2));
		System.out.println("Diện tích Hình Tròn = " + hinhTron2.tinhDientich(r2, r2));
	}
}
