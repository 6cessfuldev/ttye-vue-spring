package com.kangandyuk.ttye.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kangandyuk.ttye.domain.UserVO;
import com.kangandyuk.ttye.repository.UserDAO;

@Service
public class UserServiceImpl implements UserService {
	
	@Inject
	private UserDAO udao;

	@Override
	public boolean alreadyId(String id) {
		
		UserVO user = udao.selectAlreadyId(id);
		System.out.println(user.getId());
		if(user.getId() == null || user.getId() == "") {
			return true;
		}
		return false;
	}

	@Override
	public boolean register(UserVO user) {
		
		return udao.insertUser(user);
	}

}
