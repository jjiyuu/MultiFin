package com.multi.multifin.bank.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankCompany {
	private int		bankCompanyNo 		; //			int primary key auto_increment,
	private String 	dclsMonth 			; //			varchar(6), -- 공시 제출월 [YYYYMM]
	private String 	finCoNo 			; //			varchar(10), -- 금융회사코드
	private String 	korCoNm 			; //			varchar(30), -- 금융회사 명
	private String 	dclsChrgMan 		; //			varchar(100), -- 공시담당자
	private String 	hompUrl 			; //						varchar(200), -- 홈페이지주소
	private String 	calTel 				; //	varchar(13), -- 콜센터전화번호
	private int 	areaCd 				; //		int, -- 지역구분 | 01~17	
	private String 	areaNm 				; //				varchar(2), -- 지역이름 | 서울, 부산, 대구, 인천, 광주, 대전, 울산, 세종, 경기, 강원, 충북, 충남, 전북, 전남, 경북, 경남, 제주
	private char 	exisYn 				; //		char(1) -- 점포소재여부
	private String  logoUrl;
}
