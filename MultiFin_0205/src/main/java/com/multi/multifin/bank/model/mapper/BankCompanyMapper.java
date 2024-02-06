package com.multi.multifin.bank.model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.multi.multifin.bank.model.vo.BankCompany;

@Mapper
public interface BankCompanyMapper {
	List<BankCompany> selectCompanyList(Map<String, String> map);
	int selectCompanyCount(Map<String, String> map);
	List<BankCompany> selectLogoList(Map<String, String> map);
}
