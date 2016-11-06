package com.petfinder.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

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
		
//		Logger log = Logger.getLogger(this.getClass());
//		MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
//		Iterator<String> iterator = multipartHttpServletRequest.getFileNames();
//		MultipartFile multipartFile = null;
//		while (iterator.hasNext()) {
//			multipartFile = multipartHttpServletRequest.getFile(iterator.next());
//			if (multipartFile.isEmpty() == false) {
//				log.debug("------------- file start -------------");
//				log.debug("name : " + multipartFile.getName());
//				log.debug("filename : " + multipartFile.getOriginalFilename());
//				log.debug("size : " + multipartFile.getSize());
//				log.debug("-------------- file end --------------\n");
//			}
//		}
	}

	@Override
	public ArrayList<MemberVO> getMember(MemberVO memberVO) throws Exception {
		return (ArrayList<MemberVO>) memberDao.getMember(memberVO);
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
