package com.multi.multifin.law.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/law")
@Controller
public class LawController {

	@RequestMapping("/lawMain")
	public String lawMain() {
		return "law/lawMain";
		 // 모델에 데이터를 담고, law/lawMain 뷰를 리턴한다.
	}
	
	@RequestMapping("/lawFAQ")
	public String lawFAQ() {
		return "law/lawFAQ";
		// FAQ 기능 구현
	}
	
}
