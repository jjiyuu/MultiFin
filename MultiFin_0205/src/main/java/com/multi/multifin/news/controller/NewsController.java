package com.multi.multifin.news.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.multi.multifin.news.naverapi.NaverSearchAPI;
import com.multi.multifin.news.naverapi.News;

@RequestMapping("/news")
@Controller

public class NewsController {

	public static List<News> newsList1 = null;
	public static List<News> newsList2 = null;
	public static List<News> newsList3 = null;

	@RequestMapping("/newsMain")
	public String newsMain(Model model, 
			@RequestParam(required = false) String searchValue) {
		if (newsList1 == null) {
			initNews();
		}
		
		if(searchValue != null) {
			List<News> mainList = NaverSearchAPI.getNewsList(searchValue, 5, 1);
			model.addAttribute("newsList1", mainList); //  뉴스메인에서 검색결과
			model.addAttribute("newsList2", mainList); //  예시
		}else {
			model.addAttribute("newsList1", newsList1);
			model.addAttribute("newsList2", newsList2);
		}
		
		model.addAttribute("newsList3", newsList3); //  한줄뉴스

		return "news/newsMain";
	}

	public void initNews() {
		newsList1 = NaverSearchAPI.getNewsList("경제", 10, 1);
		//	뉴스 검색	
		newsList2 = NaverSearchAPI.getNewsList("지진", 3, 1);
		// 중간 뉴스
		newsList3 = NaverSearchAPI.getNewsList("부동산", 5, 1);
		//	한줄뉴스
	}
}
