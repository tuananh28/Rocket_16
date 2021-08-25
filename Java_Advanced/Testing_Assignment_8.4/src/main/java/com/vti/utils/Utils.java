package com.vti.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

import org.springframework.util.StringUtils;

public class Utils {
	
	@SuppressWarnings("deprecation")
	public static boolean isMatchRegex(String input, String regex) {
		// validate input
		if (StringUtils.isEmpty(input)) {
			return false;
		}

		// return validation result
		return Pattern.compile(regex).matcher(input).matches();
	}
	
	public static Date convertStringToDateObject(String input, String pattern) throws ParseException {
		return new SimpleDateFormat(pattern).parse(input);
	}

}
