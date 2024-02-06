package com.multi.multifin.stock.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.multi.multifin.stock.model.vo.StockPriceIndex;


@Mapper
public interface StockPriceIndexMapper {
	
	List<StockPriceIndex> getStockList(String name);
	StockPriceIndex nowStockIndex(String name);
	List<StockPriceIndex> currentStockList(String name);
	/*추가*/
	List<String> stockGraphList(String name);
}
