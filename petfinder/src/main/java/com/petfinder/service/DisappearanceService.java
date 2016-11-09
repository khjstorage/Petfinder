package com.petfinder.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.petfinder.vo.DisappearanceVO;

public interface DisappearanceService {
	public List<DisappearanceVO> disappearanceList(DisappearanceVO disappearanceVO);
	public void insertDisappearance(DisappearanceVO disappearanceVO, HttpServletRequest request) throws Exception;
	public void updateDisappearance(String name);
	public void deleteDisappearance(String name);
}
