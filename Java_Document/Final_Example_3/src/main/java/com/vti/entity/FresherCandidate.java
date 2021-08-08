package com.vti.entity;

public class FresherCandidate extends Candidate{
	private GraduationRank graduationRank;
	
	public enum GraduationRank{
		EXCELLENCE, GOOD, FAIR, POOR
	}

	public FresherCandidate(String firstName, String lastName, String phone, String email, String password,
			Category category, GraduationRank graduationRank) {
		super(firstName, lastName, phone, email, password, category);
		this.graduationRank = graduationRank;
	}

	public GraduationRank getGraduationRank() {
		return graduationRank;
	}

	public void setGraduationRank(GraduationRank graduationRank) {
		this.graduationRank = graduationRank;
	}

	@Override
	public String toString() {
		return "FresherCandidate [graduationRank=" + graduationRank + "]";
	}
	
}
