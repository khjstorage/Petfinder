package com.petfinder.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.petfinder.vo.DisappearanceVO;

public interface DisappearanceService {
	public List<DisappearanceVO> disappearanceList(DisappearanceVO disappearanceVO);
	public Map<String, Object> selectBoardDetail(String parameter) throws Exception; 
	public void insertDisappearance(DisappearanceVO disappearanceVO, HttpServletRequest request) throws Exception;
	public void updateDisappearance(DisappearanceVO disappearanceVO, HttpServletRequest request) throws Exception;
	public void deleteDisappearance(String idx);
}

