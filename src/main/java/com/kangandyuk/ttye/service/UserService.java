package com.kangandyuk.ttye.service;

import com.kangandyuk.ttye.domain.UserVO;

public interface UserService {

	boolean alreadyId(String id);

	boolean register(UserVO user);

}
