package com.kangandyuk.ttye.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@CrossOrigin(origins = "*")
@Controller
@RequestMapping("board/")
public class BoardController {

	@ResponseBody
	@GetMapping("get-board-list.do")
	public String getBoardList() {
		return "hello";
	}
}
