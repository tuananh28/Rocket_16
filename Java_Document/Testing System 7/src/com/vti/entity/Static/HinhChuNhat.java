package com.vti.entity.Static;

public class HinhChuNhat extends HinhHoc {

	public HinhChuNhat(float a, float b) throws Exception {
		super(a, b);
		// TODO Auto-generated constructor stub
	}

	@Override
	public float tinhChuVi(float a, float b) {
		// TODO Auto-generated method stub
		return 2 * (a + b);
	}

	@Override
	public float tinhDientich(float a, float b) {
		// TODO Auto-generated method stub
		return (a * b);
	}

}
