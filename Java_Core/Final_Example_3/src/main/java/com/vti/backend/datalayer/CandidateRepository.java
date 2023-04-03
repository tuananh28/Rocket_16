package com.vti.backend.datalayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.vti.Ultis.jdbcUltis;
import com.vti.entity.ExperienceCandidate.ProSkill;
import com.vti.entity.FresherCandidate.GraduationRank;

public class CandidateRepository implements ICandidateRepository {
	private jdbcUltis jdbc;

	public CandidateRepository() throws FileNotFoundException, IOException {
		// TODO Auto-generated constructor stub
		jdbc = new jdbcUltis();
	}

	public boolean isCandidateIfExists(String email) throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM `Candidate` WHERE Email = (?)";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setString(1, email);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			jdbc.disConnection();
			return true;
		} else {
			jdbc.disConnection();
			return false;
		}
	}

	public boolean loginCandidate(String email, String password) throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM `Candidate` WHERE Email = (?) AND Password = (?)";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setString(1, email);
		preparedStatement.setString(2, password);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			jdbc.disConnection();
			return true;
		} else {
			jdbc.disConnection();
			return false;
		}
	}

	public boolean createExperienceCandidate(String firstName, String lastName, String phone, String email,
			 int expInYear, ProSkill proSkill) throws ClassNotFoundException, SQLException {
		String sql = "INSERT INTO `Candidate` (FirstName,LastName,Phone,Email,Password,ExpInYear,ProSkill,	 	Category   	)"
					+"VALUES				  ( 	(?) ,   (?)  , (?) , (?) ,'123456', (?)     ,  (?)   ,'EXPERIENCECANDIDATE');";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setString(1, firstName);
		preparedStatement.setString(2, lastName);
		preparedStatement.setString(3, phone);
		preparedStatement.setString(4, email);
		preparedStatement.setInt(5, expInYear);
		preparedStatement.setString(6, proSkill.toString());
		if (preparedStatement.executeUpdate() == 1) {
			return true;
		}else {
			return false;
		}
	}

	public boolean createFresherCandidate(String firstName, String lastName, String phone, String email,
			GraduationRank graduationRank) throws ClassNotFoundException, SQLException {
		String sql = "INSERT INTO `Candidate` (FirstName,LastName,Phone,Email,Password,GraduationRank,  	 Category    )"
					+"VALUES				  ( 	(?) ,   (?)  , (?) , (?) ,'123456', 	(?)		 , 'FRESHERCANDIDATE')";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setString(1, firstName);
		preparedStatement.setString(2, lastName);
		preparedStatement.setString(3, phone);
		preparedStatement.setString(4, email);
		preparedStatement.setString(7, graduationRank.toString());
		if (preparedStatement.executeUpdate() == 1) {
			jdbc.disConnection();
			return true;
		}else {
			jdbc.disConnection();
			return false;
		}
	}
}
