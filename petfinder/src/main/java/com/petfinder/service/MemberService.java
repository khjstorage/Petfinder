package com.petfinder.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.petfinder.vo.MemberVO;

public interface MemberService {
	public void updateMember(String name);
	public void deleteMember(String name);
	public ArrayList<MemberVO> getMembers();
	public void insertMember(MemberVO memberVO, HttpServletRequest request) throws Exception;
}

