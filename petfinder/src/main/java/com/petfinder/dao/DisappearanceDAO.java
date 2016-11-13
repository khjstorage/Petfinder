package com.petfinder.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.petfinder.vo.DisappearanceVO;
import com.petfinder.vo.FindsVO;

/**
 * 분실정보에 관한 데이터처리 DAO 클래스
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
@Repository("disappearanceDAO")
public class DisappearanceDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	/**
	 * DB에 분실글을 (입력)한다.
	 * 
	 * @param DisappearanceVO disappearanceVO
	 * @return void
	 * @throws 
	 */
	public void insertDisappearance(DisappearanceVO disappearanceVO) {
		sqlSession.insert("disappearance.insertDisappearance", disappearanceVO);
	}
	
	/**
	 * DB에 분실글사진을 (입력)한다.
	 * 
	 * @param Map<String,Object> mapFile
	 * @return void
	 * @throws 
	 */
	public void insertDisappearanceFile(Map<String,Object> mapFile) {
		sqlSession.insert("disappearance.insertDisappearanceFile", mapFile);
	}
	
	/**
	 * DB에서 분실글목록을 (조회) 한다.
	 * 
	 * @param 
	 * @return List<DisappearanceVO>
	 * @throws Exception
	 */
	public List<DisappearanceVO> disappearanceList(){
		return sqlSession.selectList("disappearance.disappearanceList");
	}

	/**
	 * DB에서 분실글을 (상세조회) 한다.
	 * 
	 * @param String pIdx
	 * @return Map<String, Object>
	 * @throws Exception
	 */
	public Map<String, Object> selectBoardDetail(String pIdx) {
		return sqlSession.selectOne("disappearance.selectBoardDetail", pIdx);
	}

	/**
	 * DB에서 분실글사진을 (상세조회) 한다.
	 * 
	 * @param String pIdx
	 * @return List<Object>
	 * @throws Exception
	 */
	public List<Object> selectBoardDetailFile(String pIdx){
		return sqlSession.selectList("disappearance.selectBoardDetailFile", pIdx);
	}
	
	/**
	 * DB에서 분실글을 (삭제) 한다.
	 * 
	 * @param String pIdx
	 * @return void
	 * @throws Exception
	 */
	public void deleteDisappearanceFile(String pIdx) {
		sqlSession.delete("disappearance.deleteDisappearanceFile", pIdx);
	}
	
	/**
	 * DB에서 분실글사진을 (삭제) 한다.
	 * 
	 * @param String pIdx
	 * @return void
	 * @throws Exception
	 */
	public void deleteDisappearance(String pIdx) {
		sqlSession.delete("disappearance.deleteDisappearance", pIdx);
	}
	
	/**
	 * DB에서 분실글을 (수정) 한다.
	 * 
	 * @param DisappearanceVO disappearanceVO
	 * @return void
	 * @throws Exception
	 */
	public void updateDisappearance(DisappearanceVO disappearanceVO) {
		sqlSession.update("disappearance.updateDisappearance", disappearanceVO);
	}

	/**
	 * DB에서 분실글사진을 (수정) 한다.
	 * 
	 * @param String pIdx
	 * @return Map<String, Object> mapFile
	 * @throws Exception
	 */
	public void updateDisappearanceFile(Map<String, Object> mapFile) {
		sqlSession.update("disappearance.updateDisappearanceFile", mapFile);
	}
	
	/**
	 * DB에서 분실게시판 상세글과 실종게시판 상세글과 일치 하는 데이터 (조회) 한다.
	 * 
	 * @param DisappearanceVO disappearanceVO
	 * @return List<FindsVO>
	 * @throws Exception
	 */
	public List<FindsVO> searchDisappearance(DisappearanceVO disappearanceVO){
		return sqlSession.selectList("finds.searchFinds",disappearanceVO);
	}
	
	/**
	 * DB에서 분실글사진을 (조회) 한다.
	 * 
	 * @param String idx
	 * @return Map<String, Object>
	 * @throws Exception
	 */
	public Map<String, Object> selectFileInfo(String idx){
		return sqlSession.selectOne("disappearance.selectFileInfo", idx);
	}

}
