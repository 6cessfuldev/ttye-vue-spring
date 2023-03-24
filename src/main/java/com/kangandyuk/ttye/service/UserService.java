package com.kangandyuk.ttye.service;

import javax.servlet.http.HttpSession;

import com.kangandyuk.ttye.domain.UserVO;

public interface UserService {

	boolean isExistedId(String id);

	boolean register(UserVO user);

	UserVO isUser(String id, String pw);

	int checkPartner(String id, HttpSession session);

	boolean waiting(String id, HttpSession session);

	boolean matching(String id, HttpSession session);

}
