package com.xworkz.signUp.controller;

import java.util.Set;

import javax.validation.ConstraintViolation;

import org.jboss.jandex.PositionBasedTypeTarget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.signUp.dto.SignUpDto;
import com.xworkz.signUp.service.SignUpService;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Controller
@RequestMapping("/")
@Slf4j
public class SignUpController {
	
  @Autowired
  private SignUpService signUpService;
 
  @GetMapping("/signUp")
	public String onBank(Model model) {

	  log.info("Running on BankOn get method..");
		
		return "SignUp";
	}
  
  
  

	@PostMapping("/signUp")
	public String onBank(SignUpDto dto, Model model) {

		log.info("Running Bank Post methos " + dto);
		
		
   List<SignUpDto>  list=this.signUpService.findAll();
   
  	
		if(dto.getPassword().equals(dto.getConformPassword()))
		{
		
		Set<ConstraintViolation<SignUpDto>> violations = signUpService.validateAndSave(dto);

		 for(SignUpDto signUpDto : list) {
			   if (dto.getEmail().equals(signUpDto.getEmail()))
			   {
					model.addAttribute("emailError", "Email already Existed");
					model.addAttribute("error", violations);


					return "SignUp";
				}
			   else if(dto.getMobilNo().equals(signUpDto.getMobilNo())) 
			   {
				   model.addAttribute("mobilNo","Mobial Number already Existes");
					model.addAttribute("error", violations);

				   return "SignUp"; 
			   }
			   
		   }
		
		if (violations.isEmpty())
		{
			log.info("No violation in controller go to success page...");

			return "index";
		} 
		else
		{
			
			model.addAttribute("error", violations);
			model.addAttribute("SignUpDto", dto);
			

			log.info("violation is controller");

			

		}
		return "SignUp";
	
		}
		else 
		{
			model.addAttribute("password","Password and ConfPsw must be same");
			model.addAttribute("SignUpDto", dto);
		}
       return "SignUp";
	}
	
	//**************************************************************************************
	@GetMapping("/logIn")
    public String logIn(@RequestParam String email,@RequestParam String password, Model model, SignUpDto dto) {
		System.out.println("Log In running......!");
		
		
		List<SignUpDto> list=this.signUpService.validateLogInUsingEmailAndPassword(email, password);
		
		if(email!=null && !email.isEmpty() && password!=null && !password.isEmpty()) {
		
			for(SignUpDto signUpDto:list) {
				if(dto.getEmail().equals(signUpDto.getEmail())&& dto.getPassword().equals(signUpDto.getPassword())) {
					
					return "success";
				}
				else {
					
					model.addAttribute("message","Email Or password is Wrong");
				}
				return "logIn";
			}
			
			
			
		}else {
			model.addAttribute("email","please enter Email Id");
			model.addAttribute("password","please Enter password");
		}
		return "logIn";
	}
	
//*********************************************************************************************************************	
	
}
