package com.vti.backend;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.vti.entity.Student;
import com.vti.ultis.ScannerUltis;

public class Ex1_Collection {
	// List chiếm ít ô nhớ hơn ArrayList Nếu không quan tâm tới thuộc tính của nó
	private List<Student> list;

	public Ex1_Collection() {
		list = new ArrayList<Student>();
//	System.out.println("Nhập số sinh viên muốn thêm : ");
//	int st = ScannerUltis.inputInt();
//	for (int i = 0; i < st - 3; i++) {
//		Student student = new Student("Student "+ (i+1));
//		list.add(student);
//	}
		list.add(new Student("Bùi Tuấn Anh"));
		list.add(new Student("Bùi Thị Hoa Mai"));
		list.add(new Student("Phạm Ngọc Diễn"));
		list.add(new Student("Lê Bảo Ngọc"));

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getID());
			System.out.println(list.get(i).getName());
		}
	}

	public static void Question1() {
		Ex1_Collection ex1 = new Ex1_Collection();
		int lc;
		while (true) {
			System.out.println("\t\t --- MENU --- \t\t");
			System.out.println("\t 1.In ra tổng số phần tử của students.");
			System.out.println("\t 2.Lấy phần tử thứ 4 của students.");
			System.out.println("\t 3.In ra phần tử đầu và phần tử cuối của students.");
			System.out.println("\t 4.Thêm 1 phần tử vào vị trí đầu của students.");
			System.out.println("\t 5.Thêm 1 phần tử vào vị trí cuối của students.");
			System.out.println("\t 6.Đảo ngược vị trí của students.");
			System.out.println("\t 7.Tạo 1 method tìm kiếm student theo id.");
			System.out.println("\t 8.Tạo 1 method tìm kiếm student theo name.");
			System.out.println("\t 9.Tạo 1 method để in ra các student có trùng tên.");
			System.out.println("\t 10.Xóa name của student có id = 2.");
			System.out.println("\t 11.Delete student có id = 5.");
			System.out.println("\t 12.Tạo 1 ArrayList tên là studentCopies và add tất cả students vào studentCopies.");
			System.out.print(" Mời bạn đưa ra lựa chọn : ");
			lc = ScannerUltis.inputInt();
			switch (lc) {
			case 1:
				System.out.println("Tổng số phần tử của Student là : " + ex1.list.size());
				break;
			case 2:
				System.out.println("Phần tử thứ 4 của student là : " + ex1.list.get(3));
				break;
			case 3:
				System.out.println("Phần tử đầu là : " + ex1.list.get(0));
				System.out.println("Phần tử cuối là : " + ex1.list.get(ex1.list.size() - 1));
				break;
			case 4:
				System.out.println("Nhập thông tin Student cần thêm : ");
				String name = ScannerUltis.inputString();
				ex1.list.add(0, new Student(name));
				break;
			case 5:
				System.out.println("Nhập thông tin Student cần thêm : ");
				String name2 = ScannerUltis.inputString();
				ex1.list.add(new Student(name2));
				break;
			case 6:
				Collections.reverse(ex1.list);
				System.out.println("Đã đảo ngược vị trí phần tử");
				break;
			case 7:
				System.out.print("Nhập ID Student cần tìm : ");
				int n = ScannerUltis.inputInt();
				for (Student student : ex1.list) {
					if (n == student.getID()) {
						System.out.println(student);
					}
				}
				break;
			case 8:
				System.out.print("Nhập tên Student cần tìm : ");
				String name3 = ScannerUltis.inputString();
				for (Student student : ex1.list) {
					if (student.getName().equalsIgnoreCase(name3)) {
						System.out.println(student);
					}
				}
				break;
			case 9:
				System.out.println("Các sinh viên trùng tên: ");
				for (int i = 0; i < ex1.list.size(); i++) {
					for (int j = i + 1; j < ex1.list.size(); j++) {
						if (ex1.list.get(i).getName().equals(ex1.list.get(j).getName())) {
							System.out.println(ex1.list.get(i).toString());
						}
					}
				}
				break;
			case 10:
				for (Student student : ex1.list) {
					if (student.getID() == 2) {
						student.setName(null);
						System.out.println("Đã thay đổi tên phần tử thứ 2");
					}
				}
				break;
			case 11:
//				System.out.println("Nhập vào ID của student cần xóa:");
//				int id = ScannerUltis.inputIntPositive();
				ex1.list.removeIf(student -> student.getID() == 5);
				System.out.println("Đã xóa Student id = 5");
				break;
			case 12:
				List<Student> arrayCop = new ArrayList<Student>();
				arrayCop.addAll(ex1.list);
				System.out.println("In phần tử trong ArrayCop : ");
				for (Student student : arrayCop) {
					System.out.println(student);
				}
				break;
			default:
				System.out.println("Mời nhập lại !");
				return;
			}
		}
	}
}
