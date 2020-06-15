package com.mazebank.mazebank.repository;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mazebank.mazebank.entity.User;

@Repository
public class UserRepository {

	@Autowired
	EntityManager entityManager;
	
	@Transactional
	public User getUser(int id) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		Query<User> query =  currentSession.createQuery("from User where userstoreId="+id,User.class);
		User user = query.getSingleResult();
		return user;
	}
}
