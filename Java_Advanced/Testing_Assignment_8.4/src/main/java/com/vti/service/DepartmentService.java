package com.vti.service;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.entity.Department;
import com.vti.repository.IDepartmentRepository;
import com.vti.specification.SpecificationBuilder;

@Service
public class DepartmentService implements IDepartmentService {

	@Autowired
	private IDepartmentRepository repository;

	public List<Department> getAllDepartments(String search) throws ParseException {

		SpecificationBuilder<Department> specificationBuilder = new SpecificationBuilder<Department>(search);
		return repository.findAll(specificationBuilder.build());
	}

}