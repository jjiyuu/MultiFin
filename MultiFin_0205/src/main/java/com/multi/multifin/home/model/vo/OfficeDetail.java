package com.multi.multifin.home.model.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OfficeDetail {

	int	officeDno ;								// int primary key auto_increment,                            
	String	bsnsMbyNm;    					// varchar(20),           -- 사업주체명 (시행사)                                   
	String cntrctCnclsBgnde ;					// varchar(10)  ,         -- 계약시작일               
	String  cntrctCnclsEndde ;				// varchar(10)  ,              -- 계약종료일         
	String  hmpgAdres;							// varchar(100),            			-- 홈페이지주소       
	String  houseDtlSecdNm;   				// varchar(30),       			-- 주택상세구분코드명 
	int houseManageNo ;					// int,				-- 주택관리번호                      
	String  houseNm ;							// varchar(30),  						-- 주택명                
	String  houseSecdNm;                      // varchar(10),          -- 주택구분코드명                 
	String	hssplyAdres ;                    	//varchar(30),            -- 공급위치                      
	String  hssplyZip  ;						//varchar(10),       -- 공급위치 우편번호                   
	String  mdhsTelno ;						//varchar(20),        -- 문의처                              
	String mvnPrearngeYm  ;					//varchar(10),   -- 입주예정월                          
	int  pblancNo  ;						//int,			-- 공고번호                                  
	String  pblancUrl  ;						//varchar(500),  			 -- 분양정보 URL                 
	String  przwnerPresnatnDe   ;				//varchar(10),  			  -- 당첨자발표일       
	String   rcritPblancDe  ;					//varchar(10),  				 -- 모집공고일           
	String  subscrptRceptBgnde ;				// varchar(10),    -- 오피스텔/도시형/민간임대 청약접수시작일           
	String  subscrptRceptEndde; 				// varchar(10),    -- 오피스텔/도시형/민간임대 청약접수종료일   
	int totSuplyHshldco        ;			// int			 -- 공급규모                  
			                                                                              ;
}
