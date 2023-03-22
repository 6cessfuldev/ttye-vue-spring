package com.kangandyuk.ttye.service;

import javax.inject.Inject;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.kangandyuk.ttye.domain.UserVO;
import com.kangandyuk.ttye.repository.UserDAO;

@Service
public class UserServiceImpl implements UserService {
	
	@Inject
	private UserDAO udao;
	@Inject
	PasswordEncoder passwordEncoder;

	@Override
	public boolean alreadyId(String id) {
		
		UserVO user = udao.selectUserById(id);
		
		if(user == null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean register(UserVO user) {
		
		String pw = user.getPw();
		String encodePw = passwordEncoder.encode(pw);
		user.setPw(encodePw);
		
		return udao.insertUser(user);
	}

	@Override
	public UserVO isUser(String id, String pw) {
		
		System.out.println(">>> UserServiceImpl isUser");
		UserVO user = udao.selectUserById(id);
		System.out.println(id);
		
		if(user == null) {
			return null;			
		}
		
		System.out.println(user.toString());
		System.out.println(pw);
		System.out.println(user.getPw());
		
		if(passwordEncoder.matches(pw, user.getPw())) {
			return user;
		} else {
			return null;
		}
	}

}
