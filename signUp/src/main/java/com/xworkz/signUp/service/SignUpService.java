package com.xworkz.signUp.service;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;

import com.xworkz.signUp.dto.SignUpDto;
import com.xworkz.signUp.entityDto.EntityDto;

public interface SignUpService {

	public Set<ConstraintViolation<SignUpDto>> validateAndSave(SignUpDto dto);
	
	default List<SignUpDto> findAll() {
		return Collections.emptyList();
	}
	
	default List<SignUpDto> validateLogInUsingEmailAndPassword (String email,String password) {
    	
    	return Collections.emptyList();
    	
    }
	
	
	}

    