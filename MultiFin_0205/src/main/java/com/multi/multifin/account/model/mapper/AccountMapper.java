package com.multi.multifin.account.model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.multi.multifin.account.model.vo.Account;

@Mapper
public interface AccountMapper {
	List<Account> selectAccountList(Map<String, String> param);
	
	/*계좌 생성코드*/
	Account getMyAccount(String id);
	int insertAccount(int mNo);
	int updateAccount(int mNo);
}
