package com.vti.entity;

import java.time.LocalDate;

public class Ex2_Student implements Comparable<Ex2_Student>{
	private int id;
	private String name;
	private LocalDate birthDate;
	private float mark;
	public static int dem =0;
	
	public Ex2_Student(String name, LocalDate birthDate, float mark) {
		super();
		this.id = ++dem;
		this.name = name;
		this.birthDate = birthDate;
		this.mark = mark;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public float getMark() {
		return mark;
	}

	public void setMark(float mark) {
		this.mark = mark;
	}

	@Override
	public String toString() {
		return "Ex2_Student [id=" + id + ", name=" + name + ", birthDate=" + birthDate + ", mark=" + mark + "]";
	}

	@Override
	public int compareTo(Ex2_Student o) {
		// TODO Auto-generated method stub
		int flagCompare = this.name.compareTo(o.getName());
		if (flagCompare == 0) {
		if (this.mark > o.mark) {
		return 1;
		} else if (this.mark < o.mark) {
		return -1;
		} else if (this.mark == o.mark) {
		return this.birthDate.compareTo(o.getBirthDate());
		}
		} else {
		return flagCompare;
		}
		return 0;
	}
}
