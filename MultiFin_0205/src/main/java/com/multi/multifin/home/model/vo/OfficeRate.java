package com.multi.multifin.home.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class OfficeRate {
	int officeRateNo;		// int primary key auto_increment, 
	int houseManageNo;	// int, -- 주택관리번호	     
	int pblancNo;			// int, -- 공고번호                   
	String houseTy;			// varchar(5), -- 주택형               
	int suplyHshldco;		// int, -- 공급세대수             
	char residntPriorAt ;	// char(1), -- 거주자 우선여부
	String residentPriorSenm;// varchar(5), -- 공급구분명
	String reqCnt ;			// varchar(5), -- 접수건수             
	String cmpetRate;			// varchar(10) -- 경쟁률             
}  
