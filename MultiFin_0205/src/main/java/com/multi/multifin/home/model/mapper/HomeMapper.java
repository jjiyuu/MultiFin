package com.multi.multifin.home.model.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.multi.multifin.home.model.vo.Home;
import com.multi.multifin.home.model.vo.MarkerParsing;


@Mapper
public interface HomeMapper {

	List<Home> selectHomeList(Map<String, Object> map); 
	List<Home> selectHomeBylocatin(Map<String, Object> map);
	int selectHomeCount(Map<String, Object> map);
	List<Home> selectHomeInfo(String map);
	List<MarkerParsing> selectHomeByXY(Map<String, Object> map);
	List<Home> selectHomeBylocatin2(Map<String, Object> map);
}
