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
	
	@Transactional 
	public User loginUser(String username,String password) {
		//User user=new User();
		Session currentSession = entityManager.unwrap(Session.class);
		Query<User> query =  currentSession.createQuery("from User where userName="+username+"and "+"userPassword="+password,User.class);
		User user = query.getSingleResult();
		return user;
	}
	
	@Transactional
	public User authenticateUser(String username) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<User> query =  currentSession.createQuery("from User where userName="+username,User.class);
		User user = query.getSingleResult();
		return user;
	}
}