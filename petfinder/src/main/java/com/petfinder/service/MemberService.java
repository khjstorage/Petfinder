package com.petfinder.service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.petfinder.vo.MemberVO;

public interface MemberService {
	public List<MemberVO> getMember(String sessionId) throws Exception;
	public void insertMember(MemberVO memberVO, HttpServletRequest request) throws Exception;
	public void updateMember(MemberVO memberVO, HttpServletRequest requesr) throws Exception;
	public void deleteMember(String id);
	public String loginMember(HashMap<String, String> map);
}


