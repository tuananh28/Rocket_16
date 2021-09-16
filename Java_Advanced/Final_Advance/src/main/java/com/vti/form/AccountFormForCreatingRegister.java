package com.vti.form;

import lombok.Data;

@Data
public class AccountFormForCreatingRegister {
	private String email;
	private String fullname;
	private String username;
	private String password;
	private short departmentId;
	private short positionId;

}
