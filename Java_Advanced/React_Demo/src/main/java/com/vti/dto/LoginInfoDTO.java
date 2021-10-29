package com.vti.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LoginInfoDTO {
	private String token;

	private String email;

	private String username;

	private String fullname;

	private String role;

	private String status;

}
