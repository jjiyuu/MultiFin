package com.multi.multifin.bank.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.multi.multifin.bank.model.service.BankCardService;
import com.multi.multifin.bank.model.service.BankCompanyService;
import com.multi.multifin.bank.model.service.BankDepsitSavingService;
import com.multi.multifin.bank.model.service.LoanCreditService;
import com.multi.multifin.bank.model.service.LoanMortgageService;
import com.multi.multifin.bank.model.service.LoanRentHouseService;
import com.multi.multifin.bank.model.vo.BankCompany;
import com.multi.multifin.bank.model.vo.BankCreditCard;
import com.multi.multifin.bank.model.vo.BankDebitCard;
import com.multi.multifin.bank.model.vo.BankDeposit;
import com.multi.multifin.bank.model.vo.BankSaving;
import com.multi.multifin.bank.model.vo.LoanCredit;
import com.multi.multifin.bank.model.vo.LoanMortgage;
import com.multi.multifin.bank.model.vo.LoanRentHouse;
import com.multi.multifin.common.util.PageInfo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/bank")
@Controller
public class BankController {

	@Autowired
	private BankCardService cardService;
	
	@Autowired
	private BankDepsitSavingService bankbookService;
	
	@Autowired
	private BankCompanyService companyService;
	
	@Autowired
	private LoanCreditService lcService;
	
	@Autowired
	private LoanMortgageService lmService;
	
	@Autowired
	private LoanRentHouseService lrhService;
	
	@GetMapping("/bankCard")
	public String bankCard(Model model, @RequestParam Map<String, String> paramMap) {
		log.info("은행 카드상품 페이지 요청 성공");
		
		log.info("롯데카드 요청");
		List<BankCreditCard> creditLotte = cardService.selectCreditLotte();
		List<BankDebitCard> debitLotte = cardService.selectDebitLotte();
		model.addAttribute("creditLotte", creditLotte);
		model.addAttribute("debitLotte", debitLotte);
		log.info("비씨카드 요청");
		List<BankCreditCard> creditBC = cardService.selectCreditBC();
		List<BankDebitCard> debitBC = cardService.selectDebitBC();
		model.addAttribute("creditBC", creditBC);
		model.addAttribute("debitBC", debitBC);
		log.info("삼성카드 요청");
		List<BankCreditCard> creditSamsung = cardService.selectCreditSamsung();
		List<BankDebitCard> debitSamsung = cardService.selectDebitSamsung();
		model.addAttribute("creditSamsung", creditSamsung);
		model.addAttribute("debitSamsung", debitSamsung);
		log.info("신한카드 요청");
		List<BankCreditCard> creditSinhan = cardService.selectCreditSinhan();
		List<BankDebitCard> debitSinhan = cardService.selectDebitSinhan();
		model.addAttribute("creditSinhan", creditSinhan);
		model.addAttribute("debitSinhan", debitSinhan);
		log.info("우리카드 요청");
		List<BankCreditCard> creditWoori = cardService.selectCreditWoori();
		List<BankDebitCard> debitWoori = cardService.selectDebitWoori();
		model.addAttribute("creditWoori", creditWoori);
		model.addAttribute("debitWoori", debitWoori);
		log.info("하나카드 요청");
		List<BankCreditCard> creditHana = cardService.selectCreditHana();
		List<BankDebitCard> debitHana = cardService.selectDebitHana();
		model.addAttribute("creditHana", creditHana);
		model.addAttribute("debitHana", debitHana);
		log.info("현대카드 요청");
		List<BankCreditCard> creditHyundai = cardService.selectCreditHyundai();
		List<BankDebitCard> debitHyundai = cardService.selectDebitHyundai();
		model.addAttribute("creditHyundai", creditHyundai);
		model.addAttribute("debitHyundai", debitHyundai);
		log.info("국민카드 요청");
		List<BankCreditCard> creditKb = cardService.selectCreditKb();
		List<BankDebitCard> debitKb = cardService.selectDebitKb();
		model.addAttribute("creditKb", creditKb);
		model.addAttribute("debitKb", debitKb);
		
		
		log.info("카드 테이블 요청");
		log.info("신용카드 전체 요청");
		int pageDebit = 1;
		try {
			String searchValue = paramMap.get("searchValue");
			if(searchValue != null && searchValue.length() > 0) {
				paramMap.put("companyNm", searchValue);
			}else {
			}
			pageDebit = Integer.parseInt(paramMap.get("pageDebit"));
		} catch (Exception e) {
		}
		
		try {
			String check = paramMap.getOrDefault("check", "0");
			model.addAttribute("check",check);
		} catch (Exception e) {
		}
		
		int debitCount = cardService.getDebitCount(paramMap);
		PageInfo pageDebitInfo = new PageInfo(pageDebit, 5, debitCount, 12);
		List<BankDebitCard> debitList = cardService.selectDebitList(pageDebitInfo, paramMap);
		model.addAttribute("debitList", debitList);
		model.addAttribute("paramMap", paramMap);
		model.addAttribute("pageDebitInfo", pageDebitInfo);
		
		
		log.info("체크카드 전체 요청");
		int pageCredit = 1;
		try {
			pageCredit = Integer.parseInt(paramMap.get("pageCredit"));
		} catch (Exception e) {
		}
		int creditCount = cardService.getCreditCount(paramMap);
		PageInfo pageCreditInfo = new PageInfo(pageCredit, 5, creditCount, 12);
		List<BankCreditCard> creditList = cardService.selectCreditList(pageCreditInfo, paramMap);
		model.addAttribute("creditList", creditList);
		model.addAttribute("pageCreditInfo", pageCreditInfo);
		
		return "bank/bankCard";
	}
	
