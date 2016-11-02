package com.petfinder.project.dao;

import java.util.ArrayList;

import com.petfinder.project.dto.DisappearanceDto;
import com.petfinder.project.dto.FindsDto;
import com.petfinder.project.dto.MemberDto;

public interface IDao {
	
	//회원가입
	public void signupDao(MemberDto memberDto);
	
	//게시판
	public ArrayList<DisappearanceDto> disapprDao();
	public ArrayList<FindsDto> findsDao();
	
	//작성
	public void writeDisapprDao(DisappearanceDto disapprDto);
	public void writeFindsDao(FindsDto findsDto);
	
	//게시물
	public DisappearanceDto viewDisapprDao(String pId);
	public FindsDto viewFindsDao(String pId);
	
	//삭제, 수정
	public void deleteDao(String pId);
	public void modifyDisapprDao(DisappearanceDto disapprDto);
	public void modifyFindsDao(FindsDto findsDto);	
	
	//회원가입, 로그인, 회원수정
	//public void loginDao(MemberDto memberDto);
	public void modifyMemberDao(MemberDto memberDto);
}
