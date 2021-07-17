package com.vti.entity.Inheritance.Question1_2;

import java.util.Scanner;

public class KySu extends CanBo{

	private String NganhDaoTao;
	private Scanner scanner;
	
	public String getNganhDaoTao() {
		return NganhDaoTao;
	}

	public void setNganhDaoTao(String nganhDaoTao) {
		NganhDaoTao = nganhDaoTao;
	}
	@Override
	public void Input() {
		super.Input();
		System.out.print("Ngành Đào Tạo : ");
		scanner = new Scanner(System.in);
		NganhDaoTao = scanner.nextLine();
	}
	
	public void Output() {
		super.Output();
		System.out.println("Ngành Đào Tạo : "+NganhDaoTao);
	}
}
