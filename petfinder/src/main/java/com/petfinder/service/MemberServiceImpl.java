package com.petfinder.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.petfinder.dao.MemberDao;
import com.petfinder.dto.MemberDto;


@Service("memberService")
public class MemberServiceImpl implements MemberService {
    
    @Resource(name="memberDao")
    private MemberDao memberDao;
    
	@Override
	public void insertMember(Model model) {
		memberDao.insertMember(model);
	}
    
	@Override
	public ArrayList<MemberDto> getMembers() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void updateMember(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMember(String name) {
		// TODO Auto-generated method stub
		
	}


}
