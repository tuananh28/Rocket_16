package com.vti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.entity.Department;
import com.vti.repository.IDepartmentRepository;

@Service
public class DepartmentService implements IDepartmentService {

	@Autowired
	private IDepartmentRepository repository;

	public List<Department> getAllDepartments() {
		return repository.findAll();
	}

	public Department getDepartmentByID(short id) {
		return repository.findById(id).get();
	}

	public Department getDepartmentByName(String name) {
		return repository.findByName(name);
	}

	public void createDepartment(Department department) {
		repository.save(department);
	}

	public void updateDepartment(Department department) {
		repository.save(department);
	}

	public void deleteDepartment(short id) {
		repository.deleteById(id);
	}

	public boolean isDepartmentExistsByID(short id) {
		return repository.existsById(id);
	}

	public boolean isDepartmentExistsByName(String name) {
		return repository.existsByName(name);
	}
}
