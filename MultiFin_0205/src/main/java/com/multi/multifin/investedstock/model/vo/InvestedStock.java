package com.multi.multifin.investedstock.model.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class InvestedStock {
	// 모의 투자에서 매수 및 매매한 주식의 정보
	private int orderNum        ;	//주문번호
	private int mNo              ;	//멤버 일련번호 - 어떤 멤버가 매수/매도 하였는지
	private int sNo              ;	//주식 일련번호 - 어떤 주식을 매수/매도 하였는지
	private int aNum             ;	//계좌 일련번호 - 어떤 계좌로 매수/매도 했는지
	private Date orderDt         ;	//처리 날짜
	private String stockCode     ;	//종목코드
	private String stockNum      ;	//종목명
	private String tradeStat     ;	// 구분(매수 OR 매도)
	private int price            ;	//가격
	private int cnt              ;	//수량
	private long totalPrice      ;	// 구매하는 총 금액
}