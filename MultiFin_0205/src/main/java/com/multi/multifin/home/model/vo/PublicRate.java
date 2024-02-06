package com.multi.multifin.home.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class PublicRate {
	int pubNo;					// int primary key auto_increment, 
	int houseManageNo;		// int, -- 주택관리번호  
	int pblancNo ;				//int, -- 공고번호            
	String houseTy ;				//varchar(5), -- 주택형        
	int suplyHshldco ;			//int, -- 공급세대수      
	String spsplyKndNm ;			//varchar(5), -- 공급유형 
	int spsplyKndHshldco;		// int, -- 배정세대수 
	String reqCnt ;				//varchar(5), -- 접수건수       
	String cmpetRate;				// varchar(6) -- 경쟁률       
}
