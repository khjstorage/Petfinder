package com.petfinder.service;

import java.util.ArrayList;
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
		
		/*Logger log = Logger.getLogger(this.getClass());
		
		MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
		Iterator<String> iterator = multipartHttpServletRequest.getFileNames();
		MultipartFile multipartFile = null;
		while (iterator.hasNext()) {
			multipartFile = multipartHttpServletRequest.getFile(iterator.next());
			if (multipartFile.isEmpty() == false) {
				log.debug("------------- file start -------------");
				log.debug("name : " + multipartFile.getName());
				log.debug("filename : " + multipartFile.getOriginalFilename());
				log.debug("size : " + multipartFile.getSize());
				log.debug("-------------- file end --------------\n");
			}
		}
		*/
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
