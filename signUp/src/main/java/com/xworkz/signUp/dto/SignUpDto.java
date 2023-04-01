package com.xworkz.signUp.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import io.smallrye.common.constraint.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class SignUpDto implements Serializable{
	
	
	 private int id;
	 
	 @Size(min=4, max=20,message = "character must be min4 amd max 20")
	 private String name;
	 
	 @NotBlank
	 @Size(min = 4, max = 40, message = "email should be greater then 4 and less then 40")
	 private String email;
	 
	 @NotNull
	 @NotBlank
	 private String mobilNo;
	 
	//@Pattern(regexp = "^[a-zA-Z0-9]{6}",message = "the password can contain only charcters and digits size 6")
	 @NotBlank
	 @Size(min = 4, max = 12, message = "password should be greater then 4 and less then 12")
	 private String password;
	 
	 @NotNull
	 @NotBlank	
	 private String conformPassword;
	 
	
	 
	 

}
