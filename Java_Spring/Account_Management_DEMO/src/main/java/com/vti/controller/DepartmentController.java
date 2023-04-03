package com.vti.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.dto.DepartmentDto;
import com.vti.entity.Department;
import com.vti.service.IDepartmentService;

@RestController
@RequestMapping(value = "api/v1/departments")
@CrossOrigin("*")
public class DepartmentController {

	@Autowired
	private IDepartmentService departmentService;

	@GetMapping()
	public ResponseEntity<?> getAllDepartments() {
		List<Department> entities = departmentService.getAllDepartments();

		List<DepartmentDto> dtos = new ArrayList<>();

		// convert entities --> dtos
		for (Department entity : entities) {
			DepartmentDto dto = new DepartmentDto(entity.getId(), entity.getName());
			dtos.add(dto);
		}

		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}

}
