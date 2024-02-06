package com.multi.multifin.stock.model.vo;

import java.math.BigInteger;
import java.util.Date;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StockPrice {
	private int sno 		;			//	일련번호
	private Date basDt 		;			//	기준일. 기준 일자 
	private int srtnCd 		;			//	단축코드
	private int isinCd 		;			//	국제 채권 식별 번호
	private String itmsNm 	;			//	종목의 명칭
	private String mrktCtg 	;			//주식의 시장 구분 (KOSPI/KOSDAQ/KONEX 중 1)
	private String clpr 	;			//정규시장의 매매시간 종료시까지 형성되는 최종가격
	private String vs 		;			//전일 대비 등락
	private String fltRt 	;			//	전일 대비 등락에 따른 비율
	private int mkp 		;			//	정규시장의 매매시간 개시 후 형성되는 최초가격
	private int hipr 		;			//	하루 중 가격의 최고치
	private int lopr 		;			//	하루 중 가격의 최저치
	private int trqu 		;			//	거래량. 체결수량의 누적 합계
	private BigInteger trPrc 		;			//거래대금
	private BigInteger lstgStCnt 	;	//상장주식수
	private BigInteger mrktTotAmt 	;	//시가총액
}
