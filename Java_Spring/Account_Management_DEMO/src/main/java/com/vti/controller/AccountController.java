package com.vti.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.dto.AccontDto;
import com.vti.entity.Account;
import com.vti.form.AccountFormForCreating;
import com.vti.form.AccountFormForUpdating;
import com.vti.service.IAccountService;

@RestController
@RequestMapping(value = "api/v1/accounts")
@CrossOrigin("*")
public class AccountController {

	@Autowired
	private IAccountService accountService;

	@GetMapping()
	public ResponseEntity<?> getAllAccount() {
		List<Account> entities = accountService.getAllAccount();

		List<AccontDto> dtos = new ArrayList<>();

		// convert entities --> dtos
		for (Account account : entities) {
			AccontDto dto = new AccontDto(account.getId(), account.getEmail(), account.getUsername(),
					account.getFullname(), account.getDepartment().getName(),
					account.getPosition().getName().toString(), account.getCreateDate());
			dtos.add(dto);
		}

		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getAccountByID(@PathVariable(name = "id") short id) {
		Account account = accountService.getAccountById(id);
		AccontDto dto = new AccontDto(account.getId(), account.getEmail(), account.getUsername(), account.getFullname(),
				account.getDepartment().getName(), account.getPosition().getName().toString(), account.getCreateDate());
		return new ResponseEntity<AccontDto>(dto, HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<?> createDepartment(@RequestBody AccountFormForCreating form) {
		accountService.createAccount(form);
		return new ResponseEntity<String>("Create successfully!", HttpStatus.CREATED);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<?> updateDepartment(@PathVariable(name = "id") short id,@RequestBody AccountFormForUpdating form) {
		accountService.updateAccount(id, form);
		return new ResponseEntity<String>("Update successfully!", HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteAccount(@PathVariable(name = "id") short id) {
		accountService.deleteAccount(id);
		return new ResponseEntity<String>("Delete successfully!", HttpStatus.OK);
	}

}
