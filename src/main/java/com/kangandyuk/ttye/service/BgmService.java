package com.kangandyuk.ttye.service;

import java.util.List;

import com.kangandyuk.ttye.domain.BgmVO;
import com.kangandyuk.ttye.domain.PagingVO;

public interface BgmService {

	int register(BgmVO bgm);

	List<BgmVO> getList(String id);

	List<BgmVO> getListWithPaging(PagingVO paging);

	int getTotalCount(String id);

	int remove(BgmVO bgm);
}
