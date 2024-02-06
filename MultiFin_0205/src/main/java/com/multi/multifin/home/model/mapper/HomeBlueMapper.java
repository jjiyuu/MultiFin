package com.multi.multifin.home.model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.multi.multifin.home.model.vo.Aptdetail;
import com.multi.multifin.home.model.vo.OfficeDetail;
import com.multi.multifin.home.model.vo.RemainDetail;

@Mapper
public interface HomeBlueMapper {
	
	List<Aptdetail> searchAptList(Map<String, Object> map);
	List<Aptdetail> searchAptList2(Map<String, Object> map);
	List<Aptdetail> searchAptList3(Map<String, Object> map);
	List<Aptdetail> searchAptListName(String name);
	int selectAptCount(Map<String, Object> map);
	List<OfficeDetail> searchOfficeList(Map<String, Object> map);
	int selectOfficeCount(Map<String, Object> map);
	List<RemainDetail> searchRemainList(Map<String, Object> map);
	int selectRemainCount(Map<String, Object> map);

}
