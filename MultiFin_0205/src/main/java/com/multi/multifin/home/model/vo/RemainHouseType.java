package com.multi.multifin.home.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class RemainHouseType {

	int remainHouseNo  ;  		//int primary key auto_increment,             
	int houseHanageNo ;		//int, -- 주택관리번호                       
	String houseTy ;				// varchar(10), -- 모델타입                         
	String lttotTopAmoun; 		// varchar(5), -- 공급금액 (분양최고금액)(단위:원)
	int pblancNo ;				// int, --  공고번호                               
	int suplyHshldco  ;		//int -- 일반공급세대수                       
	
}
