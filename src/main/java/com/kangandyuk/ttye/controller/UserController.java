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
	
	@GetMapping("isExistedId")
	public boolean alreadyIdGET(String id) {
		
		System.out.println(">>> controller already method");
		System.out.println(id);
		boolean isExistedId = usv.isExistedId(id);
		System.out.println(isExistedId);
		return isExistedId;
	}
	
	@PostMapping("register")
	public boolean registerPOST(@RequestBody UserVO user) {
		
		System.out.println(">>> controller register method");
		System.out.println(user.toString());
		boolean register = usv.register(user);
		
		return register;
	}
	
	@PostMapping("login")
	public boolean loginPOST(@RequestBody UserVO user, HttpServletRequest req) {
		
		System.out.println(">>> controller login method");
		System.out.println("login id >>> " + user.getId());
		System.out.println("login pw >>> " + user.getPw());
		
		UserVO loginUser = usv.isUser(user.getId(), user.getPw());
		
		if(loginUser != null) {
			HttpSession session = req.getSession();
			session.setAttribute("user", loginUser);
			return true;
			
		} else {
			return false;
		}
		
	}
	
	@GetMapping("isLoggedIn")
	public boolean isLoggedInGET(HttpServletRequest req) {
		
		HttpSession session = req.getSession();
		
		if(session.getAttribute("user") == null) {
			return false;
		}
		
		UserVO user = (UserVO)session.getAttribute("user");
		
		if(user != null) {
			return true;
		} else {
			return false;
		}
	}
	
	@GetMapping("isMatched")
	public boolean isMatchedGET(HttpServletRequest req) {
		
		if(!isLoggedInGET(req)) {
			return false;
		}
		
		HttpSession session = req.getSession();
		UserVO user = (UserVO)session.getAttribute("user");
		
		if(user.getStatus() == 3) {
			return true;
		} else {
			return false;
		}
		
	}
	
	@GetMapping("checkPartner")
	public int checkPartnerGET(String id, HttpSession session) {
		
		int check = usv.checkPartner(id, session);

		return check;
	}
	
	@PostMapping("waiting")
	public boolean waitngPOST(@RequestBody String id, HttpSession session) {
		
		boolean waiting = usv.waiting(id, session);
		
		return waiting;
	}
	
	@PostMapping("matching")
	public boolean matchingPOST(@RequestBody String id, HttpSession session) {
		
		boolean matching = usv.matching(id, session);
		
		return matching;
	}
}
