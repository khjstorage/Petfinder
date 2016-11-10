package com.petfinder.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.petfinder.dao.MemberDAO;
import com.petfinder.utill.MemberFileUtils;
import com.petfinder.vo.MemberVO;

@Service("memberService")
public class MemberServiceImpl implements MemberService {

	@Resource(name="memberfileUtils")
	private MemberFileUtils memberfileUtils;

	@Resource(name="memberDao")
	private MemberDAO memberDao;

	@Override
	public String loginMember(String id, String pwd){
		List<MemberVO> list =memberDao.getID(id, pwd);
		String idcheck;
		if(list.size()==0){
			idcheck="";
		}else{
			idcheck=list.get(0).getId();
		}
		return idcheck;
	}

	@Override
	public void insertMember(MemberVO memberVO, HttpServletRequest request) throws Exception {
		memberDao.insertMember(memberVO);
		Map<String,Object> mapFile = memberfileUtils.parseInsertFileInfo(memberVO, request);
		memberDao.insertFile(mapFile);
	}

	@Override
	public List<MemberVO> getMember(String sessionId) throws Exception {
		return memberDao.getMember(sessionId);
	}

	@Override
	public void updateMember(String id) {
	}

	@Override
	public void deleteMember(String id) {
	}


}
