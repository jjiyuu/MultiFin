package com.multi.multifin.bank.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankDebitCard {
	private String companyImg; // VARCHAR(1000), -- 카드사 LOGO
	private String companyNm; // VARCHAR(1000), -- 카드사명
	private String productImg; // VARCHAR(1000), -- 상품이미지URL
	private String productNm; // VARCHAR(100), -- 상품명
	private String productChar; // VARCHAR(100), -- 상품특징
	private String keyBenefit; // VARCHAR(1000), -- 주요혜택
	private String detailUrl; // VARCHAR(1000) -- 상세정보URL
}
