package com.multi.multifin.bank.model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.multi.multifin.bank.model.vo.LoanCredit;

@Mapper
public interface LoanCreditMapper {
	List<LoanCredit> selectLoanCreditList();
	List<LoanCredit> selectLoanCreditListAll(String map);
	int selectLoanCreditCountAll(Map<String, String> map);
	List<LoanCredit> selectLoanCreditListUnique(Map<String, String> map);
	int selectLoanCreditCountUnique(Map<String, String> map);
	
}
