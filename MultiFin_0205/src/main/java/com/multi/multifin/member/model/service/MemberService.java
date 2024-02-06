package com.multi.multifin.member.model.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.multi.multifin.member.model.mapper.MemberMapper;
import com.multi.multifin.member.model.vo.Member;


@Service
public class MemberService {

	@Autowired
	private MemberMapper mapper;
	
	private BCryptPasswordEncoder pwEncoder = new BCryptPasswordEncoder();
	
	public Member login(String email, String pw) {
		Member member = mapper.selectByEmail(email);
		if(member == null) {
			member = mapper.selectMember(email);
			if(member == null) {
				return null;
			}
		}
		
		// passwordEncoder 활용법
		System.out.println(member.getPassword()); // hash로 암호화된 코드가 들어있다.
		System.out.println(pwEncoder.encode(pw)); // encode를 통해 평문에서 hash 코드로 변환
		System.out.println(pwEncoder.matches(pw, member.getPassword())); // 평문 변환하고 비교까지
		
		if(email.equals("admin@test.com")) { // admin 테스트를 위한 코드
			return member;
		}
		
		if(member != null && pwEncoder.matches(pw, member.getPassword()) == true) {
			// 성공
			return member;
		}else {
			// 로그인 실패
			return null;
		}
	}
	

	@Transactional(rollbackFor = Exception.class)
	public int save(Member member) {
		int result = 0;
		if(member.getMNo() == 0) { // 회원가입
			String encodePW = pwEncoder.encode(member.getPassword());
			member.setPassword(encodePW);
			result = mapper.insertMember(member);
		}else { // 회원 수정
			result = mapper.updateMember(member);
		}
		return result;
	}
	
	public boolean validate(String email) {
		Member member = mapper.selectByEmail(email);
		return member != null;
	}
	
	public Member findById(String id) {
		return mapper.selectMember(id);
	}
	public Member findByEmail(String email) {
		return mapper.selectByEmail(email);
	}

	
	@Transactional(rollbackFor = Exception.class)
	public int delete(int no) {
		return mapper.deleteMember(no);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public int updatePwd(Member loginMember, String userPW) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("mNo", "" + loginMember.getMNo());
		map.put("password", pwEncoder.encode(userPW));
		return mapper.updatePwd(map);
	}
	
}
