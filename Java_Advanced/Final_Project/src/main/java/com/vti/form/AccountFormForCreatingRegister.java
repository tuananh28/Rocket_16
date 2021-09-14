package com.vti.form;

import lombok.Data;

@Data
public class AccountFormForCreatingRegister {
	private String email;
	private String username;
	private String fullname;
//	private short departmentId;
//	private short positionId;
	private String password;

}
