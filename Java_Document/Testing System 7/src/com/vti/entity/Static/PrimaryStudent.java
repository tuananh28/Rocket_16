package com.vti.entity.Static;

public class PrimaryStudent extends Student{
	public static int demPri = 0;
	
	public PrimaryStudent() {
		super();
		demPri++;
	}
}
