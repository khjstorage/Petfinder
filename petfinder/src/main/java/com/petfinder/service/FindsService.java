package com.petfinder.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.petfinder.vo.FindsVO;

public interface FindsService {

	public void insertFinds(FindsVO findsVO, HttpServletRequest request) throws Exception;
	public Map<String, Object> selectBoardDetail(String parameter) throws Exception;
	public List<FindsVO> findsList(FindsVO findsVO);
	public void deleteFinds(String idx);
	
	
}
