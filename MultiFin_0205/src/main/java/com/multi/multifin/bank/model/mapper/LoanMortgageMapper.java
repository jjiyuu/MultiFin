package com.multi.multifin.bank.model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.multi.multifin.bank.model.vo.LoanMortgage;

@Mapper
public interface LoanMortgageMapper {
	List<LoanMortgage> selectLoanMortgageList();
	List<LoanMortgage> selectLoanMortgageListAll(String map);
	int selectLoanMortgageCountAll(Map<String, String> map);
	List<LoanMortgage> selectLoanMortgageListUnique(Map<String, String> map);
	int selectLoanMortgageCountUnique(Map<String, String> map);
}
