package com.multi.multifin.home.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class OfficeHouseType {
	int officeHouseNo;  				// int primary key auto_increment,   
	double excluseAr ;					//decimal(5, 2), -- 전용면적           
	char gp ;							//char(1), -- 군                               
	int houseManageNo;				// int, -- 주택관리번호            
	int pblancNo;					// int, -- 공고번호                      
	String subscrptReqstAmount ;		// varchar(5), -- 청약신청금
	String suplyAmount ; 				//varchar(11), -- 공급금액 (분양최고가액)
	int suplyHshldco;				// int, -- 공급세대수                
	String tp ;							// varchar(10) -- 타입                         
}
