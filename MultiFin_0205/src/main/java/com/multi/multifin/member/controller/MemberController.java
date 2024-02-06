package com.multi.multifin.member.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.multi.multifin.account.model.service.AccountService;
import com.multi.multifin.account.model.vo.Account;
import com.multi.multifin.board.model.service.BoardService;
import com.multi.multifin.board.model.vo.Board;
import com.multi.multifin.common.util.PageInfo;
import com.multi.multifin.member.model.service.MemberService;
import com.multi.multifin.member.model.vo.Member;
import com.multi.multifin.member.model.vo.MemberForm;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;


@Slf4j // 
@SessionAttributes("loginMember")
@RequestMapping("/member")
@Controller
public class MemberController {

	@Autowired
	private MemberService service;
	@Autowired
	private BoardService boardService;
	@Autowired
	private AccountService accountservice;
	final static private String savePath = "c:\\multifin\\";
	
	
	@GetMapping("/forgot-password")
	public String forgotPassword() {
		return "member/forgot-password";
	}
	
	@PostMapping("/forgot-password")
	public String updatePwd(Model model,
//			@SessionAttribute(name = "loginMember", required = false) Member loginMember,
			String email, String answer1, String answer2, String password
			) { 
		System.out.println("email : " + email);
		System.out.println("answer1 : " + answer1);
		System.out.println("answer2 : " + answer2);
		System.out.println("password : " + password);

		String userAnswer = answer1 + answer2;
		
		Member member = service.findByEmail(email);
		
		if(member.getPasswordAnswer().equals(userAnswer)) {
			int result = service.updatePwd(member, password);
			if(result > 0) {
				model.addAttribute("msg", "비밀번호 수정에 성공하였습니다.");
			}else{
				model.addAttribute("msg", "비밀번호 변경에 실패했습니다.");
			}
		}else {
			model.addAttribute("msg", "정답이 다릅니다.");
		}
		
		model.addAttribute("location", "/member/forgot-password");
		
		return "/common/msg";
	}
	
	
	@GetMapping("/sign-in")
	public String signIn() {
		return "member/sign-in";
	}
	
	@PostMapping("/login")
	String login(Model model, String email, String userPwd) {
		log.info("id : " + email + ", pwd : " + userPwd);
		Member loginMember = service.login(email, userPwd);
		
		if(loginMember != null) { // 성공
			model.addAttribute("loginMember", loginMember);
			return "redirect:/";
		}else { // 실패
			model.addAttribute("msg", "아이디 패스워드가 잘못되었습니다.");
			model.addAttribute("location", "/");
			return "common/msg";
		}
	}
	
	@GetMapping("/logout")
	public String logout(SessionStatus status) { // status : 세션의 상태 확인과 해제가 가능한 클래스
		log.info("status : " + status.isComplete());
		status.setComplete();
		log.info("status : " + status.isComplete());
		return "redirect:/";
	}
	
	@GetMapping("/sign-up")
	public String signupPage() {
		log.info("가입 페이지 요청");
		return "member/sign-up";
	}
	
	@PostMapping("/sign-up")
	public String enroll(Model model, @Validated MemberForm memberForm, BindingResult bindingResult) {
		log.info("회원가입, MemberForm : " + memberForm.toString());
		
		if(bindingResult.hasErrors()) {
			model.addAttribute("msg","회원가입 실패 : " + bindingResult.getAllErrors().get(0).getDefaultMessage());
			model.addAttribute("location", "/member/sign-up");
			return "common/msg";
		}
		
		Member member = memberForm.toMember();
		
		System.out.println(member);
		
		int result=0;
		try {
			result = service.save(member);
		} catch (Exception e) {
			
		}
		
		if(result > 0) { // 성공
			model.addAttribute("msg", "회원가입에 성공하였습니다.");
			model.addAttribute("location", "/");
		}else { // 실패
			model.addAttribute("msg", "회원가입에 실패하였습니다. 입력정보를 확인하세요.");
			model.addAttribute("location", "/member/sign-up");
		}
		return "common/msg";
	}
	