	@GetMapping("/bankDeposit")
	public String bankDeposit(Model model, @RequestParam Map<String, String> paramMap) {
		log.info("예적금 페이지 요청 성공");
		List<BankDeposit> depositList0 = bankbookService.selectDepositList();
		List<BankSaving> savingList0 = bankbookService.selectSavingList();
		model.addAttribute("depositList0", depositList0);
		model.addAttribute("savingList0", savingList0);
		
		List<BankCompany> logoList = companyService.selectLogoList(paramMap);
		model.addAttribute("logoList", logoList);
		
		
		log.info("예금상품 전체 요청");
		int pageDeposit = 1;
		try {
			String searchValue = paramMap.get("searchValue");
			if(searchValue != null && searchValue.length() > 0) {
				paramMap.put("korCoNm", searchValue);
			}else {
			}
			pageDeposit = Integer.parseInt(paramMap.get("pageDeposit"));
		} catch (Exception e) {
		}
		
		try {
			String check = paramMap.getOrDefault("check", "0");
			model.addAttribute("check",check);
		} catch (Exception e) {
		}
		
		int depositCount = bankbookService.getDepositCountUnique(paramMap);
		log.info("depositCount"+depositCount);
		PageInfo pageDepositInfo = new PageInfo(pageDeposit, 5, depositCount, 10);
		List<BankDeposit> depositList = bankbookService.selectDepositListUnique(pageDepositInfo, paramMap);
		for(BankDeposit deposit : depositList0) {
			String coName = deposit.getKorCoNm();
			for(BankCompany logoInfo :  logoList) {
				if(logoInfo.getKorCoNm().equals(coName)) {
					deposit.setLogoUrl(logoInfo.getLogoUrl());
					break;
				}
			}
		}
		model.addAttribute("depositList", depositList);
		model.addAttribute("paramMap", paramMap);
		model.addAttribute("pageDepositInfo", pageDepositInfo);
		
		log.info("적금상품 전체 요청");
		int pageSaving = 1;
		try {
			pageSaving = Integer.parseInt(paramMap.get("pageSaving"));
		} catch (Exception e) {
		}
		int savingCount = bankbookService.getSavingCountUnique(paramMap);
		log.info("savingCount"+savingCount);
		PageInfo pageSavingInfo = new PageInfo(pageSaving, 5, savingCount, 10);
		List<BankSaving> savingList = bankbookService.selectSavingListUnique(pageSavingInfo, paramMap);
		for(BankSaving saving : savingList0) {
			String coName = saving.getKorCoNm();
			for(BankCompany logoInfo :  logoList) {
				if(logoInfo.getKorCoNm().equals(coName)) {
					saving.setLogoUrl(logoInfo.getLogoUrl());
					break;
				}
			}
		}
		model.addAttribute("savingList", savingList);
		model.addAttribute("pageSavingInfo", pageSavingInfo);
		return "bank/bankDeposit";
	}
	
