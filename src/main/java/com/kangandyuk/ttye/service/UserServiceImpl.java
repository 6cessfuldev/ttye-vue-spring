package com.kangandyuk.ttye.service;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

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
	public boolean isExistedId(String id) {
		
		UserVO user = udao.selectUserById(id);
		
		if(user == null) {
			return false;
		}
		return true;
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

	@Override
	public int checkPartner(String id, HttpSession session) {
		
		UserVO partner = udao.selectUserById(id);
		UserVO user = (UserVO)session.getAttribute("user");
		
		if(partner == null) {
			return 1;
		} else if((partner.getStatus() == 2 || partner.getStatus() == 3) && !partner.getPartner().equals(user.getId())) {
			return 2;
		} else if(partner.getStatus() == 1 && partner.getPartner() == null) {
			return 3;
		} else if(partner.getStatus() == 2 && partner.getPartner().equals(user.getId())) {
			return 4;
		} else {
			return 0;
		}
		
	}

	@Override
	public boolean waiting(String id, HttpSession session) {
		
		UserVO user = (UserVO)session.getAttribute("user");
		
		user.setStatus(2);
		user.setPartner(id);
		
		int isOk = udao.updateUserStatus(user);
		
		return isOk > 0 ? true : false ;
	}

	@Override
	public boolean matching(String id, HttpSession session) {
		
		UserVO user = (UserVO)session.getAttribute("user");
		UserVO partner = udao.selectUserById(id);
		
		user.setStatus(3);
		user.setPartner(id);
		partner.setStatus(3);
		
		int isOk = udao.updateUserStatus(user);
		int isOk2 = udao.updateUserStatus(partner);
		
		return isOk * isOk2 > 0 ? true : false ;
	}

}
