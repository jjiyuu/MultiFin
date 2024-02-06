package com.multi.multifin.bank.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.multifin.bank.model.mapper.BankCompanyMapper;
import com.multi.multifin.bank.model.vo.BankCompany;
import com.multi.multifin.common.util.PageInfo;

@Service
public class BankCompanyService {
	@Autowired
	private BankCompanyMapper mapper;
	
	public List<BankCompany> selectCompanyList(PageInfo pageInfo, Map<String, String> param){
		param.put("limit", "" + pageInfo.getListLimit());
		param.put("offset", "" + (pageInfo.getStartList() - 1));
		return mapper.selectCompanyList(param);
	}
	
	public int getCompanyCount(Map<String, String> param) {
		return mapper.selectCompanyCount(param);
	}
	
	public List<BankCompany> selectLogoList(Map<String, String> param){
		return mapper.selectLogoList(param);
	}
}
