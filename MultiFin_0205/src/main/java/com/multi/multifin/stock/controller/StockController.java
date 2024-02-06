package com.multi.multifin.stock.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.multi.multifin.account.model.service.AccountService;
import com.multi.multifin.account.model.vo.Account;
import com.multi.multifin.board.model.vo.Board;
import com.multi.multifin.common.util.PageInfo;
import com.multi.multifin.investedstock.model.service.InvestedStockService;
import com.multi.multifin.investedstock.model.vo.InvestedStock;
import com.multi.multifin.member.model.vo.Member;
import com.multi.multifin.stock.model.service.StockPriceService;
import com.multi.multifin.stock.model.vo.ExchangeRate;
import com.multi.multifin.stock.model.vo.FundProductInfo;
import com.multi.multifin.stock.model.vo.StockPrice;
import com.multi.multifin.stock.model.vo.StockPriceIndex;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/stock")
@SessionAttributes("loginMember")
@Controller
public class StockController {
	
	@Autowired
	private StockPriceService service;
	
	@Autowired
	private InvestedStockService isService;
	
	@Autowired
	private AccountService aService;
	
	@GetMapping("/stockMain")
	public String stockMainPage(Model model) {
		log.info("증권 메인 페이지 요청 성공");
		log.info("지수 정보");
		StockPriceIndex kospiIndex = service.getnowStockIndex("KOSPI");
		StockPriceIndex kosdaqIndex = service.getnowStockIndex("KOSDAQ");
		model.addAttribute("kospiIndex", kospiIndex);
		model.addAttribute("kosdaqIndex", kosdaqIndex);
		
		log.info("리스트 요청");
		Map<String, String> KospiTop5 = new HashMap<String, String>();
		Map<String, String> KosdaqTop5 = new HashMap<String, String>();
		KospiTop5.put("limit", "5");
		KosdaqTop5.put("limit", "5");
		List<StockPrice> KOSPI = service.getKospiRankingTop(KospiTop5);
		List<StockPrice> KOSDAQ = service.getKosdaqRankingTop(KosdaqTop5);
		model.addAttribute("KOSPI", KOSPI);
		model.addAttribute("KOSDAQ", KOSDAQ);
		
		log.info("주가동향 요청");
		StockPrice ss = service.findByNo(5930);
		StockPrice sk = service.findByNo(660);
		StockPrice lg = service.findByNo(373220);
		model.addAttribute("ss", ss);
		model.addAttribute("sk", sk);
		model.addAttribute("lg", lg);
		
		log.info("환율 테이블 요청: 원하는 국가만 가져옴");
		ExchangeRate USD = service.findExchangeRate("USD");
		ExchangeRate JPY = service.findExchangeRate("JPY(100)");
		ExchangeRate GBP = service.findExchangeRate("GBP");
		ExchangeRate HKD = service.findExchangeRate("HKD");
		ExchangeRate EUR = service.findExchangeRate("EUR");
		ExchangeRate CNH = service.findExchangeRate("CNH");
		ExchangeRate AUD = service.findExchangeRate("AUD");
		ExchangeRate SGD = service.findExchangeRate("SGD");
		ExchangeRate THB = service.findExchangeRate("THB");
		ExchangeRate CAD = service.findExchangeRate("CAD");
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
		
		return "stock/stockMain";
	}
	
