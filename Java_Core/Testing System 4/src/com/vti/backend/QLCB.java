package com.vti.backend;

import java.util.ArrayList;
import java.util.Scanner;

import com.vti.entity.Inheritance.Question1_2.CanBo;
import com.vti.entity.Inheritance.Question1_2.CongNhan;
import com.vti.entity.Inheritance.Question1_2.KySu;
import com.vti.entity.Inheritance.Question1_2.NhanVien;


public class QLCB {
	ArrayList<CanBo> list = new ArrayList<>();
	Scanner scanner = new Scanner(System.in);

	public void Them() {
		int lc;		
		do {	
			System.out.println("--------MENU---------");
			System.out.println("1. Nhân Viên ");
			System.out.println("2. Công Nhân ");
			System.out.println("3. Kỹ Sư ");
			System.out.println("4. Quay lại");
			System.out.print("Mời bạn nhập lựa chọn : ");
			lc = scanner.nextInt();
			switch (lc) {
			case 1:
				System.out.println("==============NHÂN VIÊN===========");
				System.out.print("Số Lượng cần thêm : ");
				int a = scanner.nextInt();
				for (int i = 0; i < a; i++) {
					System.out.println("\nNhân viên thứ " + (i + 1));
					NhanVien NV = new NhanVien();
					NV.Input();
					list.add(NV);
				}
				break;
			case 2:
				System.out.println("==============CÔNG NHÂN===========");
				System.out.print("Số Lượng cần thêm : ");
				int b = scanner.nextInt();
				for (int i = 0; i < b; i++) {
					System.out.println("\nCông nhân thứ " + (i + 1));
					CongNhan CN = new CongNhan();
					CN.Input();
					list.add(CN);
				}
				break;

			case 3:
				System.out.println("==============KỸ SƯ===========");
				System.out.print("Số Lượng cần thêm : ");
				int c = scanner.nextInt();
				for (int i = 0; i < c; i++) {
					System.out.println("\nKỹ sư thứ " + (i + 1));
					KySu KS = new KySu();
					KS.Input();
					list.add(KS);
				}
				break;
			case 4:
				System.out.println("Quay lại ");
				break;
			default:
				System.out.println("Bạn nhập sai, mời nhập lại");
				break;
			}
		} while (lc != 4);
	}
	public void TimKiem() {
		String ten;
		System.out.print("Nhập Họ Tên cần tìm : ");
		ten = scanner.nextLine();
		for (CanBo canBo : list) {
			if(canBo.getHoten().equalsIgnoreCase(ten))
			{
				canBo.Output();
			}
		}
	}
	public void HienThi() {
		for (CanBo canBo : list) {
			canBo.Output();
		}
	}
	public void XoaCanBo() {
		String hoTen;
		System.out.print ("Nhập Họ Tên cần xóa: ");
		hoTen = scanner.nextLine();

		list.removeIf(cb -> hoTen.equals(cb.getHoten()));
	}
}
