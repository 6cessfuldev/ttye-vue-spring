package com.kangandyuk.ttye.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kangandyuk.ttye.domain.DiaryVO;
import com.kangandyuk.ttye.repository.DiaryDAO;

@Service
public class DiaryServiceImpl implements DiaryService {

	@Inject
	private DiaryDAO ddao;

	@Override
	public boolean register(DiaryVO newDiary) {
		return ddao.insertDiary(newDiary);
	}
}
