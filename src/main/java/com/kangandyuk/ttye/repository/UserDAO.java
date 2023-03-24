package com.kangandyuk.ttye.repository;

import com.kangandyuk.ttye.domain.UserVO;

public interface UserDAO {

	UserVO selectUserById(String id);

	boolean insertUser(UserVO user);

	int updateUserStatus(UserVO user);

}
