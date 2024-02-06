package com.multi.multifin.bank.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.multifin.bank.model.mapper.BankCardMapper;
import com.multi.multifin.bank.model.vo.BankCreditCard;
import com.multi.multifin.bank.model.vo.BankDebitCard;
import com.multi.multifin.common.util.PageInfo;

@Service
public class BankCardService {
	@Autowired
	private BankCardMapper mapper;
	
	public List<BankCreditCard> selectCreditList(PageInfo pageInfo, Map<String, String> param){
		param.put("limit", "" + pageInfo.getListLimit());
		param.put("offset", "" + (pageInfo.getStartList() - 1));
		return mapper.selectCreditList(param);
	}
	
	public int getCreditCount(Map<String, String> param) {
		return mapper.selectCreditCount(param);
	}
	
	public List<BankCreditCard> selectCreditLotte(){
		return mapper.selectCreditLotte();
	}
	
	public List<BankCreditCard> selectCreditBC(){
		return mapper.selectCreditBC();
	}
	
	public List<BankCreditCard> selectCreditSamsung(){
		return mapper.selectCreditSamsung();
	}
	
	public List<BankCreditCard> selectCreditSinhan(){
		return mapper.selectCreditSinhan();
	}
	
	public List<BankCreditCard> selectCreditWoori(){
		return mapper.selectCreditWoori();
	}
	
	public List<BankCreditCard> selectCreditHana(){
		return mapper.selectCreditHana();
	}
	
	public List<BankCreditCard> selectCreditHyundai(){
		return mapper.selectCreditHyundai();
	}
	
	public List<BankCreditCard> selectCreditKb(){
		return mapper.selectCreditKb();
	}
	
	public List<BankDebitCard> selectDebitList(PageInfo pageInfo, Map<String, String> param){
		param.put("limit", "" + pageInfo.getListLimit());
		param.put("offset", "" + (pageInfo.getStartList() - 1));
		return mapper.selectDebitList(param);
	}
	
	public int getDebitCount(Map<String, String> param) {
		return mapper.selectDebitCount(param);
	}
	
	public List<BankDebitCard> selectDebitLotte(){
		return mapper.selectDebitLotte();
	}
	
	public List<BankDebitCard> selectDebitBC(){
		return mapper.selectDebitBC();
	}
	
	public List<BankDebitCard> selectDebitSamsung(){
		return mapper.selectDebitSamsung();
	}
	
	public List<BankDebitCard> selectDebitSinhan(){
		return mapper.selectDebitSinhan();
	}
	
	public List<BankDebitCard> selectDebitWoori(){
		return mapper.selectDebitWoori();
	}
	
	public List<BankDebitCard> selectDebitHana(){
		return mapper.selectDebitHana();
	}
	
	public List<BankDebitCard> selectDebitHyundai(){
		return mapper.selectDebitHyundai();
	}
	
	public List<BankDebitCard> selectDebitKb(){
		return mapper.selectDebitKb();
	}
	
}
