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

import com.vti.dto.PositionDto;
import com.vti.entity.Position;
import com.vti.service.IPositionService;

@RestController
@RequestMapping(value = "api/v1/positions")
@CrossOrigin("*")
public class PositionController {

	@Autowired
	private IPositionService positionService;

	@GetMapping()
	public ResponseEntity<?> getAllPossitons() {
		List<Position> entities = positionService.getAllPosition();

		List<PositionDto> dtos = new ArrayList<>();

		for (Position entity : entities) {
			PositionDto dto = new PositionDto(entity.getId(), entity.getName().toString());
			dtos.add(dto);
		}

		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}

}
