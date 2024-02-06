package com.multi.multifin.stock.model.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FundProductInfo {
	private int fpino          ; // 일련번호
	private Date basDt         ; // 기준일자
	private String srtnCd      ; // 단축코드
	private String fndNm       ; // 펀드명
	private String ctg         ; // 구분
	private Date setpDt        ; // 설정일  (펀드의 탄생일)
	private String fndTp       ; // 펀드유형 
	private String prdClsfCd   ; // 상품분류코드
	private String asoStdCd    ; // 협회표준코드
}
