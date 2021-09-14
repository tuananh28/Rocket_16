package com.vti.controller;

import java.util.List;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.vti.dto.AccountDTO;
import com.vti.entity.Account;
import com.vti.form.AccountFilter;
import com.vti.form.AccountFormForCreating;
import com.vti.form.AccountFormForUpdating;
import com.vti.service.IAccountService;

@RestController
@RequestMapping(value = "api/v1/accounts")
@CrossOrigin("*")
@Validated
public class AccountController {
	@Autowired
	private IAccountService accountService;

	@GetMapping()
	public ResponseEntity<?> getAllAccount(Pageable pageable, @RequestParam(required = false) String search,
			AccountFilter filter) {
		Page<Account> entities = accountService.getAllAccounts(pageable, search, filter);

		Page<AccountDTO> dtos = entities.map(new Function<Account, AccountDTO>() {
			@Override
			public AccountDTO apply(Account entity) {
				AccountDTO dto = new AccountDTO(entity.getId(), entity.getEmail(), entity.getUsername(),
						entity.getFullname(), entity.getDepartment().getName(),
						entity.getPosition().getName().toString(), entity.getCreateDate());
				return dto;
			}
		});

		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getAccountByID(@PathVariable(name = "id") short id) {
		Account account = accountService.getAccountByID(id);
		AccountDTO dto = new AccountDTO(account.getId(), account.getEmail(), account.getUsername(),
				account.getFullname(), account.getDepartment().getName(), account.getPosition().getName().toString(),
				account.getCreateDate());
		return new ResponseEntity<AccountDTO>(dto, HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<?> createAccount(@RequestBody AccountFormForCreating form) {
		accountService.createAccount(form);
		return new ResponseEntity<String>("Create Successfully !", HttpStatus.CREATED);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<?> updateAccounts(@PathVariable(name = "id") short id,
			@RequestBody AccountFormForUpdating form) {
		accountService.updateAccount(id, form);
		return new ResponseEntity<String>("Update successfully!", HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteAccount(@PathVariable(name = "id") short id) {
		accountService.deleteAccount(id);
		return new ResponseEntity<String>("Delete Successfully !", HttpStatus.OK);
	}

	@DeleteMapping
	public ResponseEntity<?> deleteAccounts(@RequestParam(name = "ids") List<Short> ids) {
		accountService.deleteAccounts(ids);
		return new ResponseEntity<String>("Delete successfully!", HttpStatus.OK);
	}

	@GetMapping(value = "/email/{email}")
	public ResponseEntity<?> existsUserByEmail(@PathVariable(name = "email") String email) {
		// get entity
		boolean result = accountService.existsUserByEmail(email);

		// return result
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@GetMapping(value = "/username/{username}")
	public ResponseEntity<?> existsUserByUsername(@PathVariable(name = "username") String username) {
		// get entity
		boolean result = accountService.existsUserByUsername(username);

		// return result
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}
