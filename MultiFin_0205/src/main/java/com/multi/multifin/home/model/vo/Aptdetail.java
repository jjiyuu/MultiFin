package com.multi.multifin.home.model.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Aptdetail {

	int aptDno    ; 						//int primary key auto_increment, -- 일련번호                   
	String bsnsMbyNm  ; 					//varchar(30), -- 사업주체명 (시행사)                        
	String cnstrctEntrpsNm  ;				 // varchar(30), -- 건설업체명 (시공사)                 
	String cntrctCnclsBgnde ; 					// DATETIME,	-- 계약시작일                             
	String cntrctCnclsEndde ; 				// DATETIME,	-- 계약종료일                             
	String gnrlRnk1CrspareaRceptPd  ; 	// DATETIME,	-- 1순위 접수일 해당지역     
	String gnrlRnk1EtcAreaRcptdePd ; 	// DATETIME,	-- 1순위 접수일 경기지역      
	String hmpgAdres  ; 					// varchar(200), -- 홈페이지주소                              
	String houseDtlSecdNm ; 				// varchar(10), -- 주택상세구분코드명                   
	int houseManageNo   ; 				// int, -- 주택관리번호                                 
	String houseNm  ; 						//varchar(50), -- 주택명                                        
	String houseSecdNm  ; 				// varchar(10),    -- 주택구분코드명                       
	String hssplyAdres ; 					// varchar(100),   -- 공급위치                               
	String hssplyZip ; 					// varchar(5), -- 공급위치 우편번호                            
	String mdhsTelno ; 					// varchar(13), -- 문의처                                      
	String mvnPrearngeYm    ;				 // varchar(6), -- 입주예정월                           
	String nplnPrvoprPublicHouseAt; 	// char(1), -- 수도권 내 민영 공공주택지구 여부Y/N
	char parcprcUlsAt; 					// char(1), -- 분양가상한제 Y/N                             
	int pblancNo; 							// int, -- 공고번호                                              
	String pblancUrl ;						 // varchar(1000), -- 분양정보 URL                              
	Date przwnerPresnatnDe   ;			 // DATETIME, -- 당첨자발표일                        
	char publicHouseEarthAt   ; 			//char(1), -- 공공주택지구 Y/N                    
	String rceptBgnde ; 						// DATETIME,	-- 청약접수시작일                             
	String rceptEndde;						 // DATETIME,	-- 청약접수종료일                              
	String rcritPblancDe  ; 				// DATETIME,	-- 모집공고일                            
	String rentSecdNm  ; 					// varchar(10), -- 분양구분코드명                           
	char specltRdnEarthAt  ; 			// char(1), -- 투기과열지구                          
	String spsplyRceptBgnde   ; 			// DATETIME, -- 특별공급 접수시작일                  
	String spsplyRceptEndde    ; 			// DATETIME, -- 특별공급 접수종료일                 
	String subscrptAreaCodeNm    ; 		//varchar(10), -- 공급지역명                     
	int totSuplyHshldco   ; 				// int -- 공급규모   
	//지역에 상세지역이 있고 서울,경기 이렇게만 네~
	
}
