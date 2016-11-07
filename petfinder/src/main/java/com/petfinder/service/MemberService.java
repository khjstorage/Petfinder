package com.petfinder.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.petfinder.vo.MemberVO;

public interface MemberService {
	public List<MemberVO> getMember(MemberVO memberVO) throws Exception;
	public void insertMember(MemberVO memberVO, HttpServletRequest request) throws Exception;
	public void updateMember(String id);
	public void deleteMember(String id);
}

