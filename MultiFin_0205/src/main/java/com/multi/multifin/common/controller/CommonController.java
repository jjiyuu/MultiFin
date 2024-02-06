package com.multi.multifin.common.controller;

import java.util.ArrayList;
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
import com.multi.multifin.bank.model.vo.BankCreditCard;
import com.multi.multifin.bank.model.vo.BankDebitCard;
import com.multi.multifin.bank.model.vo.BankDeposit;
import com.multi.multifin.bank.model.vo.BankSaving;
import com.multi.multifin.bank.model.vo.LoanCredit;
import com.multi.multifin.bank.model.vo.LoanMortgage;
import com.multi.multifin.bank.model.vo.LoanRentHouse;
import com.multi.multifin.board.model.service.BoardService;
import com.multi.multifin.board.model.vo.Board;
import com.multi.multifin.common.util.PageInfo;
import com.multi.multifin.home.model.service.HomeBlueService;
import com.multi.multifin.home.model.service.HomeService;
import com.multi.multifin.home.model.vo.Aptdetail;
import com.multi.multifin.home.model.vo.Home;
import com.multi.multifin.home.model.vo.OfficeDetail;
import com.multi.multifin.home.model.vo.RemainDetail;
import com.multi.multifin.news.naverapi.NaverSearchAPI;
import com.multi.multifin.news.naverapi.News;
import com.multi.multifin.stock.model.service.StockPriceService;
import com.multi.multifin.stock.model.vo.ExchangeRate;
import com.multi.multifin.stock.model.vo.FundProductInfo;
import com.multi.multifin.stock.model.vo.StockPrice;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/common")
@Controller
public class CommonController {

	public static List<News> newsList1 = null;
	
	@Autowired
	private BankCardService cardService;
	
	@Autowired
	private BankDepsitSavingService bankbookService;
	
	@Autowired
	private LoanCreditService lcService;
	
	@Autowired
	private LoanMortgageService lmService;
	
	@Autowired
	private LoanRentHouseService lrhService;
	
	@Autowired
	private StockPriceService spService;
	
	@Autowired
	private StockPriceService fundService;
	
	@Autowired
	private HomeService homeService;

	@Autowired
	private HomeBlueService blueService;
	
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private StockPriceService stockPService;
	
