package com.vti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.entity.Position;
import com.vti.repository.IPositionRepository;

@Service
public class PositionService implements IPositionService{
	@Autowired
	private IPositionRepository positionRepository;

	@Override
	public List<Position> getAllPosition() {
		// TODO Auto-generated method stub
		return positionRepository.findAll();
	}
}
