package com.vti.backend.bussinesslayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.vti.backend.datalayer.CandidateRepository;
import com.vti.entity.ExperienceCandidate.ProSkill;
import com.vti.entity.FresherCandidate.GraduationRank;

public class CandidateService implements ICandidateService{
	CandidateRepository candidateRepository;
	public CandidateService() throws FileNotFoundException, IOException {
		// TODO Auto-generated constructor stub
		candidateRepository = new CandidateRepository();
	}
	public boolean isCandidateIfExists(String email) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return candidateRepository.isCandidateIfExists(email);
	}

	public boolean loginCandidate(String email, String password) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return candidateRepository.loginCandidate(email, password);
	}

	public boolean createExperienceCandidate(String firstName, String lastName, String phone, String email,
			int expInYear, ProSkill proSkill) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return candidateRepository.createExperienceCandidate(firstName, lastName, phone, email, expInYear, proSkill);
	}

	public boolean createFresherCandidate(String firstName, String lastName, String phone, String email,
			GraduationRank graduationRank) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return candidateRepository.createFresherCandidate(firstName, lastName, phone, email, graduationRank);
	}

}
