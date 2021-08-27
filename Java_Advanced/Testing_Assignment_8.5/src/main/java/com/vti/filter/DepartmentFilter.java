package com.vti.filter;

public class DepartmentFilter {

	private int minID;

	private int maxID;

	private int minTotalMember;

	public DepartmentFilter() {
	}

	public int getMinID() {
		return minID;
	}

	public void setMinID(int minID) {
		this.minID = minID;
	}

	public int getMaxID() {
		return maxID;
	}

	public void setMaxID(int maxID) {
		this.maxID = maxID;
	}

	public int getMinTotalMember() {
		return minTotalMember;
	}

	public void setMinTotalMember(int minTotalMember) {
		this.minTotalMember = minTotalMember;
	}

}