	@RequestMapping("/bankDetail")
	public String bankDetail(Model model, @RequestParam("no") String param) {
		log.info("대출 상세페이지 요청 성공");
		System.out.println(param); // OK
		List<LoanCredit> lcList = lcService.selectLoanCreditListAll(param);
		model.addAttribute("lcList", lcList);
		List<LoanMortgage> lmList = lmService.selectLoanMortgageListAll(param);
		model.addAttribute("lmList", lmList);
		List<LoanRentHouse> lrhList = lrhService.selectLoanRentHouseListAll(param);
		model.addAttribute("lrhList", lrhList);
		return "bank/bankDetail";
	}
	
	@RequestMapping("/bankFind")
	public String bankFind(Model model, @RequestParam("no") String param) {
		log.info("예적금 상품상세 페이지 요청 성공");
		System.out.println(param); // OK
		List<BankDeposit> depositList = bankbookService.selectDepositListAll(param);
		model.addAttribute("depositList", depositList);
		
		List<BankSaving> savingList = bankbookService.selectSavingListAll(param);
		model.addAttribute("savingList", savingList);
		
		
		return "bank/bankFind";
	}
	
	@RequestMapping("/bankLoan")
	public String bankLoan(Model model, @RequestParam Map<String, String> paramMap) {
		log.info("대출 페이지 요청 성공");
		List<LoanCredit> loanCreditList0 = lcService.selectLoanCreditList();
		model.addAttribute("loanCreditList0", loanCreditList0);
		List<LoanMortgage> loanMortgageList0 = lmService.selectLoanMortgageList();
		model.addAttribute("loanMortgageList0", loanMortgageList0);
		List<LoanRentHouse> loanRentHoustList0 = lrhService.selectLoanRentHouseList();
		model.addAttribute("loanRentHoustList0", loanRentHoustList0);
		
		log.info("개인신용대출 전체 요청");
		int pageLc = 1;
		try {
			String searchValue = paramMap.get("searchValue");
			if(searchValue != null && searchValue.length() > 0) {
				paramMap.put("korCoNm", searchValue);
			}else {
			}
			pageLc = Integer.parseInt(paramMap.get("pageLc"));
		} catch (Exception e) {
		}
		
		try {
			String check = paramMap.getOrDefault("check", "0");
			model.addAttribute("check",check);
		} catch (Exception e) {
		}
		
		int lcCount = lcService.selectLoanCreditCountUnique(paramMap);
		PageInfo pageLcInfo = new PageInfo(pageLc, 5, lcCount, 10);
		List<LoanCredit> lcList = lcService.selectLoanCreditListUnique(pageLcInfo, paramMap);
		model.addAttribute("lcList", lcList);
		model.addAttribute("paramMap", paramMap);
		model.addAttribute("pageLcInfo", pageLcInfo);
		
		log.info("주택담보대출 전체 요청");
		int pageLm = 1;
		try {
			pageLm = Integer.parseInt(paramMap.get("pagdLm"));
		} catch (Exception e) {
		}
		int lmCount = lmService.selectLoanMortgageCountUnique(paramMap);
		PageInfo pageLmInfo = new PageInfo(pageLm, 5, lmCount, 10);
		List<LoanMortgage> lmList = lmService.selectLoanMortgageListUnique(pageLmInfo, paramMap);
		model.addAttribute("lmList", lmList);
		model.addAttribute("pageLmInfo", pageLmInfo);
		
		log.info("전세자금대출 전체 요청");
		int pageLrh = 1;
		try {
			pageLrh = Integer.parseInt(paramMap.get("pageLrh"));
		} catch (Exception e) {
		}
		int lrhCount = lrhService.selectLoanRentHouseCountUnique(paramMap);
		PageInfo pageLrhInfo = new PageInfo(pageLrh, 5, lrhCount, 10);
		List<LoanRentHouse> lrhList = lrhService.selectLoanRentHouseListUnique(pageLmInfo, paramMap);
		model.addAttribute("lrhList", lrhList);
		model.addAttribute("pageLrhInfo", pageLrhInfo);
		return "bank/bankLoan";
	}

