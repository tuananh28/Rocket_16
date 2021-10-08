package com.vti.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LoginInfoDTO {
	private short id;
	
	private String email;

	private String fullname;

	private String role;

	private String status;
	
}
