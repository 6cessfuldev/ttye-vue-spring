package com.kangandyuk.ttye.repository;

import java.util.List;

import com.kangandyuk.ttye.domain.DiaryVO;

public interface DiaryDAO {

	int insertDiary(DiaryVO newDiary);

	List<DiaryVO> selectList(String diary_date);

}
