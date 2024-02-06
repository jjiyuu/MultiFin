package com.multi.multifin.bank.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.multifin.bank.model.mapper.BankDepsitSavingMapper;
import com.multi.multifin.bank.model.vo.BankDeposit;
import com.multi.multifin.bank.model.vo.BankSaving;
import com.multi.multifin.common.util.PageInfo;

@Service
public class BankDepsitSavingService {
	@Autowired
	private BankDepsitSavingMapper mapper;
	
	public List<BankDeposit> selectDepositList(){
		return mapper.selectDepositList();
	}
	
	public List<BankDeposit> selectDepositListAll(String param){
		return mapper.selectDepositListAll(param);
	}
	
	public int getDepositCountAll(Map<String, String> param) {
		return mapper.selectDepositCountAll(param);
	}
	
	public List<BankDeposit> selectDepositListUnique(PageInfo pageInfo, Map<String, String> param){
		param.put("limit", "" + pageInfo.getListLimit());
		param.put("offset", "" + (pageInfo.getStartList() - 1));
		return mapper.selectDepositListUnique(param);
	}
	
	public int getDepositCountUnique(Map<String, String> param) {
		return mapper.selectDepositCountUnique(param);
	}
	
	public List<BankSaving> selectSavingList(){
		return mapper.selectSavingList();
	}
	
	public List<BankSaving> selectSavingListAll(String param){
		return mapper.selectSavingListAll(param);
	}
	
	public int getSavingCountAll(Map<String, String> param) {
		return mapper.selectSavingCountAll(param);
	}
	
	public List<BankSaving> selectSavingListUnique(PageInfo pageInfo, Map<String, String> param){
		param.put("limit", "" + pageInfo.getListLimit());
		param.put("offset", "" + (pageInfo.getStartList() - 1));
		return mapper.selectSavingListUnique(param);
	}
	
	public int getSavingCountUnique(Map<String, String> param) {
		return mapper.selectSavingCountUnique(param);
	}
}
