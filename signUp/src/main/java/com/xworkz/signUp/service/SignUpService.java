package com.xworkz.signUp.service;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;

import com.xworkz.signUp.dto.SignUpDto;

public interface SignUpService {

	public Set<ConstraintViolation<SignUpDto>> validateAndSave(SignUpDto dto);
	
	default List<SignUpDto> findAll() {
		return Collections.emptyList();
	}
	
	
	}

    