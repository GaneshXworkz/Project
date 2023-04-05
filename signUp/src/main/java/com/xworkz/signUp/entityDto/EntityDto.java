package com.xworkz.signUp.entityDto;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import io.smallrye.common.constraint.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name="signUp_table")
@NamedQuery(name = "find",query = "select ent from EntityDto ent")
@NamedQuery(name = "SearchByEmailAndPassword", query = "select ent from EntityDto ent where ent.email=:mail And ent.password=:pswd")
public class EntityDto {
	
	@Id
	@Column(name="C_id")
     private int id;
	 
	@Column(name="C_name")
	 private String name;
	 
	@Column(name="C_email")
	 private String email;
	 
	@Column(name="C_mobilNo")
	 private String mobilNo;
	 
	@Column(name="C_password")
	 private String password;
	 
	@Column(name="C_conformPassword")
	 private String conformPassword;
	 
	
	

	@Column(name="C_createdBy")
	 private String createdBy;
	 
	@Column(name="C_createddate")
	 private LocalDateTime createddate;
	 
	@Column(name="C_updateBy")
	 private String updateBy;
	 
	@Column(name="C_updateDate")
	 private LocalDateTime updateDate;

}
