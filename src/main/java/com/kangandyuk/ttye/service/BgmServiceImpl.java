package com.kangandyuk.ttye.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kangandyuk.ttye.domain.BgmVO;
import com.kangandyuk.ttye.domain.PagingVO;
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
	public List<BgmVO> getList(String id) {
		return bdao.selectList(id);
	}
	
	@Override
	public List<BgmVO> getListWithPaging(PagingVO paging, String id) {
		return bdao.selectListWithPaging(paging, id);
	}

	@Override
	public int getTotalCount(String id) {
		return bdao.selectTotalCount(id);
	}

	@Override
	public int remove(BgmVO bgm) {
		return bdao.delete(bgm);
	}
	

}
