package com.vti.entity;

public class ExperienceCandidate extends Candidate{
	private int ExpInYear;
	private ProSkill proSkill;
	public enum ProSkill{
		DEV,TEST,JAVA,SQL
	}
	public ExperienceCandidate(String firstName, String lastName, String phone, String email, String password,
			Category category, int expInYear, ProSkill proSkill) {
		super(firstName, lastName, phone, email, password, category);
		ExpInYear = expInYear;
		this.proSkill = proSkill;
	}
	public int getExpInYear() {
		return ExpInYear;
	}
	public void setExpInYear(int expInYear) {
		ExpInYear = expInYear;
	}
	public ProSkill getProSkill() {
		return proSkill;
	}
	public void setProSkill(ProSkill proSkill) {
		this.proSkill = proSkill;
	}
	@Override
	public String toString() {
		return "ExperienceCandidate [ExpInYear=" + ExpInYear + ", proSkill=" + proSkill + "]";
	}
	
}