	@RequestMapping("/stockList")
	public String stockList(Model model, @RequestParam Map<String, String> paramMap) {
		log.info("리스트 페이지 요청 성공");
		log.info("지수 정보 요청");
		StockPriceIndex kospiIndex = service.getnowStockIndex("KOSPI");
		StockPriceIndex kosdaqIndex = service.getnowStockIndex("KOSDAQ");
		StockPriceIndex nasdaqIndex = service.getnowStockIndex("NASDAQ");
		
		model.addAttribute("kospiIndex", kospiIndex);
		model.addAttribute("kosdaqIndex", kosdaqIndex);
		model.addAttribute("nasdaqIndex", nasdaqIndex);
		
		log.info("코스피/코스닥 인기순 정보 요청");
		Map<String, String> KospiTop5 = new HashMap<String, String>();
		Map<String, String> KosdaqTop5 = new HashMap<String, String>();
		KospiTop5.put("limit", "5");
		KosdaqTop5.put("limit", "5");
		List<StockPrice> kospiRanking = service.getKospiRankingTop(KospiTop5);
		List<StockPrice> kosdaqRanking = service.getKosdaqRankingTop(KosdaqTop5);
		model.addAttribute("kospiRanking", kospiRanking);
		model.addAttribute("kosdaqRanking", kosdaqRanking);
		
		
		log.info("코스피/코스닥 리스트 정보 요청");
		Map<String, String> KospiTop10 = new HashMap<String, String>();
		Map<String, String> KosdaqTop10 = new HashMap<String, String>();
		KospiTop10.put("limit", "10");
		KosdaqTop10.put("limit", "10");
		List<StockPrice> kospiBoard = service.getKospiRankingTop(KospiTop10);
		List<StockPrice> kosdaqBoard = service.getKosdaqRankingTop(KosdaqTop10);
		model.addAttribute("kospiBoard", kospiBoard);
		model.addAttribute("kosdaqBoard", kosdaqBoard);
		
		log.info("지수 상세  정보 요청");

		List<StockPriceIndex> kospiIndexList = service.currentStockList("KOSPI");
		List<StockPriceIndex> kosdaqIndexList = service.currentStockList("KOSDAQ");
		List<StockPriceIndex> nasdaqIndexList = service.currentStockList("NASDAQ");
		model.addAttribute("kospiIndexList", kospiIndexList);
		model.addAttribute("kosdaqIndexList", kosdaqIndexList);
		model.addAttribute("nasdaqIndexList", nasdaqIndexList);
		
		
		log.info("주가 동향 요청");
		int page = 1;
		try {
			String searchValue = paramMap.get("searchValue");
			if (searchValue != null && searchValue.length() > 0) {
				paramMap.put("itmsNm", searchValue);
			}
			page = Integer.parseInt(paramMap.get("page"));
		} catch (Exception e) {}
		
		int stockCount = service.getStockCount(paramMap);
		PageInfo pageInfo = new PageInfo(page, 4, stockCount, 4);
		List<StockPrice> list = service.getStockList(pageInfo, paramMap);
		
		System.out.println(list);
		model.addAttribute("stockList", list);
		model.addAttribute("paramMap", paramMap);
		model.addAttribute("stockPageInfo", pageInfo);
		
		return "stock/stockList";	
	}
	
	
	
	
	@RequestMapping("/stockFuture")
	public String stockFuture(Model model,@RequestParam("no") int no) {
		
		StockPrice sp = service.findByNo(no);
		List<StockPrice> stockList=service.stockMoreViewList(no);
		model.addAttribute("sp", sp);
		model.addAttribute("stockList", stockList);
		return "stock/stockFuture";
	}
	
	@GetMapping("/stockBuying")
	public String stockBuying(Model model, @RequestParam Map<String, String> paramMap) {
		try {
			String stockNum = paramMap.get("stockNum");
			if (stockNum != null && stockNum.length() > 0) {
				paramMap.put("stockNum", stockNum);
			}
		} catch (Exception e) {}		
		List<InvestedStock> list = isService.getInvestedStockList(paramMap);
		model.addAttribute("list", list);
		
		return "stock/stockBuying";
	}
	
	
	
