package com.vti.controller;

import java.util.List;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vti.dto.DepartmentDTO;
import com.vti.dto.DepartmentForm;
import com.vti.dto.filter.DepartmentFilter;
import com.vti.entity.Department;
import com.vti.service.DepartmentService;

@RestController
@RequestMapping(value = "api/v1/departments")
public class DepartmentController {

	@Autowired
	private DepartmentService service;

	@GetMapping()
	public Page<DepartmentDTO> getAllDepartments(
			Pageable pageable, 
			DepartmentFilter filter,
			@RequestParam(name = "search", required = false) String search) {
		Page<Department> pageEntity = service.getAllDepartments(pageable, filter, search);

		Page<DepartmentDTO> pageDto = pageEntity.map(new Function<Department, DepartmentDTO>() {
			@Override
			public DepartmentDTO apply(Department entity) {
				DepartmentDTO dto = new DepartmentDTO(entity.getId(), entity.getName());
				return dto;
			}
		});

		return pageDto;
	}

	@GetMapping(value = "/{id}")
	public Department getDepartmentByID(@PathVariable(name = "id") short id) {
		return service.getDepartmentByID(id);
	}

	@GetMapping(value = "name")
	public Department getDepartmentByName(@RequestParam(name = "name") String name) {
		return service.getDepartmentByName(name);
	}

	@PostMapping()
	public void createDepartment(@RequestBody DepartmentForm form) {
		Department department = new Department(form.getName());
		service.createDepartment(department);
	}

	@PutMapping(value = "/{id}")
	public void updateDepartment(
			@PathVariable(name = "id") short id, 
			@RequestBody DepartmentForm form) {
		Department department = service.getDepartmentByID(id);
		department.setName(form.getName());
		service.updateDepartment(department);
	}

	@DeleteMapping(value = "/{id}")
	public void deleteDepartment(@PathVariable(name = "id") short id) {
		service.deleteDepartment(id);
	}
	
	@DeleteMapping
	public void deleteDepartments(
			@RequestParam(name = "ids") List<Short> ids) {
		service.deleteDepartments(ids);
	}
	
	
}
