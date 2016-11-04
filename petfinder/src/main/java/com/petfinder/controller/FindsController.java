package com.petfinder.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.petfinder.service.FindsService;


@Controller
public class FindsController {

    @Resource(name="findsService")
    private FindsService findsService;
	
}
