package com.petfinder.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.petfinder.dao.DisappearanceDAO;
import com.petfinder.utill.DisappearanceFileUtils;
import com.petfinder.vo.DisappearanceVO;
import com.petfinder.vo.FindsVO;
import com.petfinder.vo.PagingVO;
/**
 * 분실정보 CRUD 요청을 처리하는 비즈니스 클래스
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
@Service("disappearanceService")
public class DisappearanceServiceImpl implements DisappearanceService {
	
    @Resource(name="disappearanceFileUtils")
    private DisappearanceFileUtils disappearanceFileUtils;
	
	@Resource(name="disappearanceDAO")
	private DisappearanceDAO disappearanceDAO;

		
	/**
	 * 분실게시판 (리스트) 요청을 처리하기 위해 데이터처리를 요청한다.
	 * 
	 * @param 
	 * @return List
	 * @throws 
	 */
	@Override
	public List<DisappearanceVO> disappearanceList() {
		return disappearanceDAO.disappearanceList();
	}


	/**
	 * 분실게시판 (상세글) 요청을 처리하기 위해 데이터처리를 요청한다.
	 * 
	 * @param String pIdx
	 * @return Map<String, Object>
	 * @throws Exception
	 */
	@Override
	public Map<String, Object> selectBoardDetail(String pIdx)throws Exception {
		Map<String, Object> resultMap = new HashMap<String, Object>(); 
		
		Map<String, Object> map = disappearanceDAO.selectBoardDetail(pIdx);
		resultMap.put("infoMap", map);
		
		List<Object> fileMap = disappearanceDAO.selectBoardDetailFile(pIdx);
		resultMap.put("fileMap", fileMap);
	    
	    return resultMap;
	}
	
	
	/**
	 * 분실게시판 (입력) 요청을 처리하기 위해 데이터처리를 요청한다.
	 * 
	 * @param DisappearanceVO disappearanceVO, HttpServletRequest request
	 * @return void
	 * @throws Exception
	 */
	@Override
	public void insertDisappearance(DisappearanceVO disappearanceVO, HttpServletRequest request) throws Exception {
		disappearanceDAO.insertDisappearance(disappearanceVO);
		Map<String,Object> mapFile = disappearanceFileUtils.parseInsertFileInfo(disappearanceVO, request);
		if(mapFile!=null){
			disappearanceDAO.insertDisappearanceFile(mapFile);
		}
		
 	        	             
	}

	/**
	 * 분실게시판 (수정) 요청을 처리하기 위해 데이터처리를 요청한다.
	 * 
	 * @param DisappearanceVO disappearanceVO, HttpServletRequest request
	 * @return void
	 * @throws Exception
	 */
	@Override
	public void updateDisappearance(DisappearanceVO disappearanceVO, HttpServletRequest request) throws Exception {
		disappearanceDAO.updateDisappearance(disappearanceVO);
        Map<String,Object> mapFile = disappearanceFileUtils.parseInsertFileInfo(disappearanceVO, request);
        if(mapFile!=null){
        	disappearanceDAO.updateDisappearanceFile(mapFile);
        }
	}

	/**
	 * 분실게시판 (삭제) 요청을 처리하기 위해 데이터처리를 요청한다.
	 * 
	 * @param String pIdx
	 * @return void
	 * @throws 
	 */
	@Override
	public void deleteDisappearance(String pIdx) {
		disappearanceDAO.deleteDisappearanceFile(pIdx);
		disappearanceDAO.deleteDisappearance(pIdx);
	}
	
	/**
	 * 분실게시판 상세글과 실종게시판 상세글과 일치 하는 데이터 (조회) 요청을 처리하기 위해 데이터처리를 요청한다.
	 * 
	 * @param DisappearanceVO disappearanceVO
	 * @return List<FindsVO>
	 * @throws 
	 */
	@Override
	public List<FindsVO> matchDisappearance(DisappearanceVO disappearanceVO){
		return disappearanceDAO.matchDisappearance(disappearanceVO);
	}

	/**
	 * 분실게시판 사진다운로드를 처리하기 위해 데이터처리를 요청한다.
	 * 
	 * @param String idx
	 * @return Map<String, Object>
	 * @throws 
	 */
	@Override
	public Map<String, Object> selectFileInfo(String idx) throws Exception{
		return disappearanceDAO.selectFileInfo(idx);
	}
	
	/** 
	 * 해당게시물의 등록한 아이디를 확인하기 위해 데이터처리를 요청한다.
	 * 
	 * @param String idx
	 * @return String
	 * @throws 
	 */
	@Override
	public String idCheck(String idx){
		return disappearanceDAO.idCheck(idx);
	}

	
	/** 
	 * 작성된 글을 조회하기 위해 데이터처리를 요청한다.
	 * 
	 * @param HashMap<String, String> map
	 * @return List<DisappearanceVO>
	 * @throws 
	 */
	@Override
	public List<DisappearanceVO> searchDisappearance(HashMap<String, String> map){
		return disappearanceDAO.searchDisappearance(map);
	}


	@Override
	public int postCount() {
		return disappearanceDAO.postCount();
	}


	@Override
	public List<PagingVO> getBoardList(PagingVO pagingVO) {
		return disappearanceDAO.getBoardList(pagingVO);
	}

}
