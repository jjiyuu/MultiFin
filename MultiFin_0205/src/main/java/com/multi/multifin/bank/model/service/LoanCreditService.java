package com.multi.multifin.bank.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.multifin.bank.model.mapper.LoanCreditMapper;
import com.multi.multifin.bank.model.vo.LoanCredit;
import com.multi.multifin.common.util.PageInfo;

@Service
public class LoanCreditService {
	@Autowired
	private LoanCreditMapper mapper;
	
	public List<LoanCredit> selectLoanCreditList(){
		return mapper.selectLoanCreditList();
	}
	
	public List<LoanCredit> selectLoanCreditListAll(String map){
		return mapper.selectLoanCreditListAll(map);
	}
	
	public int selectLoanCreditCountAll(Map<String, String> map) {
		return mapper.selectLoanCreditCountAll(map);
	}

	public List<LoanCredit> selectLoanCreditListUnique(PageInfo pageInfo, Map<String, String> param){
		param.put("limit", "" + pageInfo.getListLimit());
		param.put("offset", "" + (pageInfo.getStartList() - 1));
		return mapper.selectLoanCreditListUnique(param);
	}

	public int selectLoanCreditCountUnique(Map<String, String> map) {
		return mapper.selectLoanCreditCountUnique(map);
	}
	
	
}
