package com.petfinder.project.dao;

import java.util.ArrayList;

import com.petfinder.project.dto.MemberDto;

public interface MemberMapper {

	//회원가입
	public void signupDao(MemberDto memberDto);
	
	//회원정보보기
	public ArrayList<MemberDto> getMembers();
	
	//회원정보수정
	public void updateMember(String name);
    
	//회원탈퇴
	public void deleteMember(String name);
}
