package com.kangandyuk.ttye.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserVO {

	private String id;
	private String pw;
	private String userName;
	private String email;
	
}
