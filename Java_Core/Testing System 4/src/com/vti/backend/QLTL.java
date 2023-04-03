package com.vti.backend;

import java.util.ArrayList;
import java.util.Scanner;

import com.vti.entity.Inheritance.Question3.Bao;
import com.vti.entity.Inheritance.Question3.Sach;
import com.vti.entity.Inheritance.Question3.TaiLieu;
import com.vti.entity.Inheritance.Question3.TapChi;

public class QLTL {
	ArrayList<TaiLieu> list = new ArrayList<>();
	Scanner scanner = new Scanner(System.in);
	public void Them() {
		int lc;
		do {
			System.out.println("===\t MENU \t===");
			System.out.println("\t 1.Sách");
			System.out.println("\t 2.Tạp Chí");
			System.out.println("\t 3.Báo");
			System.out.println("\t 4.Quay lại ");
			System.out.println("=========================");
			System.out.print("Mời bạn đưa ra lựa chọn : ");
			lc = scanner.nextInt();
			switch (lc) {
			case 1:
				System.out.println("=== Sách ===");
				System.out.print("Số lượng cần thêm : ");
				int a = scanner.nextInt();
				for (int i = 0; i < a; i++) {
					System.out.println("\nSách thứ "+(i+1));
					Sach sach = new Sach();
					sach.Input();
					list.add(sach);					
				}
				break;
			case 2:
				System.out.println("=== Tạp Chí ===");
				System.out.print("Số lượng cần thêm : ");
				int b = scanner.nextInt();
				for (int i = 0; i < b; i++) {
					System.out.println("\nTạp chí thứ "+(i+1));
					TapChi tapChi = new TapChi();
					tapChi.Input();
					list.add(tapChi);					
				}
				break;
			case 3:
				System.out.println("=== Báo ===");
				System.out.print("Số lượng cần thêm : ");
				int c = scanner.nextInt();
				for (int i = 0; i < c; i++) {
					System.out.println("\nBáo thứ "+(i+1));
					Bao bao = new Bao();
					bao.Input();
					list.add(bao);			
				}
				break;
			case 4:
				System.out.println("Quay lại");
				break;
			default:
				System.out.println("Bạn nhập sai ! Mời nhập lại ");
				return;
			}
		} while (lc != 4);
	}
	public void HienThi() {
		for (TaiLieu taiLieu : list) {
			taiLieu.Output();
		}
	}
	public void TimKiem() {
		int loai;
		System.out.println("\t 1.Sách");
		System.out.println("\t 2.Tạp Chí");
		System.out.println("\t 3.Báo");
		System.out.println("\t 4.Quay lại ");
		System.out.println("================");
		System.out.print("Bạn muốn tìm kiếm theo loại nào : ");
		loai = scanner.nextInt();
		switch (loai) {
		case 1:
			for (TaiLieu taiLieu : list) {
				if(taiLieu instanceof Sach) {
					taiLieu.Output();
				}
			}
			break;
		
		case 2:
			for (TaiLieu taiLieu : list) {
				if(taiLieu instanceof TapChi) {
					taiLieu.Output();
				}
			}
			break;
		case 3:
			for (TaiLieu taiLieu : list) {
				if(taiLieu instanceof Bao) {
					taiLieu.Output();
				}
			}
			break;
		case 4:
			break;
		default:
			System.out.println("Bạn nhập sai, mời nhập lại !");
			return;
		}
	}
	public void XoaTaiLieu() {
		System.out.print("Nhập mã tài liệu cần xóa : ");
		int matailieu = scanner.nextInt();
		for (TaiLieu taiLieu : list) {
			if (matailieu == taiLieu.getMaTaiLieu()) {
				list.remove(taiLieu);
				System.out.println("Mã tài liệu "+matailieu+" đã xóa");
				taiLieu.Output();
			}
		}
	}
}
