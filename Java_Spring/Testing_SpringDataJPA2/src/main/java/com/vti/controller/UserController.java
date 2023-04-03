package com.vti.controller;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.dto.UserDTO;
import com.vti.entity.User;
import com.vti.service.IUserService;

@RestController
@RequestMapping(value = "api/v1/users")
public class UserController {

	@Autowired
	private IUserService userService;

	@GetMapping()
	public Page<UserDTO> getAllUsers(Pageable pageable) {
		Page<User> pageEntity = userService.getAllUsers(pageable);

		Page<UserDTO> pageDto = pageEntity.map(new Function<User, UserDTO>() {
			@Override
			public UserDTO apply(User user) {
				UserDTO userDTO = new UserDTO(
						user.getId(), 
						user.getUserName(), 
						user.getEmail(), 
						user.getFirstName(), 
						user.getLastName(), 
						user.getFullName(), 
						user.getRole());
				return userDTO;
			}
		});

		return pageDto;
	}

}
