package com.kangandyuk.ttye.repository;

import java.util.List;

import com.kangandyuk.ttye.domain.BgmVO;
import com.kangandyuk.ttye.domain.PagingVO;

public interface BgmDAO {

	int insert(BgmVO bgm);

	List<BgmVO> selectList(String id);

	List<BgmVO> selectListWithPaging(PagingVO paging, String id);

	int selectTotalCount(String id);

	int delete(BgmVO bgm);
}
