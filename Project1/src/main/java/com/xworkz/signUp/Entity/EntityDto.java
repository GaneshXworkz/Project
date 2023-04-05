package com.xworkz.signUp.Entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name ="SignUp_project")
@NamedQuery(name = "find",query = "select ent from EntityDto ent")
@NamedQuery(name = "userId",query = "select count(*) from  EntityDto ent where ent.userId=:userBy")
@NamedQuery(name = "emailId",query = "select count(*) from  EntityDto ent where ent.email=:emailBy")
@NamedQuery(name = "mobileId",query = "select count(*) from  EntityDto ent where ent.mobile=:mobileBy")
public class EntityDto {
	
	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name ="userId")
	private String userId;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "mobile")
	private Long mobile;
	
	@Column(name = "password")
	private String password;

	@Column(name ="createdBy")
	private String createdBy;
	
	@Column(name = "createdDate")
	private LocalDateTime createdDate;
	
	@Column(name ="updatedBy")
	private String updatedBy;
	
	@Column(name ="updatedDate")
	private LocalDateTime updatedDate;

}
