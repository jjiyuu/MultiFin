package com.multi.multifin.home.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.multifin.common.util.PageInfo;
import com.multi.multifin.home.model.mapper.HomeMapper;
import com.multi.multifin.home.model.vo.Home;
import com.multi.multifin.home.model.vo.MarkerParsing;


@Service
public class HomeService {

	@Autowired(required=false)
	private HomeMapper mapper;

	public List<Home> searchHomeList(Map<String, Object> map){
		return mapper.selectHomeList(map);
	}

	public List<Home> searchHomeBylocatin(Map<String, Object> map) {
		return mapper.selectHomeBylocatin(map);
	}
	
	public int getHomeCount(Map<String, Object> map) {
		return mapper.selectHomeCount(map);
	}
	public List<Home> selectHomeInfo(String map) {
		return mapper.selectHomeInfo(map);
	}
	
	public List<MarkerParsing> selectHomeByXY(Map<String, Object> map) {
		return mapper.selectHomeByXY(map);
	}
	
	public List<Home> searchHomeBylocatin2(PageInfo pageInfo, Map<String, Object> map) {
		map.put("limit", "" + pageInfo.getListLimit());
		map.put("offset", "" + (pageInfo.getStartList() - 1));
		return mapper.selectHomeBylocatin2(map);
	}
}
