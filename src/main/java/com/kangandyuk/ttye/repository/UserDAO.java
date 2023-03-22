package com.kangandyuk.ttye.repository;

import com.kangandyuk.ttye.domain.UserVO;

public interface UserDAO {

	UserVO selectAlreadyId(String id);

	boolean insertUser(UserVO user);

}
