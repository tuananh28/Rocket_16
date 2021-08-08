package com.vti.backend.presentationlayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import com.vti.backend.bussinesslayer.CandidateService;
import com.vti.entity.ExperienceCandidate.ProSkill;
import com.vti.entity.FresherCandidate.GraduationRank;

public class CandidateController implements ICandidateController {

	CandidateService candidateService;

	public CandidateController() throws FileNotFoundException, IOException {
		// TODO Auto-generated constructor stub
		candidateService = new CandidateService();
	}

	public boolean isCandidateIfExists(String email) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return candidateService.isCandidateIfExists(email);
	}

	public boolean loginCandidate(String email, String password) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return candidateService.loginCandidate(email, password);
	}

	public boolean createExperienceCandidate(String firstName, String lastName, String phone, String email,
			int expInYear, ProSkill proSkill) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return candidateService.createExperienceCandidate(firstName, lastName, phone, email, expInYear, proSkill);
	}

	public boolean createFresherCandidate(String firstName, String lastName, String phone, String email,
			GraduationRank graduationRank) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}
