package com.xworkz.signUp.repositery;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.signUp.dto.SignUpDto;
import com.xworkz.signUp.entityDto.EntityDto;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class SignUpRepoImpl implements SignUpRepo{

	@Autowired
	private EntityManagerFactory entityManagerFactory;
	
	public SignUpRepoImpl() {
		log.info("Created SignUpRepoImpl");
	}
	
	@Override
	public boolean save(EntityDto entity) {
		log.info("Running save method.....!");
		
		EntityManager entityManager=this.entityManagerFactory.createEntityManager();
		
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		entityTransaction.begin();
		
		entityManager.persist(entity);
		
		entityTransaction.commit();
		
		entityManager.close();
		
		return true;
	}
	
	@Override
	public List<EntityDto> findAll() {
		EntityManager em = this.entityManagerFactory.createEntityManager();
		try {
			Query query = em.createNamedQuery("find");
			List<EntityDto> list = query.getResultList();
			log.info("Total list size found in repo" + list.size());
			return list;
			
		} finally {
			em.close();
		}
	}

}
