package com.multi.multifin.bank.model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.multi.multifin.bank.model.vo.LoanRentHouse;

@Mapper
public interface LoanRentHouseMapper {
	List<LoanRentHouse> selectLoanRentHouseList();
	List<LoanRentHouse> selectLoanRentHouseListAll(String map);
	int selectLoanRentHouseCountAll(Map<String, String> map);
	List<LoanRentHouse> selectLoanRentHouseListUnique(Map<String, String> map);
	int selectLoanRentHouseCountUnique(Map<String, String> map);
}