	// AJAX 회원아이디 중복 검사부
	@GetMapping("/emailCheck")
	public ResponseEntity<Map<String, Object>> emailCheck(String email){
		log.info("아이디 중복 확인 : " + email);
		
		boolean result = service.validate(email);
		Map<String,	Object> map = new HashMap<String, Object>();
		map.put("validate", result);
		
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	
	//회원정보 수정 
	@GetMapping("/mypage")
	public String mypage() {
		return "member/mypage";
	}
	
	@GetMapping("/update")
	public String update() {
		return "member/mypage";
	}
	
	@PostMapping("/update")
	public String update(Model model, 
			@ModelAttribute Member updateMember,
			@SessionAttribute(name = "loginMember", required = false) Member loginMember 
			) {
		log.info("update 요청, updateMember : " + updateMember);
		if(loginMember == null) {
			model.addAttribute("msg","잘못된 접근입니다.");
			model.addAttribute("location","/");
			return "common/msg";
		}
		
		updateMember.setMNo(loginMember.getMNo());
		updateMember.setPassword(loginMember.getPassword());
		int result = service.save(updateMember);
		
		if(result > 0) {
			model.addAttribute("msg", "회원정보를 수정하였습니다.");
			model.addAttribute("loginMember", service.findByEmail(loginMember.getEmail()));
			log.info("세션: " + loginMember.toString());
			model.addAttribute("location", "/member/update");
		}else {
			model.addAttribute("msg", "회원정보 수정에 실패하였습니다.");
			model.addAttribute("location", "/member/update");
		}
		return "common/msg";
	}
	
	
	@RequestMapping("/delete")
	public String delete(Model model,
			@SessionAttribute(name = "loginMember", required = false) Member loginMember) {
		log.info("페이지 전송됨");
		log.info("체크"+ loginMember.getMNo());
		int result = service.delete(loginMember.getMNo());
		if(result > 0) {
			model.addAttribute("msg", "회원탈퇴에 성공하였습니다.");
			model.addAttribute("location","/member/logout");
		}else {
			model.addAttribute("msg", "회원탈퇴에 실패하였습니다.");
			model.addAttribute("location","/member/update");
		}
		return  "common/msg";
	}
	
	
	//내글 보기
	@GetMapping("/mywrite")
	public String mywrite(Model model,
			@SessionAttribute(name = "loginMember", required = false) Member loginMember,
			@RequestParam Map<String, String> paramMap) {
		int page = 1;
		try {
			page = Integer.parseInt(paramMap.get("page"));
		} catch (Exception e) {}
		Map<String, String> searchMap = new HashMap<String, String>();
		searchMap.put("id", loginMember.getId());
		int boardCount = boardService.getMyBoardCount(loginMember.getId());
		System.out.println("dhkdhkdd: " +  boardCount);
		PageInfo pageInfo = new PageInfo(page, 5, boardCount, 10);
		List<Board> list = boardService.getMyBoardList(pageInfo, searchMap);
		
		
		model.addAttribute("list", list);
		model.addAttribute("pageInfo", pageInfo);
		return "member/mywrite";
	}
	
	
	//글 히나씩 지우기
	@RequestMapping("/boardDelete")
	public String deleteBoard(Model model,  HttpSession session,
			@SessionAttribute(name = "loginMember", required = false) Member loginMember,
			int boardNo
			) {
		log.info("게시글 삭제 요청 boardNo : " + boardNo);
		int result = boardService.deleteBoard(boardNo, savePath);
		
		if(result > 0) {
			model.addAttribute("msg", "게시글 삭제가 정상적으로 완료되었습니다.");
		}else {
			model.addAttribute("msg", "게시글 삭제에 실패하였습니다.");
		}
		model.addAttribute("location", "/member/mywrite");
		return "common/msg";
	}
	

	//내 글 다 지우기
	@RequestMapping("/boardAllDelete")
	public String deleteAllBoard(Model model, HttpSession session,
			@SessionAttribute(name = "loginMember", required = false) Member loginMember) {
		int mNo = loginMember.getMNo();
		int result = boardService.deleteAllMyBoard(mNo);
		if(result > 0) {
			model.addAttribute("msg", "게시글 전체가 정상적으로 완료되었습니다.");
		}else {
			model.addAttribute("msg", "게시글 삭제에 실패하였습니다.");
		}
		model.addAttribute("location", "/member/mywrite");
		return "common/msg";
	}
	
	//내댓글 보기
	@GetMapping("/myreply")
	public String myreply(Model model,
			@SessionAttribute(name = "loginMember", required = false) Member loginMember,
			@RequestParam Map<String, String> paramMap) {
		int page = 1;
		try {
			page = Integer.parseInt(paramMap.get("page"));
		} catch (Exception e) {}
		Map<String, String> searchMap = new HashMap<String, String>();
		searchMap.put("id", loginMember.getId());
		int boardCount = boardService.getMyBoardCount(loginMember.getId());
		System.out.println("dhkdhkdd: " +  boardCount);
		PageInfo pageInfo = new PageInfo(page, 5, boardCount, 10);
		List<Board> list = boardService.selectMyReplyList(pageInfo, searchMap);
		
		
		model.addAttribute("list", list);
		model.addAttribute("pageInfo", pageInfo);
		return "member/myreply";
	}
	
	// 댓글 히나씩 지우기
	@RequestMapping("/replyDelete")
	public String deleteReply(Model model,  HttpSession session,
		@SessionAttribute(name = "loginMember", required = false) Member loginMember, int replyNo) {
		log.info("게시글 삭제 요청 boardNo : " + replyNo);
		int result = boardService.deleteReply(replyNo);
		
		if(result > 0) {
			model.addAttribute("msg", "댓글 삭제가 정상적으로 완료되었습니다.");
		}else {
			model.addAttribute("msg", "댓글 삭제에 실패하였습니다.");
		}
		model.addAttribute("location", "/member/myreply");
		return "common/msg";
	}
		

	//내 댓글 다 지우기
	@RequestMapping("/replyAllDelete")
	public String deleteAllReply(Model model, HttpSession session,
			@SessionAttribute(name = "loginMember", required = false) Member loginMember) {
		String id = loginMember.getId();
		int result = boardService.deleteAllMyReply(id);
		if(result > 0) {
			model.addAttribute("msg", "게시글 전체가 정상적으로 완료되었습니다.");
		}else {
			model.addAttribute("msg", "게시글 삭제에 실패하였습니다.");
		}
		model.addAttribute("location", "/member/myreply");
		return "common/msg";
	}
	
	
		
	
	//내계좌보기
	@GetMapping("/account")
	public String account(Model model,
			@SessionAttribute(name = "loginMember", required = false) Member loginMember) {
		return "member/account";
	}
		
}




















