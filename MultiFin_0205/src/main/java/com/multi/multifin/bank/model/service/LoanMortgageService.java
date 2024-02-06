package com.multi.multifin.bank.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.multifin.bank.model.mapper.LoanMortgageMapper;
import com.multi.multifin.bank.model.vo.LoanMortgage;
import com.multi.multifin.common.util.PageInfo;

@Service
public class LoanMortgageService {
	@Autowired
	private LoanMortgageMapper mapper;
	
	public List<LoanMortgage> selectLoanMortgageList(){
		return mapper.selectLoanMortgageList();
	}
	
	public List<LoanMortgage> selectLoanMortgageListAll(String map){
		return mapper.selectLoanMortgageListAll(map);
	}
	
	public int selectLoanMortgageCountAll(Map<String, String> map) {
		return mapper.selectLoanMortgageCountAll(map);
	}
	
	public List<LoanMortgage> selectLoanMortgageListUnique(PageInfo pageInfo, Map<String, String> param){
		param.put("limit", "" + pageInfo.getListLimit());
		param.put("offset", "" + (pageInfo.getStartList() - 1));
		return mapper.selectLoanMortgageListUnique(param);
	}
	
	public int selectLoanMortgageCountUnique(Map<String, String> map) {
		return mapper.selectLoanMortgageCountUnique(map);
	}
}
