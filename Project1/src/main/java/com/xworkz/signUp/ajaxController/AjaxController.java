package com.xworkz.signUp.ajaxController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.xworkz.signUp.dto.SignUpDTO;
import com.xworkz.signUp.service.SignUpService;

import lombok.extern.slf4j.Slf4j;

@EnableWebMvc
@RestController
@Slf4j
@RequestMapping("/")
public class AjaxController {
	
	@Autowired
	private SignUpService service;
	
	public AjaxController() {
		log.info("Created" + this.getClass().getSimpleName());
	}
	
	@GetMapping(value = "/email/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
	  public String onEmail(@PathVariable String  email) {
		Long dbEmail = this.service.findByEmail(email);
		System.err.println(dbEmail);
		
		if (dbEmail == 0) {
			System.err.println("Running in equals condition");
			return "";
		}else {
			return "Email id exit";
		}
	}
	
	@GetMapping(value = "/mobile/{number}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String onMobile(@PathVariable Long number) {
		Long dbNumber = this.service.findByMobile(number);
		System.err.println(dbNumber);

		if (dbNumber == 0) {
			System.err.println("Running in equals condition");
			return "";

		} else {
			return "Mobile Number exsist";
		}
	
	}
	
	@GetMapping(value = "/dto", produces = MediaType.APPLICATION_JSON_VALUE)
	public SignUpDTO signUpDTO() {
		SignUpDTO dto =new SignUpDTO();
		dto.setUserId("@1234");
		dto.setEmail("ganeshkp1998@gamil.com");
		dto.setMobile(8147772043L);
		System.out.println(dto);
		return dto;
	}
	
	
	

}
