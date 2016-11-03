package com.petfinder.service;

import java.util.ArrayList;
import java.util.Iterator;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.petfinder.dao.MemberDAO;
import com.petfinder.vo.MemberVO;



@Service("memberService")
public class MemberServiceImpl implements MemberService {

	@Resource(name="memberDao")
	private MemberDAO memberDao;

	@Override
	public void insertMember(MemberVO memberVO) {
		memberDao.insertMember(memberVO);
	}


	@Override
	public ArrayList<MemberVO> getMembers() {
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
