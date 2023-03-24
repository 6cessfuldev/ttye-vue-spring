package com.kangandyuk.ttye.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kangandyuk.ttye.domain.DiaryVO;
import com.kangandyuk.ttye.domain.UserVO;
import com.kangandyuk.ttye.service.DiaryService;

@RestController
@RequestMapping("diary")
public class DiaryController {
	
	@Inject
	private DiaryService dsv;

	@PostMapping("register")
	public boolean registerPOST(@RequestBody DiaryVO diary, HttpSession session) {
		
		DiaryVO newDiary = new DiaryVO();
		UserVO user = (UserVO)session.getAttribute("user");
		
		newDiary.setContent(diary.getContent());
		newDiary.setId(user.getId());
		
		boolean register = dsv.register(newDiary);
		
		return register;	
	}
}