	@RequestMapping("/searchTotal")
	public String searchTotal(Model model, @RequestParam("searchValue") String param, @RequestParam Map<String, String> paramMap,
			@RequestParam Map<String, Object> paramMapHome,
			@RequestParam(required =  false) List<String> locationCheck,
			@RequestParam Map<String, Object> searchMapHome) {
		
		log.info("통합검색 결과페이지 요청");
		model.addAttribute("searchValue", param);
		
		try {
			String check = paramMap.getOrDefault("check", "0");
			model.addAttribute("check",check);
		} catch (Exception e) {
		}
		
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
		int bankSize = depositList.size() + savingList.size() + loanCreditList0.size() + loanMortgageList0.size() + loanRentHoustList0.size() + debitList.size() + creditList.size();
		model.addAttribute("bankSize", bankSize);
		
		log.info("주가 동향 요청");
		int stockPage = 1;
		try {
			String searchValue = paramMap.get("searchValue");
			if (searchValue != null && searchValue.length() > 0) {
				paramMap.put("itmsNm", searchValue);
			}
			stockPage = Integer.parseInt(paramMap.get("stockPage"));
		} catch (Exception e) {}
		
		int stockCount = spService.getStockCount(paramMap);
		PageInfo pageInfo = new PageInfo(stockPage, 5, stockCount, 10);
		List<StockPrice> stockList = spService.getStockList(pageInfo, paramMap);
		
		model.addAttribute("stockCount", stockCount);
		model.addAttribute("stockList", stockList);
		model.addAttribute("stockPage", stockPage);
		model.addAttribute("stockPageInfo", pageInfo);
		
		log.info("부동산 매물 요청");
		int pageHome = 1;
		try {
			pageHome = Integer.parseInt(""+paramMapHome.get("pageHome"));
		} catch (Exception e) {
		}
		int homeCount = homeService.getHomeCount(searchMapHome);
		PageInfo pageHomeInfo = new PageInfo(pageHome, 5, homeCount, 10);
		List<Home> homeList = homeService.searchHomeBylocatin2(pageHomeInfo, searchMapHome);
		model.addAttribute("homeCount", homeCount);
		model.addAttribute("homeList", homeList);
		model.addAttribute("pageHomeInfo", pageHomeInfo);
		model.addAttribute("paramMapHome", paramMapHome);

		log.info("부동산 청약 아파트 요청");
		if(locationCheck == null) {
			locationCheck = new ArrayList<>();
			locationCheck.add("" + paramMapHome.get("searchValue"));
		}
		System.out.println("locationCheck : "+ locationCheck.toString());
		int pageAPT = 1;
		try {
			searchMapHome.put("searchValue", null);
			searchMapHome.put("locationCheck", locationCheck);
			pageAPT = Integer.parseInt(""+paramMapHome.get("pageAPT"));
		} catch (Exception e) {	}
		
		int aptCount = blueService.selectAptCount(searchMapHome);
		PageInfo pageAPTInfo = new PageInfo(pageAPT, 5, aptCount, 10);
		List<Aptdetail> Aptlist = blueService.searchAptList(pageAPTInfo, searchMapHome);

		paramMapHome.put("locationCheck", locationCheck);
		model.addAttribute("Aptlist", Aptlist);
		model.addAttribute("pageAPTInfo",pageAPTInfo);
		model.addAttribute("searchMapHome", searchMapHome);
		
		log.info("부동산 청약 오피스텔 요청");
		int pageOff = 1;
		try {
			searchMapHome.put("searchValue", null);
			searchMapHome.put("locationCheck", locationCheck);
			pageOff = Integer.parseInt(""+paramMapHome.get("pageOff"));
		} catch (Exception e) {	}
		
		int offCount = blueService.selectOfficeCount(searchMapHome);
		PageInfo pageOffInfo = new PageInfo(pageOff, 5, aptCount, 10);
		List<OfficeDetail> Offlist = blueService.searchOfficeList(pageOffInfo, searchMapHome);
		model.addAttribute("Offlist", Offlist);
		model.addAttribute("pageOffInfo",pageOffInfo);
		
		log.info("부동산 청약 기타 요청");
		int pageEtc = 1;
		try {
			searchMapHome.put("searchValue", null);
			searchMapHome.put("locationCheck", locationCheck);
			pageEtc = Integer.parseInt(""+paramMapHome.get("pageEtc"));
		} catch (Exception e) {	}
		
		int etcCount = blueService.selectOfficeCount(searchMapHome);
		PageInfo pageEtcInfo = new PageInfo(pageEtc, 5, etcCount, 10);
		List<RemainDetail> Etclist = blueService.searchRemainList(pageOffInfo, searchMapHome);
		model.addAttribute("Etclist", Etclist);
		model.addAttribute("pageEtcInfo",pageEtcInfo);
		
		System.out.println(Aptlist.toString());
		System.out.println(Offlist.toString());
		System.out.println(Etclist.toString());
		int homeSize = homeCount + aptCount + offCount + etcCount;
		model.addAttribute("homeSize", homeSize);
		
		log.info("뉴스 요청 성공");
		if(param != null) {
			List<News> mainList = NaverSearchAPI.getNewsList(param, 10, 1);
			model.addAttribute("newsList1", mainList); // 이게 뉴스메인에서 검색결과로 나오는것
		}else {
			model.addAttribute("newsList1", newsList1);
		}
		
		log.info("자유게시판 요청 성공");
		int pageFree = 1;

		Map<String, String> searchMap = new HashMap<String, String>();
		try {
			String searchValue = paramMap.get("searchValue");
			if(searchValue != null && searchValue.length() > 0) {
				String searchType = "title";
				searchMap.put(searchType, searchValue);
			}else {
				paramMap.put("searchType", "all");
			}
			pageFree = Integer.parseInt(paramMap.get("pageFree"));
		} catch (Exception e) {}
		int boardCount = boardService.getBoardCount2(searchMap);
		PageInfo pageFreeInfo = new PageInfo(pageFree, 10, boardCount, 10);
		List<Board> freeList = boardService.getBoardList2(pageFreeInfo, searchMap);
		model.addAttribute("freeList", freeList);
		model.addAttribute("paramMap", paramMap);
		model.addAttribute("pageFreeInfo", pageFreeInfo);
		
		log.info("환율 테이블 요청: 원하는 국가만 가져옴");
		ExchangeRate USD = stockPService.findExchangeRate("USD");
		ExchangeRate JPY = stockPService.findExchangeRate("JPY(100)");
		ExchangeRate GBP = stockPService.findExchangeRate("GBP");
		ExchangeRate HKD = stockPService.findExchangeRate("HKD");
		ExchangeRate EUR = stockPService.findExchangeRate("EUR");
		ExchangeRate CNH = stockPService.findExchangeRate("CNH");
		ExchangeRate AUD = stockPService.findExchangeRate("AUD");
		ExchangeRate SGD = stockPService.findExchangeRate("SGD");
		ExchangeRate THB = stockPService.findExchangeRate("THB");
		ExchangeRate CAD = stockPService.findExchangeRate("CAD");
		model.addAttribute("USD", USD);
		model.addAttribute("JPY", JPY);
		model.addAttribute("GBP", GBP);
		model.addAttribute("HKD", HKD);
		model.addAttribute("EUR", EUR);
		model.addAttribute("CNH", CNH);
		model.addAttribute("AUD", AUD);
		model.addAttribute("SGD", SGD);
		model.addAttribute("THB", THB);
		model.addAttribute("CAD", CAD);
		
		Map<String, String> KospiTop5 = new HashMap<String, String>();
		Map<String, String> KosdaqTop5 = new HashMap<String, String>();
		KospiTop5.put("limit", "5");
		KosdaqTop5.put("limit", "5");
		List<StockPrice> KOSPI = stockPService.getKospiRankingTop(KospiTop5);
		List<StockPrice> KOSDAQ = stockPService.getKosdaqRankingTop(KosdaqTop5);
		model.addAttribute("KOSPI", KOSPI);
		model.addAttribute("KOSDAQ", KOSDAQ);
		
		return "common/searchTotal";
	}
	
	@RequestMapping("/sitemap")
	public String sitemap() {
		return "common/sitemap";
	}
	
}
