package com.vti.form;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class DepartmentFilterForm {

	// https://www.programmersought.com/article/85464607876/
	// https://www.baeldung.com/mysql-jdbc-timezone-spring-boot
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date minDate;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date maxDate;

	public DepartmentFilterForm() {
	}

	public Date getMinDate() {
		return minDate;
	}

	public void setMinDate(Date minDate) {
		this.minDate = minDate;
	}

	public Date getMaxDate() {
		return maxDate;
	}

	public void setMaxDate(Date maxDate) {
		this.maxDate = maxDate;
	}

}
