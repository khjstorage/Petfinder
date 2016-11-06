package com.petfinder.service;

import java.util.ArrayList;

import com.petfinder.vo.DisappearanceVO;

public interface DisappearanceService {
	public ArrayList<DisappearanceVO> getDisapprance();
	public void insertDisapprance(DisappearanceVO disappearanceVO);
	public void updateDisapprance(String name);
	public void deleteDisapprance(String name);
}