	// 펀드 페이지 요청 (주식형)
	@GetMapping("/stockFund")
	public String stockFund(Model model, @RequestParam Map<String, String> paramMap) {
		int page = 1;

		// 탐색할 맵을 선언
		Map<String, String> searchMap = new HashMap<String, String>();
		try {
			String searchValue = paramMap.get("searchValue");
			if (searchValue != null && searchValue.length() > 0) {
				paramMap.put("fndNm", searchValue);
			} else {
			}
			
			page = Integer.parseInt(paramMap.get("page"));
			 
		} catch (Exception e) {}
		
		int fundCount = service.getFundCount(paramMap);
		PageInfo pageInfo = new PageInfo(page, 10, fundCount, 10);
		List<FundProductInfo> list = service.getFundList(pageInfo, paramMap);	
		
		model.addAttribute("list", list);
		model.addAttribute("paramMap", paramMap);
		model.addAttribute("pageInfo", pageInfo);
		
		return "stock/stockFund";
	}
	// 펀드 페이지 요청 (채권형)
	@GetMapping("/stockFund02")
	public String stockFund02(Model model, @RequestParam Map<String, String> paramMap) {
		int page = 1;

		// 탐색할 맵을 선언
		Map<String, String> searchMap = new HashMap<String, String>();
		try {
			String searchValue = paramMap.get("searchValue");
			if (searchValue != null && searchValue.length() > 0) {
				paramMap.put("fndNm", searchValue);
			} else {
			}
			
			page = Integer.parseInt(paramMap.get("page"));
			 
		} catch (Exception e) {}
		
		int fundCount = service.getFundCount02(paramMap);
		PageInfo pageInfo = new PageInfo(page, 10, fundCount, 10);
		List<FundProductInfo> list = service.getFundList02(pageInfo, paramMap);	
		
		model.addAttribute("list", list);
		model.addAttribute("paramMap", paramMap);
		model.addAttribute("pageInfo", pageInfo);
		
		return "stock/stockFund02";
	}	
	// 펀드 페이지 요청 (혼합형)
	@GetMapping("/stockFund03")
	public String stockFund03(Model model, @RequestParam Map<String, String> paramMap) {
		int page = 1;

		// 탐색할 맵을 선언
		Map<String, String> searchMap = new HashMap<String, String>();
		try {
			String searchValue = paramMap.get("searchValue");
			if (searchValue != null && searchValue.length() > 0) {
				paramMap.put("fndNm", searchValue);
			} else {
			}
			
			page = Integer.parseInt(paramMap.get("page"));
			 
		} catch (Exception e) {}
		
		int fundCount = service.getFundCount03(paramMap);
		PageInfo pageInfo = new PageInfo(page, 10, fundCount, 10);
		List<FundProductInfo> list = service.getFundList03(pageInfo, paramMap);	
		
		model.addAttribute("list", list);
		model.addAttribute("paramMap", paramMap);
		model.addAttribute("pageInfo", pageInfo);
		
		return "stock/stockFund03";
	}
	// 펀드 페이지 요청 (재간접형)
	@GetMapping("/stockFund04")
	public String stockFund04(Model model, @RequestParam Map<String, String> paramMap) {
		int page = 1;

		// 탐색할 맵을 선언
		Map<String, String> searchMap = new HashMap<String, String>();
		try {
			String searchValue = paramMap.get("searchValue");
			if (searchValue != null && searchValue.length() > 0) {
				paramMap.put("fndNm", searchValue);
			} else {
			}
			
			page = Integer.parseInt(paramMap.get("page"));
			 
		} catch (Exception e) {}
		
		int fundCount = service.getFundCount04(paramMap);
		PageInfo pageInfo = new PageInfo(page, 10, fundCount, 10);
		List<FundProductInfo> list = service.getFundList04(pageInfo, paramMap);	
		
		model.addAttribute("list", list);
		model.addAttribute("paramMap", paramMap);
		model.addAttribute("pageInfo", pageInfo);
		
		return "stock/stockFund04";
	}
	
	@RequestMapping("/stockPredicate")
	public String stockPredicate() {
		return "stock/stockPredicate";
	}
	
	@RequestMapping("/stockFundDetail")
	public String stockFundDetail() {
		return "stock/stockFundDetail";
	}
	
	
	
