package com.petfinder.service;

import org.springframework.ui.Model;

public interface FindsService {
	public void insert(Model model);	
	public void update(String name);
	public void delete(String name);
}
