package com.vti.backend;

import com.vti.entity.File.MyClass;
import com.vti.ultis.IOManager;
import com.vti.ultis.ScannerUltis;

public class Ex4_IO_Stream {
	public void Question1() throws Exception {
		System.out.println("Chương trình đọc file");
		System.out.print("Nhập vào file muốn đọc : ");
		String path = ScannerUltis.inputString();
		System.out.println(IOManager.readFile(path));
	}
	public void Question2() throws Exception {
		System.out.println("Chương trình ghi file");
		System.out.print("Nhập file muốn ghi : ");
		String path = ScannerUltis.inputString();
		System.out.print("Nhập vào nội dung muốn ghi : ");
		String content = ScannerUltis.inputString();
		IOManager.writeFile(path, true, content);
	}
	public void Question3() throws Exception{
		System.out.print("Nhập file muốn ghi : ");
		String path = ScannerUltis.inputString();
		MyClass myClass = new MyClass();
		IOManager.writeObject(myClass.toString(), path);
	}
	public void Question4() throws Exception {
		System.out.print("Nhập File muốn đọc : ");
		String filePath = ScannerUltis.inputString();
		System.out.println(IOManager.readObject(filePath));
	}
}
