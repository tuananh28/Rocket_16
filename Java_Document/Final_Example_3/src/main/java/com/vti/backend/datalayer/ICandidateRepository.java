package com.vti.backend.datalayer;

import java.sql.SQLException;

import com.vti.entity.ExperienceCandidate.ProSkill;
import com.vti.entity.FresherCandidate.GraduationRank;

public interface ICandidateRepository {
	public boolean isCandidateIfExists(String email) throws ClassNotFoundException, SQLException;

	public boolean loginCandidate(String email, String password) throws ClassNotFoundException, SQLException;

	public boolean createExperienceCandidate(String firstName, String lastName, String phone, String email,
			int expInYear, ProSkill proSkill) throws ClassNotFoundException, SQLException;

	public boolean createFresherCandidate(String firstName, String lastName, String phone, String email,
			GraduationRank graduationRank) throws ClassNotFoundException, SQLException;
}
