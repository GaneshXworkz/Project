package com.xworkz.signUp.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.signUp.dto.SignUpDto;
import com.xworkz.signUp.entityDto.EntityDto;
import com.xworkz.signUp.repositery.SignUpRepo;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class SignUpServiceImpl implements SignUpService {

	@Autowired
	private SignUpRepo signUpRepo;
	
	
	public SignUpServiceImpl() {
		log.info("Created SignUpServiceImpl");
	}

	@Override
	public Set<ConstraintViolation<SignUpDto>> validateAndSave(SignUpDto dto) {
		log.info("Created Valdate And Save...");
		ValidatorFactory validatorFactory=Validation.buildDefaultValidatorFactory();
		
		Validator validator=validatorFactory.getValidator();
		
		Set<ConstraintViolation<SignUpDto>> constraintViolations=validator.validate(dto);
		
		if(constraintViolations!=null &&!constraintViolations.isEmpty()) {
			
			log.error("vaiolation Exites ,return violation"+dto);
			
			return constraintViolations;
		}
		else
		{
			log.info("violation does not existes,data is success... ");
			
			EntityDto entityDto=new EntityDto();
			
			//BeanUtils.copyProperties(dto, entityDto);
			entityDto.setName(dto.getName());
			entityDto.setEmail(dto.getEmail());
			entityDto.setMobilNo(dto.getMobilNo());
			entityDto.setPassword(dto.getPassword());
			entityDto.setConformPassword(dto.getConformPassword());
			
			
			boolean saved=signUpRepo.save(entityDto);
			
			log.info("Created :"+saved);
			
			return Collections.emptySet();
		}
				
		
	}
	
	
	
	@Override
	public List<SignUpDto> findAll() {
		List<EntityDto> userEntity = this.signUpRepo.findAll();
		List<SignUpDto> lists = new ArrayList<SignUpDto>();
		for (EntityDto entity : userEntity) {
			SignUpDto dto = new SignUpDto();
			//BeanUtils.copyProperties(entity, dto);
			
			 // dto.setName(entity.getName());
			  dto.setEmail(entity.getEmail());
			  dto.setMobilNo(entity.getMobilNo()); 
			 // dto.setPassword(entity.getMobilNo());
			  //dto.setConformPassword(entity.getConformPassword());
			 
			lists.add(dto);

		}
		return lists;
	}
	
	
	
	@Override
	public List<SignUpDto> validateLogInUsingEmailAndPassword(String email, String password) {
		System.out.println("Running Serach By Email And Password");
		List<EntityDto> login=this.signUpRepo.LogInUsingEmailAndPassword(email, password);
		List<SignUpDto> dtos=new ArrayList<>();
		
		if(email!=null && !email.isEmpty()&& password!=null && !password.isEmpty()) {
		    for(EntityDto entityDto :login) {
		    	SignUpDto dto=new SignUpDto();
		    	BeanUtils.copyProperties(entityDto, dto);
		    	dtos.add(dto);
		    	
		    } 
		return dtos;
			
			
		}else {
			System.out.println("no data found in db");
			return Collections.emptyList();
		}
		
		
		
		
	}
	
	

}
