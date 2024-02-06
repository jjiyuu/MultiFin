package com.multi.multifin.bank.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.multifin.bank.model.mapper.LoanRentHouseMapper;
import com.multi.multifin.bank.model.vo.LoanRentHouse;
import com.multi.multifin.common.util.PageInfo;

@Service
public class LoanRentHouseService {
	@Autowired
	private LoanRentHouseMapper mapper;
	
	public List<LoanRentHouse> selectLoanRentHouseList(){
		return mapper.selectLoanRentHouseList();
	}
	public List<LoanRentHouse> selectLoanRentHouseListAll(String map){
		return mapper.selectLoanRentHouseListAll(map);
	}

	public int selectLoanRentHouseCountAll(Map<String, String> map) {
		return mapper.selectLoanRentHouseCountAll(map);
	}
	
	public List<LoanRentHouse> selectLoanRentHouseListUnique(PageInfo pageInfo, Map<String, String> param){
		param.put("limit", "" + pageInfo.getListLimit());
		param.put("offset", "" + (pageInfo.getStartList() - 1));
		return mapper.selectLoanRentHouseListUnique(param);
		
	}
	
	public int selectLoanRentHouseCountUnique(Map<String, String> map) {
		return mapper.selectLoanRentHouseCountUnique(map);
	}
}
