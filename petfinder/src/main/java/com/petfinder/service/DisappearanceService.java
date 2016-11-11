package com.petfinder.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.petfinder.vo.DisappearanceVO;
import com.petfinder.vo.FindsVO;

public interface DisappearanceService {
	public List<DisappearanceVO> disappearanceList();
	public Map<String, Object> selectBoardDetail(String parameter) throws Exception; 
	public void insertDisappearance(DisappearanceVO disappearanceVO, HttpServletRequest request) throws Exception;
	public void updateDisappearance(DisappearanceVO disappearanceVO, HttpServletRequest request) throws Exception;
	public void deleteDisappearance(String idx);
	public List<FindsVO> searchDisappearance(DisappearanceVO disappearanceVO);
}

