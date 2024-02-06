package com.multi.multifin.investedstock.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.multi.multifin.investedstock.model.mapper.InvestedStockMapper;
import com.multi.multifin.investedstock.model.vo.InvestedStock;

@Service
public class InvestedStockService {
	
	@Autowired
	private InvestedStockMapper mapper;
	// 체결 내역 가져오기
	public List<InvestedStock> getInvestedStockList(Map<String, String> param) {
		return mapper.selectInvestedStockList(param);
	}
	// 체결 내역 최신으로 두개만 가져오기
	public List<InvestedStock> getInvestedStockList2(Map<String, String> param) {
		return mapper.selectInvestedStockLimit2(param);
	}
	// 매수/매도 클릭 시 insert
	@Transactional(rollbackFor = Exception.class)
	public int saveInvestedStock(InvestedStock investedStock) {
		int result = 0;
		if (investedStock.getOrderNum() == 0) {
			result = mapper.insertInvestedStock(investedStock);
		}
		return result;
	}
	
	
	
	// 나의 체결 내역에서 TotalPrice 만 뽑아오기
	public List<Integer> getTotalPrice(Map<String, String> param) {
		return mapper.selectTotalPrice(param);
	}
	
}