	//매수
	@RequestMapping("/stockSelling")
	public String stockSelling(Model model,@RequestParam("no") int no, @SessionAttribute(name = "loginMember", required = false) Member loginMember) {
		
		log.info("리스트 요청");
		Map<String, String> KospiTop5 = new HashMap<String, String>();
		Map<String, String> KosdaqTop5 = new HashMap<String, String>();
		KospiTop5.put("limit", "5");
		KosdaqTop5.put("limit", "5");
		List<StockPrice> KOSPI = service.getKospiRankingTop(KospiTop5);
		List<StockPrice> KOSDAQ = service.getKosdaqRankingTop(KosdaqTop5);
		model.addAttribute("KOSPI", KOSPI);
		model.addAttribute("KOSDAQ", KOSDAQ);
		
		
		log.info("환율 테이블 요청: 원하는 국가만 가져옴");
		ExchangeRate USD = service.findExchangeRate("USD");
		ExchangeRate JPY = service.findExchangeRate("JPY(100)");
		ExchangeRate GBP = service.findExchangeRate("GBP");
		ExchangeRate HKD = service.findExchangeRate("HKD");
		ExchangeRate EUR = service.findExchangeRate("EUR");
		ExchangeRate CNH = service.findExchangeRate("CNH");
		ExchangeRate AUD = service.findExchangeRate("AUD");
		ExchangeRate SGD = service.findExchangeRate("SGD");
		ExchangeRate THB = service.findExchangeRate("THB");
		ExchangeRate CAD = service.findExchangeRate("CAD");
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
		
		
		StockPrice sp = service.findByNo(no);
		List<StockPrice> stockList=service.stockMoreViewList(no);
		model.addAttribute("sp", sp);
		model.addAttribute("stockList", stockList);
		
		
		//총자산
		int totalP=0;
		int basic = 10000000;
		
		try {
			Map<String, String> member = new HashMap<String, String>();
			member.put("id", loginMember.getId());
			List<InvestedStock> check = isService.getInvestedStockList(member);
			
			for (int i = 0; i <check.size(); i++) {
				totalP +=check.get(i).getTotalPrice();
				System.out.println(totalP);
			}
			int now = basic-totalP;
			int stockPrice = Integer.parseInt(sp.getClpr());
			int canBuy = now/stockPrice;
			model.addAttribute("stockPrice", stockPrice);
			model.addAttribute("now", now);
			model.addAttribute("canBuy", canBuy);
		} catch (Exception e) {}
		
		return "stock/stockSelling";
	}
	
	
	//매도
	@RequestMapping("/stockSell")
	public String stockSell(Model model,@RequestParam("no") int no, @SessionAttribute(name = "loginMember", required = false) Member loginMember) {
		
		log.info("리스트 요청");
		Map<String, String> KospiTop5 = new HashMap<String, String>();
		Map<String, String> KosdaqTop5 = new HashMap<String, String>();
		KospiTop5.put("limit", "5");
		KosdaqTop5.put("limit", "5");
		List<StockPrice> KOSPI = service.getKospiRankingTop(KospiTop5);
		List<StockPrice> KOSDAQ = service.getKosdaqRankingTop(KosdaqTop5);
		model.addAttribute("KOSPI", KOSPI);
		model.addAttribute("KOSDAQ", KOSDAQ);
		
		
		log.info("환율 테이블 요청: 원하는 국가만 가져옴");
		ExchangeRate USD = service.findExchangeRate("USD");
		ExchangeRate JPY = service.findExchangeRate("JPY(100)");
		ExchangeRate GBP = service.findExchangeRate("GBP");
		ExchangeRate HKD = service.findExchangeRate("HKD");
		ExchangeRate EUR = service.findExchangeRate("EUR");
		ExchangeRate CNH = service.findExchangeRate("CNH");
		ExchangeRate AUD = service.findExchangeRate("AUD");
		ExchangeRate SGD = service.findExchangeRate("SGD");
		ExchangeRate THB = service.findExchangeRate("THB");
		ExchangeRate CAD = service.findExchangeRate("CAD");
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
		
		
		StockPrice sp = service.findByNo(no);
		List<StockPrice> stockList=service.stockMoreViewList(no);
		model.addAttribute("sp", sp);
		model.addAttribute("stockList", stockList);
		
		
		//총자산
		int totalP=0;
		int basic = 10000000;
		try {
			Map<String, String> member = new HashMap<String, String>();
			member.put("id", loginMember.getId());
			List<InvestedStock> check = isService.getInvestedStockList(member);
			
			for (int i = 0; i <check.size(); i++) {
				totalP +=check.get(i).getTotalPrice();
				System.out.println(totalP);
			}
			int now = basic-totalP;
			int stockPrice = Integer.parseInt(sp.getClpr());
			int canBuy = now/stockPrice;
			model.addAttribute("stockPrice", stockPrice);
			model.addAttribute("now", now);
			model.addAttribute("canBuy", canBuy);
		} catch (Exception e) {}
		
		
		// 보유중인 주 개수 구하기
		int cnt=0;
		int baseOfStockPrice=0;
		try {
			Map<String, String> cMap = new HashMap<String, String>();
			cMap.put("id", loginMember.getId());
			List<InvestedStock> tot_count = isService.getInvestedStockList(cMap);
			
			for (int i = 0; i < tot_count.size(); i++) {
				if(tot_count.get(i).getTradeStat().equals("매수")) {
					cnt += tot_count.get(i).getCnt();
				}else {
					cnt -= tot_count.get(i).getCnt();
				}
			}
			System.out.println("cnt: " + cnt);
			baseOfStockPrice = cnt * 64000;
			model.addAttribute("cnt", cnt);
			model.addAttribute("base", baseOfStockPrice);
		} catch (Exception e) {}
		
		
		
		
		
		return "stock/stockSell";
	}
	
	
	//사기
	@RequestMapping("/selling")
	public String selling(Model model,	@ModelAttribute InvestedStock istock,
			@SessionAttribute(name = "loginMember", required = false) Member loginMember) {
			
		int result = isService.saveInvestedStock(istock);
		if(result > 0) {
			model.addAttribute("msg", "구매가 완료되었습니다.");
			model.addAttribute("location", "/stock/stockTest");
		}else {
			model.addAttribute("msg", "구매에 실패하였습니다.");
			model.addAttribute("location", "/stock/stockTest");
		}
		return "common/msg";
	}
		
