package com.petfinder.service;

import java.util.ArrayList;

import com.petfinder.vo.FindsVO;

public interface FindsService {
	public ArrayList<FindsVO> getFinds();
	public void insertFinds(FindsVO FindsVO);
	public void updateFinds(String name);
	public void deleteFinds(String name);
	
}
