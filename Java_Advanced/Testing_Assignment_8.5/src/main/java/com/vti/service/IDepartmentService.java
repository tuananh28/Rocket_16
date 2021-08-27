package com.vti.service;

import java.text.ParseException;
import java.util.List;

import com.vti.entity.Department;

public interface IDepartmentService {

	public List<Department> getAllDepartments(String search) throws ParseException;
}
