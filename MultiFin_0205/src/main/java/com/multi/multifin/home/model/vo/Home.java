package com.multi.multifin.home.model.vo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Home {

	private int RealEstateDealNo ;  //  부동산 pk
	private String Build_Year; 		//  건축년도
	private String Contract_Type; 	//  계약 타입
	private String Term_Contract; 	//  계약 기간
	private String Offi_Name; 	    //  오피스텔 이름     
	private String Deal_Year;		//  년도
	private String Dong; 			//  법정동
	private String Deposit; 	    //  보증금 
	private String Sigungu; 	    //  시군구 
	private String Apartment_Name; 	//  아파트 이름
	private String Deal_Month; 	    //  월  
	private int Monthly_Rent; 	    //  월세
	private String Deal_Day; 		//  일
	private String Area; 		    //  면적
	private String Jibun;           //  지번 
	private String Regional_Code; 	//  지역코드
	private String Floor; 	        //  층
	
}
