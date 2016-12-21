package com.greenfinch.signup.service;

import org.springframework.stereotype.Service;

import com.greenfinch.signup.model.User;

@Service
public interface UserService {

	boolean isValidUser(String userName);

	void addUser(User user);

}
