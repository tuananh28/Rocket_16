package com.vti.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.dto.AccountDto;
import com.vti.entity.Account;
import com.vti.service.IAccountService;

@RestController
@RequestMapping(value = "api/v1/accounts")
@CrossOrigin("*")
public class AccountController {
	@Autowired
	private IAccountService accountService;
	@GetMapping()
	public ResponseEntity<?> getAllAccount(){
		List<Account> entities = accountService.getAllAccounts();

		List<AccountDto> dtos = new ArrayList<>();

		// convert entities --> dtos
		for (Account account : entities) {
			AccountDto dto = new AccountDto(account.getId(), account.getEmail(), account.getUsername(),
					account.getFullname(), account.getDepartment().getName(),
					account.getPosition().getName().toString(), account.getCreateDate());
			dtos.add(dto);
		}

		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}
}
