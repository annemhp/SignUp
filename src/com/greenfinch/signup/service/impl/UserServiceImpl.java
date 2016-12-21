package com.greenfinch.signup.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.greenfinch.signup.model.User;
import com.greenfinch.signup.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	RestTemplate rt;

	static final String DB_URL = "https://gfsignup-e1d3f.firebaseio.com/users/";

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Override
	public boolean isValidUser(String userName) {
		String res = rt.getForObject(DB_URL + userName + ".json", String.class);
		return res.equals("null");
	}

	@Override
	public void addUser(User user) {
		rt.put(DB_URL + user.getUserName() + ".json", "\"" + user.getPassword()
				+ "\"");

	}

}
