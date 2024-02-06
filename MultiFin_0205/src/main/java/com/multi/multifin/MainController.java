package com.multi.multifin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.multi.multifin.bank.model.service.BankCardService;
import com.multi.multifin.bank.model.service.BankCompanyService;
import com.multi.multifin.bank.model.service.BankDepsitSavingService;
import com.multi.multifin.bank.model.service.LoanCreditService;
import com.multi.multifin.bank.model.service.LoanMortgageService;
import com.multi.multifin.bank.model.service.LoanRentHouseService;
import com.multi.multifin.bank.model.vo.BankCompany;
import com.multi.multifin.bank.model.vo.BankDeposit;
import com.multi.multifin.bank.model.vo.BankSaving;
import com.multi.multifin.bank.model.vo.LoanCredit;
import com.multi.multifin.bank.model.vo.LoanMortgage;
import com.multi.multifin.bank.model.vo.LoanRentHouse;
import com.multi.multifin.board.model.service.BoardService;
import com.multi.multifin.board.model.vo.Board;
import com.multi.multifin.member.model.vo.Member;
import com.multi.multifin.stock.model.service.StockPriceService;
import com.multi.multifin.stock.model.vo.ExchangeRate;
import com.multi.multifin.stock.model.vo.StockPrice;
import com.multi.multifin.stock.model.vo.StockPriceIndex;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {
	
	@Autowired
	private StockPriceService stockService;
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
	@Autowired
	private BoardService boardService;
	
	
	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home(Locale locale, Model model, HttpSession session, Map<String, String> paramMap, @SessionAttribute(name = "loginMember", required = false) Member loginMember) {
		logger.info("Welcome home! The client locale is {}.", locale);
		model.addAttribute("loginMember", loginMember);
		
		/*증권정보*/
		logger.info("환율 테이블 요청: 원하는 국가만 가져옴");
		ExchangeRate USD = stockService.findExchangeRate("USD");
		ExchangeRate JPY = stockService.findExchangeRate("JPY(100)");
		model.addAttribute("USD", USD);
		model.addAttribute("JPY", JPY);
		
		StockPriceIndex kospiIndex = stockService.getnowStockIndex("KOSPI");
		StockPriceIndex kosdaqIndex = stockService.getnowStockIndex("KOSDAQ");
		StockPriceIndex nasdaqIndex = stockService.getnowStockIndex("NASDAQ");
		model.addAttribute("kospiIndex", kospiIndex);
		model.addAttribute("kosdaqIndex", kosdaqIndex);
		model.addAttribute("nasdaqIndex", nasdaqIndex);
		
		
		
		
		
		
		logger.info("예적금상품 요청");
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
		
		logger.info("대출 상품 요청 성공");
		List<LoanCredit> loanCreditList0 = lcService.selectLoanCreditList();
		model.addAttribute("loanCreditList0", loanCreditList0);
		List<LoanMortgage> loanMortgageList0 = lmService.selectLoanMortgageList();
		model.addAttribute("loanMortgageList0", loanMortgageList0);
		List<LoanRentHouse> loanRentHoustList0 = lrhService.selectLoanRentHouseList();
		model.addAttribute("loanRentHoustList0", loanRentHoustList0);
		
		
		logger.info("게시판(공지사항) 요청 성공");
		List<Board> boardList = boardService.selectMainBoard();
		model.addAttribute("list", boardList);
		System.out.println(boardList);
		return "index";
	}
	
	
	
	@GetMapping("/stockRest/{id}")
	public ResponseEntity<List<Double>> getStockInfo(@PathVariable("id") String id)
	{		
		List<Double> list = new ArrayList<>();
		if(id.equalsIgnoreCase("KOSPI")) {
			List<StockPriceIndex> kospi =stockService.getStockList("KOSPI");
			for (int i = 0; i < kospi.size(); i++) {
				String realNum = (kospi.get(i).getFin()).replaceAll(",", "");
				double stockNum = Double.parseDouble(realNum);
				list.add(stockNum);
			}
		}else if (id.equalsIgnoreCase("KOSDAQ")) {
			List<StockPriceIndex> kosdaq =stockService.getStockList("KOSDAQ");
			for (int i = 0; i < kosdaq.size(); i++) {
				String realNum = (kosdaq.get(i).getFin()).replaceAll(",", "");
				double stockNum = Double.parseDouble(realNum);
				list.add(stockNum);
			}
		}else if (id.equalsIgnoreCase("NASDAQ")) {
			List<StockPriceIndex> nasdaq =stockService.getStockList("NASDAQ");
			for (int i = 0; i < nasdaq.size(); i++) {
				String realNum = (nasdaq.get(i).getFin()).replaceAll(",", "");
				double stockNum = Double.parseDouble(realNum);
				list.add(stockNum);
			}
		}else if (id.equalsIgnoreCase("USD")) {
			List<ExchangeRate> USD =stockService.StockPricefindByName("USD");
			for (int i = 0; i < USD.size(); i++) {
				String realNum = (USD.get(i).getDealBasR()).replaceAll(",", "");
				double stockNum = Double.parseDouble(realNum);
				list.add(stockNum);
			}
		}else if (id.equalsIgnoreCase("JPY")) {
			List<ExchangeRate> JPY =stockService.StockPricefindByName("JPY");
			for (int i = 0; i < JPY.size(); i++) {
				String realNum = (JPY.get(i).getDealBasR()).replaceAll(",", "");
				double stockNum = Double.parseDouble(realNum);
				list.add(stockNum);
			}
		}
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	
	
	
}
