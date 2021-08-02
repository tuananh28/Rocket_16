package com.vti.ultis;

import java.util.Date;
import java.text.SimpleDateFormat;

public class DateUtil {

	public static Date formatStringToDate(String ngayThangNam) {
		Date resultDate = null;

		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
			resultDate = (Date) simpleDateFormat.parse(ngayThangNam);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

		return resultDate;
	}

	public static String formatDateToString(Date ngayThangNam) {

		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
			return simpleDateFormat.format(ngayThangNam);
		} catch (Exception e) {
			// TODO: handle exception
		}

		return null;
	}

}
