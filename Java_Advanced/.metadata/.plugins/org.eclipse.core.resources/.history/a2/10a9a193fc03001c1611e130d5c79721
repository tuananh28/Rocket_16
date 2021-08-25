package com.vti.specification;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import com.vti.entity.Department;
import com.vti.filter.DepartmentFilter;

public class DepartmentSpecificationBuilder {
	private DepartmentFilter filter;
	private String search;

	public DepartmentSpecificationBuilder(DepartmentFilter filter, String search) {
		super();
		this.filter = filter;
		this.search = search;
	}

	@SuppressWarnings("deprecation")
	public Specification<Department>build(){
		SearchCriteria seachCriteria = new SearchCriteria("name", "Like", search);
		SearchCriteria minIDCriteria = new SearchCriteria("id", ">", filter.getMinID());
		SearchCriteria maxIDCriteria = new SearchCriteria("id", "<", filter.getMaxID());
		SearchCriteria minTotalMemberCriteria = new SearchCriteria("totalMember", ">", filter.getMinTotalMember());
		Specification<Department> where = null;
		if (!StringUtils.isEmpty(search))
		{
			where = new DepartmentSpecification(seachCriteria);
		}
		if (filter.getMinID() != 0) {
			if (where != null) {
				where = where.and(new DepartmentSpecification(minIDCriteria));
			} else {
				where = new DepartmentSpecification(minIDCriteria);
			}
		}
		if (filter.getMaxID() != 0) {
			if (where != null) {
				where = where.and(new DepartmentSpecification(maxIDCriteria));
			} else {
				where = new DepartmentSpecification(maxIDCriteria);
			}
		}
		if (filter.getMinTotalMember() != 0) {
			if (where != null) {
				where = where.and(new DepartmentSpecification(minTotalMemberCriteria));
			} else {
				where = new DepartmentSpecification(minTotalMemberCriteria);
			}
		}
		return where;
	}
}
