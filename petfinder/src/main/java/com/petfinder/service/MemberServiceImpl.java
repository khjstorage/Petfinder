package com.petfinder.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.petfinder.dao.MemberDAO;
import com.petfinder.utill.MemberFileUtils;
import com.petfinder.vo.MemberVO;
/**
 * 회원정보 CRUD 요청을 처리하는 비즈니스 클래스
 * 
 * @author  1조
 * @since 2016.11.14
 * @version 1.0
 * @see <pre>
 *  == 개정이력(Modification Information) ==
 *   
 *          수정일          수정자           수정내용
 *  ----------------    ------------    ---------------------------
 *   2016.11.14        1조             최초 생성
 * 
 * </pre>
 */
@Service("memberService")
public class MemberServiceImpl implements MemberService {

	@Resource(name="memberfileUtils")
	private MemberFileUtils memberfileUtils;

	@Resource(name="memberDao")
	private MemberDAO memberDao;

	
	/**
	 * 아이디 패스워드 확인 요청을 처리하기 위해 데이터처리를 요청한다.
	 * 
	 * @param HashMap<String, String> map / id, pwd
	 * @return String
	 * @throws 
	 */
	@Override
	public String loginMember(HashMap<String, String> map){
		List<MemberVO> list = memberDao.loginMember(map);
		String idcheck;
		if(list.size()==0){
			idcheck="";
		}else{
			idcheck=list.get(0).getId();
		}
		return idcheck;
	}

	@Override
	public List<MemberVO> getMember(String sessionId) throws Exception {
		return memberDao.getMember(sessionId);
	}
	
	@Override
	public void insertMember(MemberVO memberVO, HttpServletRequest request) throws Exception {
		memberDao.insertMember(memberVO);
		Map<String,Object> mapFile = memberfileUtils.parseInsertFileInfo(memberVO, request);
		if(mapFile!=null){
			memberDao.insertFile(mapFile);
		}
	}


	@Override
	public void updateMember(MemberVO memberVO, HttpServletRequest request) throws Exception{
		memberDao.updateMember(memberVO);
		Map<String,Object> mapFile = memberfileUtils.parseInsertFileInfo(memberVO, request);
		if(mapFile!=null){
			memberDao.updateMemberFile(mapFile);
		}
	}

	@Override
	public void deleteMember(String id){
		memberDao.deleteMemberFile(id);
		memberDao.deleteMember(id);
	}
}
