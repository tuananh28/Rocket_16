package com.vti.entity;

public class Project {
	private int ProjectID;
	private String ProjectName;
	private int TeamSize;
	
	public Project(String projectName, int teamSize) {
		super();
		this.ProjectName = projectName;
		this.TeamSize = teamSize;
	}

	public int getProjectID() {
		return ProjectID;
	}

	public void setProjectID(int projectID) {
		ProjectID = projectID;
	}

	public String getProjectName() {
		return ProjectName;
	}

	public void setProjectName(String projectName) {
		ProjectName = projectName;
	}

	public int getTeamSize() {
		return TeamSize;
	}

	public void setTeamSize(int teamSize) {
		TeamSize = teamSize;
	}
	
}
