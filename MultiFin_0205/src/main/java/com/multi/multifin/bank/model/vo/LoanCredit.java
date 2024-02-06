package com.multi.multifin.bank.model.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoanCredit {
	private int		loanCreditNo 			; //			int primary key auto_increment, -- 일련번호
	private String 	dclsMonth 				; //		varchar(6),	-- 공시 제출월 [YYYYMM]
	private String 	finCoNo 				; //			varchar(10),	-- 금융회사코드
	private String 	korCoNm 				; //					varchar(50),	-- 금융회사 명
	private String 	finPrdtCd 				; //		varchar(50),	-- 금융상품코드
	private String 	finPrdtNm 				; //		varchar(100),	-- 금융상품명
	private String 	joinWay 				; //				varchar(300),	-- 가입방법
	private String 	crdtPrdtType 			; //			varchar(10),	-- 	대출종류 코드
	private String 	crdtPrdtTypeNm 		; //							varchar(100),	-- 	대출종류명	
	private String 	cbName 					; //		varchar(50), 	-- 	CB 회사명
	private Date 	dclsStrtDay 			; //						DATETIME,	-- 공시 시작일
	private String 	dclsEndDay 			; //			varchar(13),	-- 공시 종료일
	private Date 	finCoSubmDay 			; //				DATETIME,	-- 금융회사 제출일 [YYYYMMDDHH24MI]
    
	private char 	crdtLendRateType 		; //						char(1),	-- 금리구분 코드
	private String 	crdtLendRateTypeNm 	; //						varchar(10), 	-- 금리구분
	private double 	crdtGrad1 				; //			float,	-- 900점 초과 [소수점 2자리]
	private double 	crdtGrad4 				; //		decimal(5, 2),	-- 801~900점 [소수점 2자리]
	private double 	crdtGrad5 				; //		decimal(5, 2),	-- 701~800점 [소수점 2자리]
	private double 	crdtGrad6 				; //			decimal(5, 2),	-- 601~700점 [소수점 2자리]
	private double 	crdtGradAvg 			; //			decimal(5, 2)	-- 평균 금리 [소수점 2자리]
}
