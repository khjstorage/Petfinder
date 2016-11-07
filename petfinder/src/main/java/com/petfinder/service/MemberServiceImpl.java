package com.petfinder.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.petfinder.dao.MemberDAO;
import com.petfinder.utill.FileUtils;
import com.petfinder.vo.MemberVO;

@Service("memberService")
public class MemberServiceImpl implements MemberService {

    @Resource(name="fileUtils")
    private FileUtils fileUtils;
	
	@Resource(name="memberDao")
	private MemberDAO memberDao;

	@Override
	public void insertMember(MemberVO memberVO, HttpServletRequest request) throws Exception {
		memberDao.insertMember(memberVO);
        Map<String,Object> mapFile = fileUtils.parseInsertFileInfo(memberVO, request);
        memberDao.insertFile(mapFile);
	}

	@Override
	public List<MemberVO> getMember(MemberVO memberVO) throws Exception {
		return  memberDao.getMember(memberVO);
	}

	@Override
	public void updateMember(String id) {
		// TODO Auto-generated method stub
	}

	@Override
	public void deleteMember(String id) {
		// TODO Auto-generated method stub

	}


}
