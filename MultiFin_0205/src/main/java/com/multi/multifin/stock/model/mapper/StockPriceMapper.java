package com.multi.multifin.stock.model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.multi.multifin.stock.model.vo.StockPrice;

@Mapper
public interface StockPriceMapper {
	List<StockPrice> KospiList(Map<String, String> map);
	List<StockPrice> KosdaqList(Map<String, String> map);
	List<StockPrice> KospiRankingTop(Map<String, String> map);
	List<StockPrice> KosdaqRankingTop(Map<String, String> map);
	StockPrice selectListByno(int no);
	List<StockPrice> stockMoreList(int no);
	List<StockPrice> selectStockList(Map<String, String> map);
	int selectStockCount(Map<String, String> map);
	List<StockPrice>stockPriceList(String name);
	
	List<StockPrice> selectAllStock(Map<String, String> map); // 모든 주식을 조회 (시가총액이 높은 순서대로!)
	List<StockPrice> selectRecStock(Map<String, String> map); // 추천 주식 조회
	int selectAllStockCount(Map<String, String> map);	// 조회된 주식의 개수
}
