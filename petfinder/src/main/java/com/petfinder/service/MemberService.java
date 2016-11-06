package com.petfinder.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.petfinder.vo.MemberVO;

public interface MemberService {
	public ArrayList<MemberVO> getMember();
	public void insertMember(MemberVO memberVO, HttpServletRequest request) throws Exception;
	public void updateMember(String name);
	public void deleteMember(String name);
	
	
}

