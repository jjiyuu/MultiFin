package com.multi.multifin.bank.model.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoanRentHouse {
	private int 	loanRentHouseNo 			; //
	private String 	dclsMonth 				; //
	private String 	finCoNo 				; //
	private String 	korCoNm 				; //
	private String 	finPrdtCd 			; //	
	private String 	finPrdtNm 			; //	
	private String 	joinWay				; //	
	private String 	loanInciExpn 			; //
	private String 	erlyRpayFee 			; //
	private String 	dlyRate 				; //
	private String 	loanLmt				; //	
	private Date 	dclsStrtDay 			; //
	private String 	dclsEndDay 			; //	
	private Date 	finCoSubmDay 		; //	
	
	private String 	rpayType 				; //	
	private String 	rpayTypeNm 			; //		
	private String 	lendRateType 			; //	
	private String 	lendRateTypeNm 		; //		
	private double 	lendRateMin 			; //	
	private double 	lendRateMax 			; //	
	private double 	lendRateAvg			; //		
}
