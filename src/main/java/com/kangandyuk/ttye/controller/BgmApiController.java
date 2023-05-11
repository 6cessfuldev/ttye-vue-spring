package com.kangandyuk.ttye.controller;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kangandyuk.ttye.domain.BgmVO;
import com.kangandyuk.ttye.domain.PagingVO;
import com.kangandyuk.ttye.domain.UserVO;
import com.kangandyuk.ttye.service.BgmService;

@RestController
@RequestMapping("bgm")
public class BgmApiController {

	@Inject
	private BgmService bsv;
	
	@PostMapping(value="add")
	public String POSTbgm(@RequestBody HashMap<String, Object> param, HttpSession session) {
		System.out.println(param.get("videoId"));
		System.out.println(param.get("videoTitle"));
		
		String videoId = (String)param.get("videoId");
		String videoTitle = (String)param.get("videoTitle");
		UserVO user = (UserVO)session.getAttribute("user");
		
		BgmVO bgm = new BgmVO();
		bgm.setVideo_id(videoId);
		bgm.setVideo_title(videoTitle);
		bgm.setId(user.getId());
		
		int isOk = bsv.register(bgm);
		if(isOk > 0) System.out.println("success");
		
		return "success";
	}
	
	@GetMapping("list")
	public List<BgmVO> GETList(HttpSession session){
	
		UserVO user = (UserVO)session.getAttribute("user");
		
		List<BgmVO> list = bsv.getList(user.getId());

		return list;
	}
	
	@PostMapping("listWithPaging")
	public List<BgmVO> GETListWithPaging(@RequestBody PagingVO paging, HttpSession session){
		System.out.println(paging.toString());
		UserVO user = (UserVO)session.getAttribute("user");
		
		paging.setTotalCount(bsv.getTotalCount(user.getId()));
		paging.makePaging();
		paging.setId(user.getId());
		
		List<BgmVO> list = bsv.getListWithPaging(paging);
		return list;
	}

	@PostMapping("delete")
	public boolean POSTDelete(@RequestBody BgmVO bgm, HttpSession session) {
		System.out.println(bgm.getVideo_id());
		System.out.println(bgm.getVideo_title());
		
		UserVO user = (UserVO)session.getAttribute("user");
		bgm.setId(user.getId());
		
		int isOk = bsv.remove(bgm);
		
		return isOk > 0;
	}



}
