package com.vti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vti.entity.Account;
import com.vti.entity.UserStatus;

public interface UserRepository extends JpaRepository<Account, Integer>, JpaSpecificationExecutor<Account> {

	public boolean existsByUserName(String username);

	public boolean existsByEmail(String email);
	
	@Query("	SELECT 	status 		"
			+ "	FROM 	Account 		"
			+ " WHERE 	email = :email")
	public UserStatus findStatusByEmail(@Param("email") String email);

	public Account findByUserName(String name);
	
	public Account findByEmail(String email);
}
