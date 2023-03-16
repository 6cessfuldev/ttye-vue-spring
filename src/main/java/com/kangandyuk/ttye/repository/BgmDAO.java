package com.kangandyuk.ttye.repository;

import java.util.List;

import com.kangandyuk.ttye.domain.BgmVO;

public interface BgmDAO {

	int insert(BgmVO bgm);

	List<BgmVO> selectList();

}
