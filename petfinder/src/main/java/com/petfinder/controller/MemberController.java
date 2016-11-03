package com.petfinder.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.petfinder.service.MemberService;
import com.petfinder.vo.MemberVO;

@Controller
public class MemberController {
	
    @Resource(name="memberService")
    private MemberService memberService;

	@RequestMapping("/signup_form")
	public String signup_write() {
		return "/signup_form";
	}
	
	@RequestMapping("/signup")
	public String signup(@ModelAttribute("memberVO")MemberVO memberVO, HttpServletRequest request) {
		memberService.insertMember(memberVO);
		return "redirect:main";
	}

}