	//팔기
	@RequestMapping("/realSell")
	public String realSell(Model model,	@ModelAttribute InvestedStock istock,
			@SessionAttribute(name = "loginMember", required = false) Member loginMember) {
			
		int result = isService.saveInvestedStock(istock);
		if(result > 0) {
			model.addAttribute("msg", "판매가 완료되었습니다.");
			model.addAttribute("location", "/stock/stockTest");
		}else {
			model.addAttribute("msg", "판매에 실패하였습니다.");
			model.addAttribute("location", "/stock/stockTest");
		}
		return "common/msg";
	}
	
	
	
	
	
	/*계좌 생성코드*/
	@RequestMapping("/createAccount")
	public String createAccount (Model model,
			@SessionAttribute(name = "loginMember", required = false) Member loginMember) {
		
		int mNo =  loginMember.getMNo();
		int result=	aService.saveInvestedStock(mNo);
		int result2 = aService.updateAccount(mNo);
		
		if(result > 0 && result2 >0) { 
			model.addAttribute("msg", "계좌 생성에 성공하였습니다.");
			model.addAttribute("location", "/stock/stockTest");
		}else { // 실패
			model.addAttribute("msg", "계좌 생성 실패하셨습니다. 계좌가 이미 생성되어있는지 확인해주세요.");
			model.addAttribute("location", "/stock/stockTest");
		}
		return "common/msg";
	}
	
	
	
