package com.multi.multifin.stock.model.vo;

import java.math.BigInteger;
import java.util.Date;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExchangeRate {
	private int rno 				;	//일련번호
    private Date recorddate 		;	//기준일
	private String curUnit 			;	//통화코드
	private String ttb 				;	//전신환(송금)받으실때
	private String tts 				;	//전신환(송금)보내실때
	private String dealBasR 		;	//매매 기준율
	private String bkpr 			;	//장부가격
	private String yyEfeeR 			;	//년환가료율
	private String tenDdEfeeR 		;	// 10일환가료율
	private String kftcBkpr 		;	//서울외국환중개 매매기준율
	private String kftcDealBasR 	;	//서울외국환중개 장부가격
	private String curNm 			;	//국가/통화명
                                    
}
