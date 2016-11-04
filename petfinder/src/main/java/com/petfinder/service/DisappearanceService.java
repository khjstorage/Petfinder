package com.petfinder.service;

import java.util.ArrayList;

import com.petfinder.vo.DisappearanceVO;

public interface DisappearanceService {
	public void updateDisappr(String name);
	public void deleteDisappr(String name);
	public ArrayList<DisappearanceVO> getDisappr();
	public void insertDisappr(DisappearanceVO disappearanceVO);
}
