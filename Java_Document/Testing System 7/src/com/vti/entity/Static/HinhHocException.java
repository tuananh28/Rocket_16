package com.vti.entity.Static;

@SuppressWarnings("serial")
public class HinhHocException extends Exception {
	public HinhHocException() {
		super("Số lượng hình đã tạo vượt quá số lượng cho phép là : " + Configs.SO_LUONG_HINH_TOI_DA);
	}
}
