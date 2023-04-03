package com.vti.entity.Static;

public class HinhTron extends HinhHoc {

	public final float PI = 3.14f;

	public HinhTron(float a, float b) throws Exception {
		super(a, b);
		// TODO Auto-generated constructor stub
	}

	@Override
	public float tinhChuVi(float a, float b) {
		// TODO Auto-generated method stub
		return 2 * a * (PI);
	}

	@Override
	public float tinhDientich(float a, float b) {
		// TODO Auto-generated method stub
		return (float) (PI * (Math.pow(a, 2)));
	}

}