	@GetMapping("/stockTest")
	public String stockTest(Model model, @SessionAttribute(name = "loginMember", required = false) Member loginMember,
			@RequestParam Map<String, String> paramMap) {
		
		log.info("리스트 요청");
		Map<String, String> KospiTop5 = new HashMap<String, String>();
		Map<String, String> KosdaqTop5 = new HashMap<String, String>();
		Map<String, String> rec = new HashMap<String, String>(); // 추천 주식 담는 Map
		KospiTop5.put("limit", "5");
		KosdaqTop5.put("limit", "5");
		List<StockPrice> KOSPI = service.getKospiRankingTop(KospiTop5);
		List<StockPrice> KOSDAQ = service.getKosdaqRankingTop(KosdaqTop5);
		List<StockPrice> recStock = service.getRecStockList(rec); // 추천 주식
		
		int page = 1;
		int totalP = 0;	// 총 자산
		int cnt = 0;	// 보유중인 주 개수
		int baseOfStockPrice = 0;	//  cnt * 현재주식가(64000원)
		// 탐색할 맵을 선언
		try {
			String searchValue = paramMap.get("searchValue");
			if (searchValue != null && searchValue.length() > 0) {
				paramMap.put("itmsNm", searchValue);
			} else {
			}
			
			page = Integer.parseInt(paramMap.get("page"));
			 
		} catch (Exception e) {}
		
		int stockCount = service.getCountStockListByRank(paramMap);
		PageInfo pageInfo = new PageInfo(page, 10, stockCount, 10);
		List<StockPrice> allStock = service.getStockListByRank(pageInfo, paramMap);
		
		model.addAttribute("allStock", allStock);
		model.addAttribute("recStock", recStock);
		model.addAttribute("paramMap", paramMap);
		model.addAttribute("pageInfo", pageInfo);
		
		model.addAttribute("recStock", recStock);
		model.addAttribute("KOSPI", KOSPI);
		model.addAttribute("KOSDAQ", KOSDAQ);
		
		//총자산
		try {
			Map<String, String> member = new HashMap<String, String>();
			member.put("id", loginMember.getId());
			List<InvestedStock> check = isService.getInvestedStockList(member);
			
			for (int i = 0; i <check.size(); i++) {
				totalP +=check.get(i).getTotalPrice();
				System.out.println(totalP);
			}
			
			
			model.addAttribute("totalP", totalP);
			
		} catch (Exception e) {}
		// 보유중인 주 개수 구하기
		try {
			Map<String, String> cMap = new HashMap<String, String>();
			cMap.put("id", loginMember.getId());
			List<InvestedStock> tot_count = isService.getInvestedStockList(cMap);
			
			for (int i = 0; i < tot_count.size(); i++) {
				if(tot_count.get(i).getTradeStat().equals("매수")) {
					cnt += tot_count.get(i).getCnt();
				}else {
					cnt -= tot_count.get(i).getCnt();
				}
			}
			System.out.println("cnt: " + cnt);
			baseOfStockPrice = cnt * 64000;
			model.addAttribute("cnt", cnt);
			model.addAttribute("base", baseOfStockPrice);
		} catch (Exception e) {}
		
		
		try {
			Map<String, String> myStockMap = new HashMap<String, String>();
			myStockMap.put("id", loginMember.getId());
			List<InvestedStock> myStock = isService.getInvestedStockList(myStockMap);
			List<Integer> totalPrice = isService.getTotalPrice(myStockMap);
			
			Map<String, String> myAccountMap = new HashMap<String, String>();
			myAccountMap.put("id", loginMember.getId());
			List<Account> myAcc = aService.getAccountList(myAccountMap);
			
			model.addAttribute("myStock", myStock);
			model.addAttribute("totalPrice", totalPrice);
			model.addAttribute("myAcc", myAcc);
		} catch (Exception e) {}
		
		log.info("보유주식리스트 뽑기");
		//보유주식
		try {
			Map<String, String> getId = new HashMap<String, String>();
			getId.put("id", loginMember.getId());
			List<InvestedStock> nowStock = isService.getInvestedStockList2(getId);
			model.addAttribute("nowStock", nowStock);
		} catch (Exception e) {	}
		
		
		log.info("환율 테이블 요청: 원하는 국가만 가져옴");
		ExchangeRate USD = service.findExchangeRate("USD");
		ExchangeRate JPY = service.findExchangeRate("JPY(100)");
		ExchangeRate GBP = service.findExchangeRate("GBP");
		ExchangeRate HKD = service.findExchangeRate("HKD");
		ExchangeRate EUR = service.findExchangeRate("EUR");
		ExchangeRate CNH = service.findExchangeRate("CNH");
		ExchangeRate AUD = service.findExchangeRate("AUD");
		ExchangeRate SGD = service.findExchangeRate("SGD");
		ExchangeRate THB = service.findExchangeRate("THB");
		ExchangeRate CAD = service.findExchangeRate("CAD");
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
		
		return "stock/stockTest";
	}
	
	

