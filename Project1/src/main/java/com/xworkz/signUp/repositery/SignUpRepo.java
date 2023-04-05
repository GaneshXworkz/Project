package com.xworkz.signUp.repositery;

import java.util.Collections;
import java.util.List;

import com.xworkz.signUp.Entity.EntityDto;



public interface SignUpRepo {

	boolean save(EntityDto entity);

	default List<EntityDto> findAll() {
		return Collections.emptyList();
	}

	default Long findByUser(String user) {
		return null;
	}
default Long findByEmail(String email) {
	return null;
}

default Long findByMobile(Long mobile) {
	return null;
}

}
