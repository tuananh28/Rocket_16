package com.vti.frontend;

import java.util.Scanner;

import com.vti.backend.Ex5_Inheritance;
import com.vti.backend.QLCB;
import com.vti.backend.QLTL;

public class Frontend_Inheritance {
	private static Scanner scanner;

	public static void main(String[] args) {
		QLCB();
		Ex5_Inheritance ex5 = new Ex5_Inheritance();
		ex5.Question3();
		QLTL();
	}

	private static void QLCB() {
		QLCB qlcb = new QLCB();
		int lc;
		do {
			System.out.println("=======MENU==========");
			System.out.println("  1. Thêm mới cán bộ. ");
			System.out.println("  2. Tìm kiếm theo họ tên.");
			System.out.println("  3. Hiện thị thông tin về danh sách các cán bộ.");
			System.out.println("  4. Nhập vào tên của cán bộ và delete cán bộ đó.");
			System.out.println("  0. Thoát khỏi chương trình.");
			System.out.println("=====================");
			System.out.print("Đưa ra lựa chọn : ");
			scanner = new Scanner(System.in);
			lc = scanner.nextInt();
			switch (lc) {
			case 1:
				qlcb.Them();
				break;
			case 2:
				qlcb.TimKiem();
				break;
			case 3:
				qlcb.HienThi();
				break;
			case 4:
				qlcb.XoaCanBo();
				break;
			case 0:
				System.out.println("Thoát chương trình");
				return;
			default:
				System.out.println("Bạn nhập sai, mời nhập lại !");
				break;
			}
		} while (lc!=0);	
	}
	public static void QLTL() {
		QLTL qltl = new QLTL();
		int lc;
		do {
			System.out.println("==============MENU==========");
			System.out.println("  1. Thêm mới tài liêu: Sách, tạp chí, báo. ");
			System.out.println("  2. Xoá tài liệu theo mã tài liệu.");
			System.out.println("  3. Hiện thị thông tin về tài liệu.");
			System.out.println("  4. Tìm kiếm tài liệu theo loại: Sách, tạp chí, báo.");
			System.out.println("  0. Thoát khỏi chương trình.");
			System.out.println("=======================================================");
			System.out.print("Đưa ra lựa chọn : ");
			scanner = new Scanner(System.in);
			lc = scanner.nextInt();
			switch (lc) {
			case 1: 
				qltl.Them();
				break;
			case 2: 
				qltl.XoaTaiLieu();
				break;
			case 3: 
				qltl.HienThi();
				break;
			case 4: 
				qltl.TimKiem();
				break;
			case 0: 
				System.out.println("Thoát chương trình .");
				break;
			default:
				System.out.println("Bạn nhập sai, mời nhập lại");
				return;
			}
		} while (lc != 0);
	}
}
