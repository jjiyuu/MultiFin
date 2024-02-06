package com.multi.multifin.stock.model.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StockPriceIndex {
	                             
	private String stockType 	;	//타입
	private Date stockDate 	;	//날짜
    private String fin 		    ;	//종가
	private String open 		 ;	//오픈가
	private String highLevel    ;	//고가
	private String lowLevel		 ;  //저가
	private String tradingVolume;	//거래량
	private String changePercent;	//변동
	
}
