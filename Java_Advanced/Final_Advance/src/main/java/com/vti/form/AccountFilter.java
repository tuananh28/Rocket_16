package com.vti.form;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AccountFilter {
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date minDate;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date maxDate;

}
