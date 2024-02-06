package com.multi.multifin.investedstock.model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.multi.multifin.investedstock.model.vo.InvestedStock;

@Mapper
public interface InvestedStockMapper {
	List<InvestedStock> selectInvestedStockList(Map<String, String> param);	// 체결 내역 가져오기
	List<InvestedStock> selectInvestedStockLimit2(Map<String, String> param); // 체결 내역 최신으로 두개만 가져오기
	
	List<Integer> selectTotalPrice(Map<String, String> param);
	int insertInvestedStock(InvestedStock investedStock);	// 매수/매도 클릭 시 insert
}
