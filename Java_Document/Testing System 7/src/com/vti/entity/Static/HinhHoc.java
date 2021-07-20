package com.vti.entity.Static;

public abstract class HinhHoc {
	@SuppressWarnings("unused")
	private float a;
	@SuppressWarnings("unused")
	private float b;
	public static int dem = 0;

	public abstract float tinhChuVi(float a, float b);

	public abstract float tinhDientich(float a, float b);

	public HinhHoc(float a, float b) throws Exception {
		super();
		dem++;
		if (dem <= Configs.SO_LUONG_HINH_TOI_DA) {
			this.a = a;
			this.b = b;
		} else {
			throw new HinhHocException();
		}
	}
}
