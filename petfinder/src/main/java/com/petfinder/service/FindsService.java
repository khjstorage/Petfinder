package com.petfinder.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import com.petfinder.vo.DisappearanceVO;
import com.petfinder.vo.FindsVO;

public interface FindsService {

	public List<FindsVO> findsList();
	public Map<String, Object> selectBoardDetail(String parameter) throws Exception;
	public void insertFinds(FindsVO findsVO, HttpServletRequest request) throws Exception;
	public void updateFinds(FindsVO findsVO, HttpServletRequest request) throws Exception;
	public void deleteFinds(String idx);
	public List<DisappearanceVO> searchFinds(FindsVO findsVO) throws Exception;
	public Map<String, Object> selectFileInfo(Map<String, Object> map) throws Exception;
	
}
