package com.xworkz.signUp.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class DtoAbstract {
	
 private String createdBy;
 
 private LocalDateTime createddate;
 
 private String updateBy;
 
 private LocalDateTime updateDate;

}
