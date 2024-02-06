package com.multi.multifin.bank.model.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoanMortgage {
	private int 	loanMortgageNo 			; //					int primary key auto_increment, -- 일련번호
	private String 	dclsMonth 				; //			varchar(10), -- 공시 제출월 [YYYYMM]
	private String 	finCoNo 				; //			varchar(10),	-- 금융회사코드
	private String 	korCoNm 				; //				varchar(50),	-- 금융회사 명
	private String 	finPrdtCd 			; //			varchar(20),	-- 금융상품코드
	private String 	finPrdtNm 			; //						varchar(100),	-- 금융상품명
	private String 	joinWay				; //			 varchar(300),	-- 가입방법
    private String 	loanInciExpn 			; //					varchar(300),	-- 대출 부대비용
    private String 	erlyRpayFee 			; //							varchar(300),	-- 중도상환 수수료
    private String 	dlyRate 				; //			varchar(300),	-- 연체 이자율
    private String 	loanLmt				; //			 varchar(100),	-- 대출한도
	private Date 	dclsStrtDay 			; //			DATETIME,	-- 공시 시작일
	private String 	dclsEndDay 			; //						varchar(13),	-- 공시 종료일
	private Date 	finCoSubmDay 		; //						DATETIME,	-- 금융회사 제출일 [YYYYMMDDHH24MI]
   
	private String	mrtgType 				; //						varchar(1),	-- 담보유형 코드
	private String 	mrtgTypeNm 			; //					varchar(10),	-- 담보유형
	private String 	rpayType 				; //					varchar(1),	-- 대출상환유형 코드
	private String 	rpayTypeNm 			; //					varchar(10),	-- 대출상환유형**
	private String 	lendRateType 			; //						varchar(1),	-- 대출금리유형 코드
	private String 	lendRateTypeNm 		; //						varchar(10),	-- 대출금리유형
	private double 	lendRateMin 			; //					decimal(5, 2),	-- 대출금리_최저 [소수점 2자리]
	private double 	lendRateMax 			; //							decimal(5, 2),	-- 대출금리_최고 [소수점 2자리]
	private double 	lendRateAvg			; //				decimal(5, 2)	-- 전월 취급 평균금리 [소수점 2자리]
}
