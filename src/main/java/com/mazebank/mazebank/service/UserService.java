package com.mazebank.mazebank.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.mazebank.mazebank.exception.BadReqestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mazebank.mazebank.entity.User;
import com.mazebank.mazebank.repository.UserJpaRepository;
import com.mazebank.mazebank.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserJpaRepository userJpaRepository;

    public User getUser(int id) {
        return userRepository.getUser(id);
    }

    public List<User> listUser() {
        return userJpaRepository.findAll();
    }

    public User getUserById(int id) {
        Optional<User> optionalUser = userJpaRepository.findById(id);
//        User existingUser;
        if (!optionalUser.isPresent()) {
            throw new BadReqestException("user not found with userId : " + id);
        }
        return optionalUser.get();
    }


    public User createUser(User user) {
        user.setUserTimestamp(new Timestamp(new Date().getTime()));
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setUserPassword(encoder.encode(user.getUserPassword()));
        user.setUserRole('A');
        return userJpaRepository.save(user);
    }

    public User updateUser(User user) {
        Optional<User> existing = userJpaRepository.findById(user.getUserstoreId());
        User existingUser;
        if (!existing.isPresent()) {
            throw new BadReqestException("user not found with userId : " + user.getUserstoreId());
        }
        existingUser = existing.get();
        user.setUserPassword(existingUser.getUserPassword());
        user.setUserTimestamp(existingUser.getUserTimestamp());
        user.setUserRole(existingUser.getUserRole());
        return userJpaRepository.save(user);
    }
}
