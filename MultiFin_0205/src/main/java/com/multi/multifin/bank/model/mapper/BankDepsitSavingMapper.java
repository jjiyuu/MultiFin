package com.multi.multifin.bank.model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.multi.multifin.bank.model.vo.BankDeposit;
import com.multi.multifin.bank.model.vo.BankSaving;

@Mapper
public interface BankDepsitSavingMapper {
	List<BankDeposit> selectDepositList();
	List<BankDeposit> selectDepositListAll(String map);
	int selectDepositCountAll(Map<String, String> map);
	List<BankDeposit> selectDepositListUnique(Map<String, String> map);
	int selectDepositCountUnique(Map<String, String> map);
	List<BankSaving> selectSavingList();
	List<BankSaving> selectSavingListAll(String map);
	int selectSavingCountAll(Map<String, String> map);
	List<BankSaving> selectSavingListUnique(Map<String, String> map);
	int selectSavingCountUnique(Map<String, String> map);
}
