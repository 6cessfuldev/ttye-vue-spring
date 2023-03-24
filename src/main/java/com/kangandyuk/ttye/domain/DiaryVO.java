package com.kangandyuk.ttye.domain;

import lombok.Data;

@Data
public class DiaryVO {
	
	private int diary_code;
	private String content;
	private String id;
	private String diary_date;
	private String diary_register_date;
	private String diary_update_date;

}
