package com.petfinder.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.petfinder.service.MemberService;
import com.petfinder.vo.MemberVO;

@Controller
public class MemberController {
	
    @Resource(name="memberService")
    private MemberService memberService;

	
	@RequestMapping("/signup")
	public String signup(@ModelAttribute("memberVO")MemberVO memberVO, HttpServletRequest request) throws Exception{
		memberService.insertMember(memberVO, request);
		return "redirect:main.do";
	}
	
	@RequestMapping("/mypage.do")
	public ModelAndView mypage(@ModelAttribute("memberVO")MemberVO memberVO) throws Exception {
		ModelAndView mv = new ModelAndView();
		List<MemberVO> list = memberService.getMember(memberVO);
		mv.addObject("memberlist", list);
		mv.setViewName("/mypage");
		return mv;
	}


	
}
