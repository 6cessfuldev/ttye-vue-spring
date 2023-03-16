package com.kangandyuk.ttye.service;

import java.util.List;

import com.kangandyuk.ttye.domain.BgmVO;

public interface BgmService {

	int register(BgmVO bgm);

	List<BgmVO> getList();

}
