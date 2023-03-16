package com.kangandyuk.ttye.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kangandyuk.ttye.domain.BgmVO;
import com.kangandyuk.ttye.repository.BgmDAO;

@Service
public class BgmServiceImpl implements BgmService {

	@Inject
	private BgmDAO bdao;
	
	@Override
	public int register(BgmVO bgm) {
	
		return bdao.insert(bgm);
	}

	@Override
	public List<BgmVO> getList() {
		return bdao.selectList();
	}
	
	

}
