package com.vti.entity.Polymorphism.Question2;

import java.time.LocalDate;
import java.util.Scanner;


public class Person {
	private String Name;
	private Gender gender;
	private LocalDate birthday;
	private String Address;
	private Scanner scanner = new Scanner(System.in);
	
	
	public enum Gender {
		MALE, FEMALE,UNKNOWN;
	}
	
	public Person() {
		// TODO Auto-generated constructor stub
	}

	public Person(String name, Gender gender, LocalDate birthday, String address) {
		super();
		this.Name = name;
		this.gender = gender;
		this.birthday = birthday;
		this.Address = address;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}
	
	public void inputInfo() {
		System.out.print("Họ tên : ");
		Name = scanner.nextLine();
		System.out.print("Giới Tính : \n 1.Nam \n 2.Nữ  \n3.Khác");
		int n = Integer.parseInt(scanner.nextLine());
		switch (n) {
		case 1:
			this.gender = Gender.MALE;
			break;
		case 2:
			this.gender = Gender.FEMALE;
			break;
		case 3 : 
			this.gender = Gender.UNKNOWN;
		}
		
		System.out.print("Ngày sinh : ");
		birthday = LocalDate.parse(scanner.nextLine());
		System.out.print("Địa chỉ : ");
		Address = scanner.nextLine();	
	}
	
	public void showInfo() {
		System.out.println("Họ tên : "+Name);
		System.out.println("Giới Tính : "+gender);
		System.out.println("Ngày sinh : "+birthday);
		System.out.println("Địa chỉ : "+Address);
	}	
}