	@GetMapping("/stockRest/{id}")
	public ResponseEntity<List<Double>> getStockInfo(@PathVariable("id") String id)
	{		
		List<Double> list = new ArrayList<>();
		if(id.equalsIgnoreCase("KOSPI")) {
			List<StockPriceIndex> kospi =service.getStockList("KOSPI");
			for (int i = 0; i < kospi.size(); i++) {
				String realNum = (kospi.get(i).getFin()).replaceAll(",", "");
				double stockNum = Double.parseDouble(realNum);
				list.add(stockNum);
			}
		}else if (id.equalsIgnoreCase("KOSDAQ")) {
			List<StockPriceIndex> kosdaq =service.getStockList("KOSDAQ");
			for (int i = 0; i < kosdaq.size(); i++) {
				String realNum = (kosdaq.get(i).getFin()).replaceAll(",", "");
				double stockNum = Double.parseDouble(realNum);
				list.add(stockNum);
			}
		}else if (id.equalsIgnoreCase("NASDAQ")) {
			List<StockPriceIndex> nasdaq =service.getStockList("NASDAQ");
			for (int i = 0; i < nasdaq.size(); i++) {
				String realNum = (nasdaq.get(i).getFin()).replaceAll(",", "");
				double stockNum = Double.parseDouble(realNum);
				list.add(stockNum);
			}
		}else if (id.equalsIgnoreCase("USD")) {
			List<ExchangeRate> USD =service.StockPricefindByName("USD");
			for (int i = 0; i < USD.size(); i++) {
				String realNum = (USD.get(i).getDealBasR()).replaceAll(",", "");
				double stockNum = Double.parseDouble(realNum);
				list.add(stockNum);
			}
		}else if (id.equalsIgnoreCase("JPY")) {
			List<ExchangeRate> JPY =service.StockPricefindByName("JPY");
			for (int i = 0; i < JPY.size(); i++) {
				String realNum = (JPY.get(i).getDealBasR()).replaceAll(",", "");
				double stockNum = Double.parseDouble(realNum);
				list.add(stockNum);
			}
		}else if (id.equalsIgnoreCase("SS")) {
			List<StockPrice> SS =service.stockPriceList("삼성전자");
			for (int i = 0; i < SS.size(); i++) {
				String realNum = (SS.get(i).getClpr()).replaceAll(",", "");
				double stockNum = Double.parseDouble(realNum);
				list.add(stockNum);
			}
		}else if (id.equalsIgnoreCase("SK")) {
			List<StockPrice> SK =service.stockPriceList("SK하이닉스");
			for (int i = 0; i < SK.size(); i++) {
				String realNum = (SK.get(i).getClpr()).replaceAll(",", "");
				double stockNum = Double.parseDouble(realNum);
				list.add(stockNum);
			}
		}else if (id.equalsIgnoreCase("LG")) {
			List<StockPrice> LG =service.stockPriceList("LG에너지솔루션");
			for (int i = 0; i < LG.size(); i++) {
				String realNum = (LG.get(i).getClpr()).replaceAll(",", "");
				double stockNum = Double.parseDouble(realNum);
				list.add(stockNum);
			}
		}else if(id!=null) {
			List<StockPrice> stockGraph =service.stockPriceList(id);
			for (int i = 0; i < stockGraph.size(); i++) {
				String realNum = (stockGraph.get(i).getClpr()).replaceAll(",", "");
				double stockNum = Double.parseDouble(realNum);
				list.add(stockNum);
			}
		}
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	
	
}
