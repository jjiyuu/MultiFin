package com.multi.multifin.home.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class APTHouseType {

	int aptHouseNo  ; 					// int primary key auto_increment, -- 일련번호       
	int etcHshldco ;					// int, -- 특별공급-기타 세대수                      
	int houseManageNo ;				// int, -- 주택관리번호                          
	String houseTy ;						// varchar(10), -- 주택관리번호                         
	int insttRecomendHshldco ;		// int, --  특별공급-기관추천 세대수      
	int lfeFrstHshldco ;				// int, -- 특별공급-생애최초 세대수             
	String lttotTopAmount ;				// varchar(20), -- 공급금액 (분양최고금액) (단위:원)
	int mnychHshldco ;					// int, -- 특별공급-다자녀가구 세대수              
	int nwwdsHshldco ;					// int, -- 특별공급-신혼부부 세대수                
	int oldParntsSuportHshldco;		// int, -- 특별공급-노부모부양 세대수   
	int pblancNo ;						// int, -- 공고번호                                    
	int spsplyHshldco ;				// int, -- 특별공급세대수                         
	String suplyAr  ;						// varchar(20), -- 공급면적                            
	int suplyHshldco ;					// int, -- 일반공급세대수                          
	int transrInsttEnfsnHshldco ;	// int -- 특별공급-이전기관 세대수    
}
