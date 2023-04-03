package com.vti.backend;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import com.vti.entity.Polymorphism.Question1.Student;
import com.vti.entity.Polymorphism.Question2.Student_Q2;
import com.vti.entity.Polymorphism.Question3.HinhChuNhat;
import com.vti.entity.Polymorphism.Question3.HinhVuong;
import com.vti.entity.Polymorphism.Question4.MyMath;
import com.vti.entity.Polymorphism.Question5.DienThoaiCD;
import com.vti.entity.Polymorphism.Question5.DienThoaiTM;

public class Ex2_Polymorphism {
	Random random = new Random();
	Scanner scanner = new Scanner(System.in);

	public void Question1() {
		Student[] students = new Student[11];
		while (true) {
			System.out.println("\t\t MENU \t\t");
			System.out.println("\t 1.Tạo 10 học sinh, chia thành 3 nhóm.");
			System.out.println("\t 2.Kêu gọi cả lớp điểm danh.");
			System.out.println("\t 3.Gọi nhóm 1 đi học bài.");
			System.out.println("\t 4.Gọi nhóm 2 đi dọn vệ sinh.");
			System.out.println("\t 5.Thoát.");
			System.out.println("\t\t\t ========= \t\t\t");
			System.out.print("Mời bạn đưa ra lựa chọn : ");
			int n = scanner.nextInt();
			switch (n) {
			case 1:
				students[1] = new Student("Tuấn Anh ", 1);
				students[2] = new Student("Hoa Mai ", 1);
				students[3] = new Student("Duy ", 1);
				students[4] = new Student("Kiên ", 2);
				students[5] = new Student("Hải ", 2);
				students[6] = new Student("Hiền ", 2);
				students[7] = new Student("Bích ", 3);
				students[8] = new Student("Giang ", 3);
				students[9] = new Student("Linh ", 3);
				students[10] = new Student("Long ", 3);
				System.out.println("Tạo thành công 10 Sinh viên");
				break;
			case 2:
				System.out.println("\t--- Cả lớp điểm danh --- \t");
				for (int i = 1; i <= 10; i++) {
					students[i].DiemDanh();
				}
				break;
			case 3:
				System.out.println("\t--- Nhóm 1 đi học bài  ---\t");
				for (int i = 1; i <= 10; i++) {
					if (students[i].getGroup() == 1) {
						students[i].HocBai();
					}
				}
				break;
			case 4:
				System.out.println("\t--- Nhóm 2 đi dọn vệ sinh ---\t");
				for (int i = 1; i <= 10; i++) {
					if (students[i].getGroup() == 2) {
						students[i].DonVeSinh();
					}
				}
				break;
			case 5:
				System.out.println("Thoát chương trình !");
				return;
			default:
				System.out.println("Bạn nhập sai, mời nhập lại : ");
				break;
			}
		}
	}

	public void Question2() {
		ArrayList<Student_Q2> list = new ArrayList<Student_Q2>();
		while (true) {
			System.out.println("\t\t --- Chương trình --- \t\t");
			System.out.println("1. Nhập thông tin.");
			System.out.println("2. Hiển thị thông tin.");
			System.out.println("\t\t -------------------- \t\t");
			System.out.print("Mời bạn nhập lựa chọn : ");
			int lc = scanner.nextInt();
			switch (lc) {
			case 1:
				System.out.println("\t --- InputInfo --- \t");
				System.out.print("Số sinh viên cần thêm : ");
				int n = scanner.nextInt();
				for (int i = 0; i < n; i++) {
					System.out.println("\nSinh viên thứ " + (i + 1));
					Student_Q2 student = new Student_Q2();
					student.inputInfo();
					list.add(student);
				}
				break;
			case 2:
				for (Student_Q2 student_Q2 : list) {
					student_Q2.showInfo();
					if (student_Q2.getAVGMark() >= 8.0) {
						System.out.println("Sinh viên này đạt học bổng !");
					} else {
						System.out.println("Không đạt !");
					}
				}
			default:
				System.out.println("Mời bạn nhập lại");
				break;
			}
		}
	}

