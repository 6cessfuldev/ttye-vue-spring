package com.kangandyuk.ttye.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kangandyuk.ttye.domain.UserVO;
import com.kangandyuk.ttye.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {
	
	@Inject
	private UserService usv;
	
	@GetMapping("alreadyId")
	public boolean alreadyIdGET(String id) {
		System.out.println(id);
		boolean alreadyId = usv.alreadyId(id);
		System.out.println(alreadyId);
		return alreadyId;
	}
	
	@PostMapping("register")
	public boolean registerPOST(@RequestBody UserVO user) {
		System.out.println(user.toString());
		boolean register = usv.register(user);
		
		return register;
	}
	
	@PostMapping("login")
	public boolean loginPOST(@RequestBody String id, String pw, HttpServletRequest req) {
		
		System.out.println(id);
		System.out.println(pw);
		
		UserVO isUser = usv.isUser(id, pw);
		
		if(isUser != null) {
			HttpSession session = req.getSession();
			return true;
			
		} else {
			return false;
		}
		
		
	}
	
	@GetMapping("isLoggedIn")
	public boolean isLoggedInGET() {
		return true;
	}
	
}
