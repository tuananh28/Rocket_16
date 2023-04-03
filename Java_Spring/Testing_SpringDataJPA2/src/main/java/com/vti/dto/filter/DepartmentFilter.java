package com.vti.dto.filter;

public class DepartmentFilter {

	private Short minID;
	private Short maxID;

	public DepartmentFilter() {
	}

	public Short getMinID() {
		return minID;
	}

	public void setMinID(Short minID) {
		this.minID = minID;
	}

	public Short getMaxID() {
		return maxID;
	}

	public void setMaxID(Short maxID) {
		this.maxID = maxID;
	}

}
