package com.multi.multifin.bank.model.vo;

import java.math.BigInteger;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankSaving {
	private int			bankSavingNo;				 // int primary key auto_increment, -- 일련번호
	private String 		dclsMonth;					 // varchar(6), -- 공시 제출월 [YYYYMM]
	private String 		finCoNo;					 // varchar(10), -- 금융회사 코드
	private String 		korCoNm;					 // varchar(20), -- 금융회사명
	private String 		finPrdtCd;				 // varchar(100), -- 금융상품 코드
	private String 		finPrdtNm;				 // varchar(100), -- 금융 상품명
	private String 		joinWay;					 // varchar(100), -- 가입 방법
	private String 		mtrtInt;					 // varchar(300), -- 만기 후 이자율
	private String 		spclCnd;				 	 // varchar(300), -- 우대조건
	private char 		joinDeny;					 // char(1), -- 가입제한 Ex) 1:제한없음, 2:서민전용, 3:일부제한"
	private String 		joinMember;				 // varchar(100), -- 가입대상
	private String 		etcNote;					 // varchar(300), -- 기타 유의사항
	private BigInteger 	maxLimit;					 // bigint, -- 최고한도
	private Date 		dclsStrtDay; 				 // DATETIME, -- 공시 시작일
	private String 		dclsEndDay; 				 // varchar(11), -- 공시 종료일
	private Date 		finCoSubmDay;			 // DATETIME, -- 금융회사 제출일 [YYYYMMDDHH24MI]

	private String intrRateType; // varchar(5), -- 저축 금리 유형
	private String intrRateTypeNm; // varchar(5), -- 저축 금리 유형명
	private String rsrvType; // char(1), -- 적립 유형
	private String rsrvTypeNm; // varchar(5), -- 적립 유형명
	private String saveTrm; // varchar(3), -- 저축 기간 [단위: 개월]
	private double intrRate; // int, -- 저축 금리 [소수점 2자리]
	private double intrRate2; // int -- 최고 우대금리 [소수점 2자리]
	private String logoUrl; 
	
}
