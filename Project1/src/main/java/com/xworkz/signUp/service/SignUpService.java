package com.xworkz.signUp.service;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;

import com.xworkz.signUp.dto.SignUpDTO;

public interface SignUpService {

	Set<ConstraintViolation<SignUpDTO>> validateAndSave(SignUpDTO signUpDTO);

	default List<SignUpDTO> findAll() {
		return Collections.emptyList();
	}

	default Long findByEmail(String email) {
		return null;
	}

	default Long findByMobile(Long mobile) {
		return null;
	}

	default Long findByUser(String user) {
		return null;
	}
	
	//boolean sendEmail(String emailId);
}
