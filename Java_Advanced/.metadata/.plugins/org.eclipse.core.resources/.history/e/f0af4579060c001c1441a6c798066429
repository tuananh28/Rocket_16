package com.vti.controller;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.dto.AccountDTO;
import com.vti.service.AccountService;
import com.vti.service.DepartmentService;
import com.vti.utils.ValidationUtils;

public class DepartmentController {
	private DepartmentService depService;

	public DepartmentController() {
		depService = new DepartmentService();
	}

	@SuppressWarnings("unchecked")
	public List<Department> getAllDepartments() {

		return depService.getAllDepartmentAccounts();
	}

}
