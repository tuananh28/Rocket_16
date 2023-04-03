package com.vti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vti.form.AccountFormForCreatingRegister;
import com.vti.service.IAccountService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api/v1/registration")
@Validated
public class RegisterController {

	@Autowired
	private IAccountService accountService;

	@PostMapping()
	public ResponseEntity<?> createUser(@RequestBody AccountFormForCreatingRegister form) {

		// create User
		accountService.createAccountRegister(form);

		return new ResponseEntity<>("We have sent an email. Please check email to active account!", HttpStatus.CREATED);
	}

	@GetMapping("/activeUser")
	// validate: check exists, check not expired
	public ResponseEntity<?> activeUserViaEmail(@RequestParam String token) {

		// active user
		accountService.activeUser(token);

		return new ResponseEntity<>("Active success!", HttpStatus.OK);
	}

	// resend confirm
	@GetMapping("/userRegistrationConfirmRequest")
	// validate: email exists, email not active
	public ResponseEntity<?> sendConfirmRegistrationViaEmail(@RequestParam String email) {

		accountService.sendConfirmUserRegistrationViaEmail(email);

		return new ResponseEntity<>("We have sent an email. Please check email to active account!", HttpStatus.OK);
	}

}
