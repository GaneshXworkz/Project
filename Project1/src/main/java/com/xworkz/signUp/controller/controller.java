package com.xworkz.signUp.controller;

import java.time.LocalDateTime;
import java.util.Set;


import javax.validation.ConstraintViolation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.signUp.dto.SignUpDTO;
import com.xworkz.signUp.service.SignUpService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/")
@Slf4j
public class controller {
	
	@Autowired
	private SignUpService service;
	
	public controller() {
		System.out.println("Created"+this.getClass().getSimpleName());
	}

	@GetMapping("/register")
	public String onSave() {
		log.info("GetMapping onSave in SignUpController");
		return "signUp";
	}

	@PostMapping("/register")
	public String OnSave(SignUpDTO dto, Model model) {
		log.info("PostMapping onSave in SignUpController" + dto);
		dto.setCreatedBy(dto.getUserId());
		dto.setCreatedDate(LocalDateTime.now());
		if (dto != null) {
			Set<ConstraintViolation<SignUpDTO>> violations = this.service.validateAndSave(dto);
			if (violations.isEmpty()) {
				System.out.println("no violations found, go to success page");
				model.addAttribute("dto", dto);
			
				return "index";
			}

			log.info("Violations found " + dto);
			model.addAttribute("errors", violations);
			model.addAttribute("dto", dto);
		}
		return "signUp";
	}
	
	
}
