package com.vti.entity.Polymorphism.Question4;

public class MyMath {
	public int getSum(int a, int b) {
		return (a + b);
	}

	public byte getSum(Byte a, Byte b) {
		return (byte) (a + b);
	}

	public Float getSum(Float a, Float b) {
		return (a + b);
	}

	public Float getSum(Byte a, Float b) {
		return (a + b);
	}

	public int getSum(Byte a, int b) {
		return (a + b);
	}

	public Float getSum(Float a, int b) {
		return (a + b);
	}

}
