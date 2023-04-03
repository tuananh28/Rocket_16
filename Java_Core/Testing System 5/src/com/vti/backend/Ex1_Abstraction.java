package com.vti.backend;

import java.util.ArrayList;
import java.util.Scanner;
import com.vti.entity.Abstraction.Question1.News;
import com.vti.entity.Abstraction.Question2.TuyenSinh;

public class Ex1_Abstraction {
	ArrayList<News> list = new ArrayList<>();
	Scanner scanner = new Scanner(System.in);
	News news = new News();
	TuyenSinh tuyenSinh = new TuyenSinh();
	public void Question1() {
		int choose;
		do {
			System.out.println("\t\t MENU \t\t");
			System.out.println("\t 1.Insert news.");
			System.out.println("\t 2.View list news.");
			System.out.println("\t 3.Average rate.");
			System.out.println("\t 4.Exit.");
			System.out.println("============================");
			System.out.print("Mời bạn đưa ra lựa chọn : ");
			choose = scanner.nextInt();
			switch (choose) {
			case 1:
				float[] rates = new float[3];
				System.out.print("Title : ");
				scanner.nextLine();
				news.setTitle(scanner.nextLine());
				System.out.print("PublishDate : ");
				news.setPublishDate(scanner.nextLine());
				System.out.print("Author : ");
				news.setAuthor(scanner.nextLine());
				System.out.print("Content : ");
				news.setContent(scanner.nextLine());
				System.out.println("Nhập vào 3 đánh giá  ");
				for (int i = 0; i < 3; i++) {
					System.out.print("Đánh giá thứ " + (i + 1) + ": ");
					rates[i] = scanner.nextFloat();
				}
				news.setRate(rates);
				list.add(news);
				break;
			case 2:
				for (News news : list) {
					news.Display();
				}
				break;
			case 3:
				System.out.println("Đánh giá trung bình Rate");
				for (News news : list) {
					System.out.println("RateAVG : " + news.Calculate());
				}
				break;
			case 4:
				System.out.println("Thoát chương trình !");
				return;
			default:
				System.out.println("Bạn nhập sai, mời nhập lại : ");
				break;
			}
		} while (choose != 4);
	}

	public void Question2() {
		while (true) {
			System.out.println("\t\t MENU \t\t");
			System.out.println("\t 1. Thêm mới thí sinh.");
			System.out.println("\t 2. Hiện thị thông tin của thí sinh và khối thi của thí sinh.");
			System.out.println("\t 3. Tìm kiếm theo số báo danh.");
			System.out.println("\t 4. Thoát khỏi chương trình.");
			System.out.println("\t\t\t ======= \t\t\t");
			System.out.print("Mời bạn đưa ra lựa chọn : ");
			int lc = scanner.nextInt();
			switch (lc) {
			case 1:
				tuyenSinh.Them();
				break;
			case 2:
				tuyenSinh.HienThi();
				break;
			case 3:
				tuyenSinh.TimKiem();
				break;
			case 4:
				System.out.println("Thoát Chương trình !");
				return;
			default:
				System.out.println("Bạn nhập sai, mời nhập lại : ");
				break;
			}
		}
	
	}
}
