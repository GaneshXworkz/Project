package com.xworkz.signUp.service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Properties;
import java.util.Set;

import javax.mail.Authenticator;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysql.cj.Session;
import com.xworkz.signUp.Entity.EntityDto;
import com.xworkz.signUp.dto.SignUpDTO;
import com.xworkz.signUp.repositery.SignUpRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SignUpServiceImpl implements SignUpService {
	
	@Autowired
	private SignUpRepo repository;
	
	
	public SignUpServiceImpl() {
		System.out.println("Created"+this.getClass().getSimpleName());
	}
	
	private Set<ConstraintViolation<SignUpDTO>> validate(SignUpDTO signUpDto) {
		ValidatorFactory validationFactory = Validation.buildDefaultValidatorFactory();
		Validator validator = validationFactory.getValidator();
		Set<ConstraintViolation<SignUpDTO>> vailation = validator.validate(signUpDto);
		return vailation;
	}
	
	@Override
	public Set<ConstraintViolation<SignUpDTO>> validateAndSave(SignUpDTO signUpDTO) {
		Long emailCount = this.repository.findByEmail(signUpDTO.getEmail());
		Long userCount = this.repository.findByUser(signUpDTO.getUserId());
		Long mobileCount = this.repository.findByMobile(signUpDTO.getMobile());
		
		if (emailCount == 0 && userCount == 0 && mobileCount == 0)
		{
			if (signUpDTO.getPassword().equals(signUpDTO.getPassword()))
			{
				Set<ConstraintViolation<SignUpDTO>> violations = validate(signUpDTO);
				
				if (violations != null && !violations.isEmpty())
				{
					log.info("there is Violation in dto");
					return violations;
				}
				else {
					
					EntityDto entity = new EntityDto();
					entity.setCreatedBy(signUpDTO.getUserId());
					entity.setCreatedDate(LocalDateTime.now());
					BeanUtils.copyProperties(signUpDTO, entity);
					boolean saved = this.repository.save(entity);
					//boolean sent = this.sendMail(signUpDTO.getEmail());
					log.info("Saved in Entity-" + saved);
					//log.info("Email sent -:" + sent);

				}
			}
			else
			{
				log.error("Password must be same");
			}
		}
		else
		{
			log.error("User already exsist");
		}
		return Collections.emptySet();
	}
	
	
	@Override
	public Long findByEmail(String email) {
		Long emailcount = this.repository.findByEmail(email);
		log.error("Find  by Email");
		return emailcount;
	}

	@Override
	public Long findByMobile(Long mobile) {
		Long mobilecount = this.repository.findByMobile(mobile);
		return mobilecount;
	}

	@Override
	public Long findByUser(String user) {
		Long userCount = this.repository.findByUser(user);
		return userCount;
	}

	/*@Override
	public boolean sendEmail(String emailId) {
		String portNumber="587";
		String hostName="smtp.office365.com";
		String formEmail="ganeshKp1998@gamil.com";
		String password="Dvg@1998";
		String to = emailId;
		
		Properties prop=new Properties();
		prop.put("mail.smtp.host", hostName);
		prop.put("mail.smtp.port", portNumber);
		prop.put("mail.smtp.sttartls.enable", true);
		prop.put("mail.debug", true);
		prop.put("mail.smtp.auth", true);
		prop.put("mail.transport.protocal", "smtp");
		
	   javax.mail.Session session=javax.mail.Session.getInstance(prop,new Authenticator() {
	}
	   
			   )
		*/
		
		
		
		
		
	
	
   
	
	
}
