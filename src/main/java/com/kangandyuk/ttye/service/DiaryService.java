package com.kangandyuk.ttye.service;

import java.util.List;

import com.kangandyuk.ttye.domain.DiaryVO;

public interface DiaryService {

	int register(DiaryVO newDiary);

	List<DiaryVO> list(String month);

}
