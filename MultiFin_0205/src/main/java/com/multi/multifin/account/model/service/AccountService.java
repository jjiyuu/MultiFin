package com.multi.multifin.account.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.multifin.account.model.mapper.AccountMapper;
import com.multi.multifin.account.model.vo.Account;
import com.multi.multifin.investedstock.model.vo.InvestedStock;

@Service
public class AccountService {
	
	@Autowired
	private AccountMapper mapper;
	
	public List<Account> getAccountList(Map<String, String> param) {
		return mapper.selectAccountList(param);
	}
	
	
	/*계좌 생성코드*/
	public int saveInvestedStock(int mNo) {
		return mapper.insertAccount(mNo);
	}
	
	public int updateAccount(int mNo) {
		return mapper.updateAccount(mNo);
	}
	
	public Account getMyAccount(String id) {
		return mapper.getMyAccount(id);
	}
	
}
