package com.vti.controller;

import java.util.List;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vti.dto.AccountDto;
import com.vti.dto.DepartmentDto;
import com.vti.entity.Department;
import com.vti.form.DepartmentFilterForm;
import com.vti.form.DepartmentFormForCreating;
import com.vti.form.DepartmentFormForUpdating;
import com.vti.service.IDepartmentService;

@RestController
@RequestMapping(value = "api/v1/departments")
@CrossOrigin("*")
public class DepartmentController {

	@Autowired
	private IDepartmentService service;

	@GetMapping()
	public ResponseEntity<?> getAllDepartments(
			Pageable pageable, 
			@RequestParam(required = false) String search,
			DepartmentFilterForm filter) {
		Page<Department> entitiesPage = service.getAllDepartments(pageable, search, filter);

		// convert entities --> dtos
		// https://stackoverflow.com/questions/39036771/how-to-map-pageobjectentity-to-pageobjectdto-in-spring-data-rest
		Page<DepartmentDto> dtoPage = entitiesPage.map(new Function<Department, DepartmentDto>() {
			@Override
			public DepartmentDto apply(Department entity) {
				DepartmentDto dto = new DepartmentDto(entity.getId(), entity.getName(),
						new AccountDto(entity.getAuthor().getId(), entity.getAuthor().getFullName()),
						entity.getCreateDate());
				return dto;
			}
		});

		return new ResponseEntity<>(dtoPage, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getDepartmentByID(@PathVariable(name = "id") short id) {

		Department entity = service.getDepartmentByID(id);

		DepartmentDto dto = new DepartmentDto(entity.getId(), entity.getName(),
				new AccountDto(entity.getAuthor().getId(), entity.getAuthor().getFullName()), entity.getCreateDate());

		return new ResponseEntity<>(dto, HttpStatus.OK);
	}

	@GetMapping(value = "/name/{name}/exists")
	public ResponseEntity<?> existsByName(@PathVariable(name = "name") String name) {
		return new ResponseEntity<>(service.isDepartmentExistsByName(name), HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<?> createDepartment(@RequestBody DepartmentFormForCreating form) {
		service.createDepartment(form);
		return new ResponseEntity<String>("Create successfully!", HttpStatus.CREATED);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<?> updateDepartment(@PathVariable(name = "id") short id,
			@RequestBody DepartmentFormForUpdating form) {
		service.updateDepartment(id, form);
		return new ResponseEntity<String>("Update successfully!", HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteDepartment(@PathVariable(name = "id") short id) {
		service.deleteDepartment(id);
		return new ResponseEntity<String>("Delete successfully!", HttpStatus.OK);
	}

	@DeleteMapping
	public ResponseEntity<?> deleteDepartments(@RequestParam(name = "ids") List<Short> ids) {
		service.deleteDepartments(ids);
		return new ResponseEntity<String>("Delete successfully!", HttpStatus.OK);
	}

}
