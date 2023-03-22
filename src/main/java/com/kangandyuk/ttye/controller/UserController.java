package com.kangandyuk.ttye.controller;

import javax.inject.Inject;

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
		
		return true;
	}
	
}