	@RequestMapping("/bankMain")
	public String bankMain(Model model, Map<String, String> paramMap) {
		log.info("신용카드 전체 요청");
		int pageDebit = 1;
		try {
			String searchValue = paramMap.get("searchValue");
			if(searchValue != null && searchValue.length() > 0) {
				paramMap.put("companyNm", searchValue);
			}else {
			}
			pageDebit = Integer.parseInt(paramMap.get("pageDebit"));
		} catch (Exception e) {
		}
		
		int debitCount = cardService.getDebitCount(paramMap);
		PageInfo pageDebitInfo = new PageInfo(pageDebit, 5, debitCount, 24);
		List<BankDebitCard> debitList = cardService.selectDebitList(pageDebitInfo, paramMap);
		model.addAttribute("debitList", debitList);
		model.addAttribute("paramMap", paramMap);
		model.addAttribute("pageDebitInfo", pageDebitInfo);
		
		log.info("체크카드 전체 요청");
		int pageCredit = 1;
		try {
			pageCredit = Integer.parseInt(paramMap.get("pageCredit"));
		} catch (Exception e) {
		}
		int creditCount = cardService.getCreditCount(paramMap);
		PageInfo pageCreditInfo = new PageInfo(pageCredit, 5, creditCount, 24);
		List<BankCreditCard> creditList = cardService.selectCreditList(pageCreditInfo, paramMap);
		model.addAttribute("creditList", creditList);
		model.addAttribute("pageCreditInfo", pageCreditInfo);
		
		log.info("예적금상품 요청");
		List<BankDeposit> depositList0 = bankbookService.selectDepositList();
		List<BankSaving> savingList0 = bankbookService.selectSavingList();
		List<BankCompany> logoList = companyService.selectLogoList(paramMap);
		model.addAttribute("logoList", logoList);
		
		for(BankDeposit deposit : depositList0) {
			String coName = deposit.getKorCoNm();
			for(BankCompany logoInfo :  logoList) {
				if(logoInfo.getKorCoNm().equals(coName)) {
					deposit.setLogoUrl(logoInfo.getLogoUrl());
					break;
				}
			}
		}
		for(BankSaving saving : savingList0) {
			String coName = saving.getKorCoNm();
			for(BankCompany logoInfo :  logoList) {
				if(logoInfo.getKorCoNm().equals(coName)) {
					saving.setLogoUrl(logoInfo.getLogoUrl());
					break;
				}
			}
		}
		model.addAttribute("depositList0", depositList0);
		model.addAttribute("savingList0", savingList0);
		
		log.info("대출 상품 요청 성공");
		List<LoanCredit> loanCreditList0 = lcService.selectLoanCreditList();
		model.addAttribute("loanCreditList0", loanCreditList0);
		List<LoanMortgage> loanMortgageList0 = lmService.selectLoanMortgageList();
		model.addAttribute("loanMortgageList0", loanMortgageList0);
		List<LoanRentHouse> loanRentHoustList0 = lrhService.selectLoanRentHouseList();
		model.addAttribute("loanRentHoustList0", loanRentHoustList0);
		
		return "bank/bankMain";
	}
	
