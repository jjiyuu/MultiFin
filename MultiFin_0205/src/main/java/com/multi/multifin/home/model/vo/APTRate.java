package com.multi.multifin.home.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class APTRate {

	int aptRateNo; 							// int primary key auto_increment, -- 일련번호
	int houseManageNo;					// int, -- 주택관리번호               
	int pblancNo ;							// int, -- 공고번호                        
	String houseTy  ;							// varchar(10), -- 주택형                  
	String resideSenm ;						// varchar(5), -- 거주지역               
	int subscrptRankCode ;				// int, -- 순위                   
	int suplyHshldco;						// int, -- 공급세대수                   
	String reqCnt  ;							// varchar(10), -- 접수건수                 
	String cmpetRate;							// varchar(10), -- 경쟁률                  
	int lwetScore;							// int, -- 최저당첨가점                    
	int topScore ;							// int, -- 최고당첨가점                    
	int avrgScore;							// int -- 평균당첨가점                     
	
}
