package com.vti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.vti.dto.filter.DepartmentFilter;
import com.vti.entity.Department;
import com.vti.repository.IDepartmentRepository;
import com.vti.specification.DepartmentSpecification;

@Service
@Transactional
public class DepartmentService implements IDepartmentService {

	@Autowired
	private IDepartmentRepository repository;

	@SuppressWarnings("deprecation")
	public Page<Department> getAllDepartments(Pageable pageable, DepartmentFilter filter, String search) {
		DepartmentSpecification minIdSpecification = new DepartmentSpecification("id", ">=", filter.getMinID());

		DepartmentSpecification maxIdSpecification = new DepartmentSpecification("id", "<=", filter.getMaxID());

		DepartmentSpecification searchSpecification = new DepartmentSpecification("name", "LIKE", search);

		Specification<Department> where = null;

		if (filter.getMinID() != null && filter.getMinID() != 0) {
			where = minIdSpecification;
		}

		if (filter.getMaxID() != null && filter.getMaxID() != 0) {
			if (where == null) {
				where = maxIdSpecification;
			} else {
				where = where.and(maxIdSpecification);
			}
		}

		if (!StringUtils.isEmpty(search)) {
			if (where == null) {
				where = searchSpecification;
			} else {
				where = where.and(searchSpecification);
			}
		}

		return repository.findAll(where, pageable);
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

	public void updateDepartment(short id, String newName) {
		Department department = getDepartmentByID(id);
		department.setName(newName);
		repository.save(department);
	}

	public void updateDepartment(Department department) {
		repository.save(department);
	}

	public void deleteDepartment(short id) {
		repository.deleteById(id);
	}

	public void deleteDepartments(List<Short> ids) {
		repository.deleteByIds(ids);
	}

	public boolean isDepartmentExistsByID(short id) {
		return repository.existsById(id);
	}

	public boolean isDepartmentExistsByName(String name) {
		return repository.existsByName(name);
	}

}
