package com.multi.multifin.stock.model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.multi.multifin.stock.model.vo.FundProductInfo;

@Mapper
public interface FundProductInfoMapper {
	List<FundProductInfo> selectFundProduct(Map<String, String> map); // 펀드상품 리스트 출력 (주식형)
	int selectFundCount(Map<String, String> map); // 펀드 리스트의 개수 (주식형)
	 
	List<FundProductInfo> selectFundProduct02(Map<String, String> map); // 펀드상품 리스트 출력 (채권형)
	int selectFundCount02(Map<String, String> map); // 펀드 리스트의 개수 (채권형)
	
	List<FundProductInfo> selectFundProduct03(Map<String, String> map); // 펀드상품 리스트 출력 (혼합형)
	int selectFundCount03(Map<String, String> map); // 펀드 리스트의 개수 (혼합형)
	
	List<FundProductInfo> selectFundProduct04(Map<String, String> map); // 펀드상품 리스트 출력 (재간접)
	int selectFundCount04(Map<String, String> map); // 펀드 리스트의 개수 (재간접)
}
