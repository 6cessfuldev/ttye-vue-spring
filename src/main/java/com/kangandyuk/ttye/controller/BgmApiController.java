package com.kangandyuk.ttye.controller;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kangandyuk.ttye.domain.BgmVO;
import com.kangandyuk.ttye.service.BgmService;

@RestController
@RequestMapping("bgm")
public class BgmApiController {

	@Inject
	private BgmService bsv;
	
	@PostMapping(value="add")
	public String POSTbgm(@RequestBody HashMap<String, Object> param) {
		System.out.println(param.get("videoId"));
		System.out.println(param.get("videoTitle"));
		
		String videoId = (String)param.get("videoId");
		String videoTitle = (String)param.get("videoTitle");
		
		BgmVO bgm = new BgmVO();
		bgm.setVideo_id(videoId);
		bgm.setVideo_title(videoTitle);
		
		int isOk = bsv.register(bgm);
		if(isOk > 0) System.out.println("success");
		
		return "success";
	}
	
	@GetMapping("list")
	public List<BgmVO> GETList(){
	
		List<BgmVO> list = bsv.getList();
		System.out.println(list.size()+" "+list.get(0));
		return list;
	}
}
