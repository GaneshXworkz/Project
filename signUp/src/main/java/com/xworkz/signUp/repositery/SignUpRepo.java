package com.xworkz.signUp.repositery;

import java.util.Collections;
import java.util.List;

import com.xworkz.signUp.entityDto.EntityDto;

public interface SignUpRepo {

	boolean save(EntityDto entity);
	
	default List<EntityDto> findAll(){
		return Collections.emptyList();
	}
	
	
	
}
