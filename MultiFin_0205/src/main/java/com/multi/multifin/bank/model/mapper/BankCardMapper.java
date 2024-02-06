package com.multi.multifin.bank.model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.multi.multifin.bank.model.vo.BankCreditCard;
import com.multi.multifin.bank.model.vo.BankDebitCard;

@Mapper
public interface BankCardMapper {
	List<BankCreditCard> selectCreditList(Map<String, String> map);
	int selectCreditCount(Map<String, String> map);
	List<BankCreditCard> selectCreditLotte();
	List<BankCreditCard> selectCreditBC();
	List<BankCreditCard> selectCreditSamsung();
	List<BankCreditCard> selectCreditSinhan();
	List<BankCreditCard> selectCreditWoori();
	List<BankCreditCard> selectCreditHana();
	List<BankCreditCard> selectCreditHyundai();
	List<BankCreditCard> selectCreditKb();
	
	List<BankDebitCard> selectDebitList(Map<String, String> map);
	int selectDebitCount(Map<String, String> map);
	List<BankDebitCard> selectDebitLotte();
	List<BankDebitCard> selectDebitBC();
	List<BankDebitCard> selectDebitSamsung();
	List<BankDebitCard> selectDebitSinhan();
	List<BankDebitCard> selectDebitWoori();
	List<BankDebitCard> selectDebitHana();
	List<BankDebitCard> selectDebitHyundai();
	List<BankDebitCard> selectDebitKb();
}