	@RequestMapping("/bankSearch")
	public String bankSearch(Model model, @RequestParam("searchValue") String param, Map<String, String> paramMap) {
		model.addAttribute("searchValue", param);
		
		log.info("예금상품 전체 요청");
		int pageDeposit = 1;
		try {
			paramMap.put("korCoNm", param);
			pageDeposit = Integer.parseInt(paramMap.get("pageDeposit"));
		} catch (Exception e) {
		}
		
		int depositCount = bankbookService.getDepositCountUnique(paramMap);
		PageInfo pageDepositInfo = new PageInfo(pageDeposit, 5, depositCount, 10);
		List<BankDeposit> depositList = bankbookService.selectDepositListUnique(pageDepositInfo, paramMap);
		
		model.addAttribute("depositList", depositList);
		model.addAttribute("paramMap", paramMap);
		model.addAttribute("pageDepositInfo", pageDepositInfo);
		
		log.info("적금상품 전체 요청");
		int pageSaving = 1;
		try {
			pageSaving = Integer.parseInt(paramMap.get("pageSaving"));
		} catch (Exception e) {
		}
		int savingCount = cardService.getCreditCount(paramMap);
		PageInfo pageSavingInfo = new PageInfo(pageSaving, 5, savingCount, 10);
		List<BankSaving> savingList = bankbookService.selectSavingListUnique(pageSavingInfo, paramMap);
		
		model.addAttribute("savingList", savingList);
		model.addAttribute("pageSavingInfo", pageSavingInfo);
		
		log.info("개인신용대출 전체 요청");
		int pageLc = 1;
		try {
			paramMap.put("korCoNm", param);
			pageLc = Integer.parseInt(paramMap.get("pageLc"));
		} catch (Exception e) {
		}
		
		int lcCount = lcService.selectLoanCreditCountUnique(paramMap);
		PageInfo pageLcInfo = new PageInfo(pageLc, 5, lcCount, 10);
		List<LoanCredit> loanCreditList0 = lcService.selectLoanCreditListUnique(pageLcInfo, paramMap);
		model.addAttribute("loanCreditList0", loanCreditList0);
		model.addAttribute("paramMap", paramMap);
		model.addAttribute("pageLcInfo", pageLcInfo);
		
		log.info("주택담보대출 전체 요청");
		int pageLm = 1;
		try {
			pageLm = Integer.parseInt(paramMap.get("pagdLm"));
		} catch (Exception e) {
		}
		int lmCount = lmService.selectLoanMortgageCountUnique(paramMap);
		PageInfo pageLmInfo = new PageInfo(pageLm, 5, lmCount, 10);
		List<LoanMortgage> loanMortgageList0 = lmService.selectLoanMortgageListUnique(pageLmInfo, paramMap);
		model.addAttribute("loanMortgageList0", loanMortgageList0);
		model.addAttribute("pageLmInfo", pageLmInfo);
		
		log.info("전세자금대출 전체 요청");
		int pageLrh = 1;
		try {
			pageLrh = Integer.parseInt(paramMap.get("pageLrh"));
		} catch (Exception e) {
		}
		int lrhCount = lrhService.selectLoanRentHouseCountUnique(paramMap);
		PageInfo pageLrhInfo = new PageInfo(pageLrh, 5, lrhCount, 10);
		List<LoanRentHouse> loanRentHoustList0 = lrhService.selectLoanRentHouseListUnique(pageLmInfo, paramMap);
		model.addAttribute("loanRentHoustList0", loanRentHoustList0);
		model.addAttribute("pageLrhInfo", pageLrhInfo);
		
		
		
		log.info("신용카드 전체 요청");
		int pageDebit = 1;
		try {
				paramMap.put("companyNm", param);
			pageDebit = Integer.parseInt(paramMap.get("pageDebit"));
		} catch (Exception e) {
		}
		
		int debitCount = cardService.getDebitCount(paramMap);
		PageInfo pageDebitInfo = new PageInfo(pageDebit, 5, debitCount, 12);
		List<BankDebitCard> debitList = cardService.selectDebitList(pageDebitInfo, paramMap);
		model.addAttribute("debitList", debitList);
		model.addAttribute("paramMap", paramMap);
		model.addAttribute("pageDebitInfo", pageDebitInfo);
		
		log.info("체크카드 전체 요청");
		int pageCredit = 1;
		try {
			pageCredit = Integer.parseInt(paramMap.get("pageCredit"));
		} catch (Exception e) {
		}
		int creditCount = cardService.getCreditCount(paramMap);
		PageInfo pageCreditInfo = new PageInfo(pageCredit, 5, creditCount, 12);
		List<BankCreditCard> creditList = cardService.selectCreditList(pageCreditInfo, paramMap);
		model.addAttribute("creditList", creditList);
		model.addAttribute("pageCreditInfo", pageCreditInfo);
		
		return "bank/bankSearch";
	}
	
}
