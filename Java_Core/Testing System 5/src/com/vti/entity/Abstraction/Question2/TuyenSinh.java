package com.vti.entity.Abstraction.Question2;

import java.util.ArrayList;
import java.util.Scanner;

public class TuyenSinh implements ITuyenSinh {
	ArrayList<ThiSinh> list = new ArrayList<>();
	Scanner scanner = new Scanner(System.in);

	@Override
	public void Them() {
		System.out.print("Số thí sinh cần thêm : ");
		int n = scanner.nextInt();
		for (int i = 0; i < n; i++) {
			System.out.println("\nThí sinh thứ " + (i + 1));
			ThiSinh thiSinh = new ThiSinh();
			thiSinh.Input();
			list.add(thiSinh);
		}
	}

	@Override
	public void HienThi() {
		for (ThiSinh thiSinh : list) {
			System.out.println(thiSinh);
		}
	}

	@Override
	public void TimKiem() {
		System.out.print("Nhập ID thí sinh cần tìm : ");
		String id = scanner.next();
		for (ThiSinh thiSinh : list) {
			if (thiSinh.getSbd().equals(id)) {
				System.out.println(thiSinh);
			} else
				System.out.println("Số báo danh bạn tìm không có !");
		}
	}

}
