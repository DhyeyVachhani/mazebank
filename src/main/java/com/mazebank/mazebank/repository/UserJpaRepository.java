package com.mazebank.mazebank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mazebank.mazebank.entity.User;

@Repository
public interface UserJpaRepository extends JpaRepository<User, Integer> {

    User findByUserName(String userName);
}
