package com.multi.multifin.account.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Account {
	// 계좌 정보
	private int aNum             ;	//계좌 일련번호(PK 구별 용)
	private String account       ;	//계좌번호
	private int mNo              ;	//회원 고유번호
	private int totalAsset       ;	//보유 자산
	private int won              ;	//보유 중인 한화
	private long totalProfit     ;	//평가 손익
}