	public void Question3() {
		while (true) {
			System.out.println("\t\t --- Chương trình --- \t\t");
			System.out.println("1. Hình Chữ Nhật.");
			System.out.println("2. Hình Vuông.");
			System.out.println("\t\t -------------------- \t\t");
			System.out.print("Mời bạn nhập lựa chọn : ");
			int lc = scanner.nextInt();
			switch (lc) {
			case 1:
				HinhChuNhat hcn = new HinhChuNhat();
				System.out.println("Khởi tạo hình chữ nhật ");
				hcn.input();
				System.out.println("Tính toán :  ");
				hcn.output();
				break;
			case 2:
				System.out.println("Nhập vào cạnh của hình vuông: ");
				Float a = scanner.nextFloat();
				HinhVuong hv = new HinhVuong(a);
				System.out.println("Bạn vừa tạo thành công hình vuông có cạnh " + a);
				System.out.println("Chu vi của hình vuông là: " + hv.tinhChuVi());
				System.out.println("Diện tích của hình vuông là: " + hv.tinhDienTich());

				break;
			default:
				System.out.println("Mời bạn nhập lại");
				break;
			}
		}
	}

	public void Question4() {
		MyMath myMath = new MyMath();
		while (true) {
			System.out.println("\n\t\t --- Chương trình --- \t\t");
			System.out.println("\t 1. Tính tổng hai số kiểu int.");
			System.out.println("\t 2. Tính tổng hai số kiểu float.");
			System.out.println("\t 3. Tính tổng hai số kiểu byte.");
			System.out.println("\t 4. Tính tổng hai số kiểu float và byte. // Nhập float trước");
			System.out.println("\t 5. Tính tổng hai số kiểu float và in. // Nhập float trước");
			System.out.println("\t\t -------------------- \t\t");
			System.out.print("Mời bạn nhập lựa chọn : ");
			int lc = scanner.nextInt();
			switch (lc) {
			case 1:
				System.out.print("Nhập vào số a : ");
				int a1 = scanner.nextInt();
				System.out.print("Nhập vào số b : ");
				int b1 = scanner.nextInt();
				System.out.print("Kết quả : " + myMath.getSum(a1, b1));
				break;
			case 2:
				System.out.print("Nhập vào số a : ");
				float a2 = scanner.nextFloat();
				System.out.print("Nhập vào số b : ");
				float b2 = scanner.nextFloat();
				System.out.print("Kết quả : " + myMath.getSum(a2, b2));
				break;
			case 3:
				System.out.print("Nhập vào số a : ");
				byte a3 = scanner.nextByte();
				System.out.print("Nhập vào số b : ");
				byte b3 = scanner.nextByte();
				System.out.print("Kết quả : " + myMath.getSum(a3, b3));
				break;
			case 4:
				System.out.print("Nhập vào số a : ");
				float a4 = scanner.nextFloat();
				System.out.print("Nhập vào số b : ");
				byte b4 = scanner.nextByte();
				System.out.print("Kết quả : " + myMath.getSum(a4, b4));
				break;
			case 5:
				System.out.print("Nhập vào số a : ");
				float a5 = scanner.nextFloat();
				System.out.print("Nhập vào số b : ");
				int b5 = scanner.nextInt();
				System.out.print("Kết quả : " + myMath.getSum(a5, b5));
				break;
			default:
				System.out.println("Mời nhập lại !");
				break;
			}
		}
	}
	public void Question5() {
		while (true) {
			System.out.println("\t\t --- Chương trình --- \t\t");
			System.out.println("1. Điện thoại thông minh.");
			System.out.println("2. Điện thoại cổ điển.");
			System.out.println("\t\t -------------------- \t\t");
			System.out.print("Giả sử bạn bị kẻ xấu tấn công, bạn muốn sử dụng điện thoại nào : ");
			int lc = scanner.nextInt();
			switch (lc) {
				case 1:
					DienThoaiTM dTm = new DienThoaiTM();
					dTm.TanCong();
					break;
				case 2:
					DienThoaiCD dCd = new DienThoaiCD();
					dCd.TanCong();
					break;	
				default:
					System.out.println("Mời nhập lại !");
					break;
			}
		}
	}
}
