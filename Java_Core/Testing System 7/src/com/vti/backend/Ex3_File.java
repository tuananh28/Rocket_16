package com.vti.backend;

import com.vti.ultis.FileUltis;
import com.vti.ultis.ScannerUltis;

public class Ex3_File {
	public void AllQuestion() throws Exception {
		loadMenuFile();
	}

	private void loadMenuFile() throws Exception {

		while (true) {
			System.out.println("\t\t --- Lựa chọn chức năng bạn muốn sử dụng --- \t\t");
			System.out.println("\t 1. Check File is exists. \t");
			System.out.println("\t 2. Check Folder 	\t");
			System.out.println("\t 3. Tạo file mới 	\t");
			System.out.println("\t 4. Tạo mới file từ đường dẫn và tên file riêng \t");
			System.out.println("\t 5. Xóa file \t");
			System.out.println("\t 6. Check path is File or Folder ");
			System.out.println("\t 7. Get all file in Folder ");
			System.out.println("\t 8. Copy File ");
			System.out.println("\t 9. Move File ");
			System.out.println("\t 10. Rename File ");
			System.out.println("\t 11. Tạo Folder ");
			System.out.println("\t 12. Download File ");
			System.out.println("\t 15. End Program ");
			System.out.println("\t\t ----------------------- \t\t");
			int menuChoose = ScannerUltis.inputIntPositive();
			switch (menuChoose) {
			case 1:
				System.out.print("Nhập vào đường dẫn và file cần kiểm tra : ");
				String path1 = ScannerUltis.inputString();
				if (FileUltis.isFileExists(path1)) {
					System.out.println("file đã có trên hẹ thống");
				} else {
					System.out.println("Không có file trên hệ thống");
				}
				break;
			case 2:
				System.out.print("Nhập Folder cần kiểm tra : ");
				String path2 = ScannerUltis.inputString();
				if (FileUltis.isFolderExists(path2)) {
					System.out.println("Có Folder trên hện thống");
				} else {
					System.out.println("Không có Folder trên hệ thống ");
				}
				break;
			case 3:
				System.out.println("Nhập vào đường dẫn và tên file cần tạo: ");
				String path3 = ScannerUltis.inputString();
				FileUltis.createNewFile(path3);
				break;
			case 4:
				System.out.println("Nhập vào đường dẫn: ");
				String path4 = ScannerUltis.inputString();
				System.out.println("Nhập vào tên file cần tạo: ");
				String fileName4 = ScannerUltis.inputString();
				FileUltis.createNewFile(path4, fileName4);
				break;
			case 5:
				System.out.println("Nhập vào đường dẫn và tên file cần xóa: ");
				String path5 = ScannerUltis.inputString();
				FileUltis.deleteFile(path5);
				break;
			case 6:
				System.out.println("Nhập vào Path cần kiểm tra ");
				String path6 = ScannerUltis.inputString();
				FileUltis.isFolderOrFile(path6);
				break;
			case 7:
				System.out.println("Nhập vào Path cần kiểm tra ");
				String path7 = ScannerUltis.inputString();
				String[] list = FileUltis.getAllFileName(path7);
				for (int i = 0; i < list.length; i++) {
					System.out.println(list[i]);
				}
				break;
			case 8:
				System.out.println("Nhập vào source nguồn: ");
				String source8 = ScannerUltis.inputString();
				System.out.println("Nhập vào Folder đích: ");
				String path8 = ScannerUltis.inputString();
				FileUltis.copyFile(source8, path8);
				break;
			case 9:
				System.out.println("Nhập vào file nguồn: ");
				String source9 = ScannerUltis.inputString();
				System.out.println("Nhập vào folder đích: ");
				String destination9 = ScannerUltis.inputString();
				FileUltis.moveFile(source9, destination9);
				// chưa chạy được chức năng này cần kiểm tra thêm.
				break;
			case 10:
				System.out.println("-- Chú ý nhập vào đầy đủ cả đường dẫn và tên file.");
				System.out.println("Nhập vào file nguồn: ");
				String source10 = ScannerUltis.inputString();
				System.out.println("Nhập vào file đích: ");
				String des10 = ScannerUltis.inputString();
				FileUltis.renameFile(source10, des10);
				break;
			case 11:
				System.out.println("Nhập vào đường dẫn folder cần tạo: ");
				String newPathFolder = ScannerUltis.inputString();
				FileUltis.createNewFolder(newPathFolder);
				break;
			case 12:
				System.out.println("No Data");
				break;
			case 15:
				return;
			default:
				System.out.println("Alarm: Lựa chọn đúng số trên menu");
				break;
			}
		}
	}
}