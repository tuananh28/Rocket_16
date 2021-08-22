package com.vti.repository;

import java.util.List;

import com.vti.entity.Department;
import com.vti.filter.FilterDepartment;
import com.vti.utils.Paging;
import com.vti.utils.Sorting;

public interface IDepartmentRepository {

	public List<Department> getAllDepartments(Paging paging, Sorting sorting, FilterDepartment filter, String search);

	public Department getDepartmentByID(short id);

	public Department getDepartmentByName(String name);

	public void createDepartment(Department department);

	public void updateDepartment(short id, String newName);

	public void updateDepartment(Department department);

	public void deleteDepartment(short id);

	public boolean isDepartmentExistsByID(short id);

	public boolean isDepartmentExistsByName(String name);

}
