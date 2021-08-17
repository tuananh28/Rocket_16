package com.vti.entity.enumerate;

import javax.persistence.AttributeConverter;

public class SalaryNameConvert implements AttributeConverter<SalaryName, String>{

	public String convertToDatabaseColumn(SalaryName name) {
		if (name == null) {
			return null;
		}
		return name.getValue();
	}

	public SalaryName convertToEntityAttribute(String value) {
		return SalaryName.of(value);
	}
	
}
