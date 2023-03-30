package com.kangandyuk.ttye.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kangandyuk.ttye.domain.DiaryVO;
import com.kangandyuk.ttye.repository.DiaryDAO;

@Service
public class DiaryServiceImpl implements DiaryService {

	@Inject
	private DiaryDAO ddao;

	@Override
	public int register(DiaryVO newDiary) {
		return ddao.insertDiary(newDiary);
	}

	@Override
	public List<DiaryVO> list(String month) {
		return ddao.selectList(month);
	}
}
