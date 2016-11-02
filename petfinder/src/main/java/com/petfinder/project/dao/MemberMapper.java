package com.petfinder.project.dao;

import java.util.ArrayList;

import com.petfinder.project.dto.MemberDto;

public interface MemberMapper {

	//ȸ������
	public void signupDao(MemberDto memberDto);
	
	//ȸ����������
	public ArrayList<MemberDto> getMembers();
	
	//ȸ����������
	public void updateMember(String name);
    
	//ȸ��Ż��
	public void deleteMember(String name);
}
