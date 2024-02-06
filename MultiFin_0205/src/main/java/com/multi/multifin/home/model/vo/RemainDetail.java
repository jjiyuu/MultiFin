package com.multi.multifin.home.model.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class RemainDetail {
		
	
	int remainNo; 						// int primary key auto_increment, 
	String bsnsMbyNm;					// varchar(100), -- 사업주체명 (시행사)               
	String cntrctCnclsBgnde;			// varchar(30), -- 계약시작일                  
	String cntrctCnclsRndde;			// varchar(30), -- 계약종료일                  
	String gnrlRceptBgnde ;			//varchar(30), -- 특별공급접수시작일            
	String gnrlRceptEndde ;			//varchar(30),  -- 특별공급접수종료일           
	String hmpgAdres  ;				//varchar(255), -- 홈페이지주소                      
	int houseManageNo  ;				//int, -- 주택관리번호                          
	String houseDtlSecdNm  ;			//varchar(5), -- 주택상세구분코드명           
	String houseNm  ;					//varchar(50), -- 주택명                               
	String houseSecdNm ;				//varchar(10), -- 주택구분코드명                   
	String hssplyAdres  ;				//varchar(255), -- 공급위치                        
	String hssplyZip  ;				//varchar(5), -- 공급위치 우편번호                   
	String mdhsTelno  ;				//varchar(50), -- 문의처                             
	String mvnPrearngeYm ;			//varchar(10), -- 입주예정월                     
	int pblancNo ;						//int, -- 공고번호                                     
	String pblancUrl  ;				//varchar(255), -- 분양정보 URL                      
	String przwnerPresnatnDe ;		//varchar(30), -- 당첨자발표일               
	String rcritPblancDe  ;			// varchar(30), -- 모집공고일                   
	String spsplyRceptBgnde ;			// varchar(30), -- 특별공급 접수시작일        
	String spsplyRceptEndde  ;		//varchar(30), -- 특별공급 접수종료일        
	String subscrptRceptBgnde ;		// varchar(30), -- 청약접수시작일           
	String subscrptRceptEndde ;		//varchar(30), -- 청약접수종료일            
	int totSuplyHshldco  ;			//int -- 공급규모                             
}
