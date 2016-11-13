package com.petfinder.controller;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public ModelAndView mypage(HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();
		List<MemberVO> list = memberService.getMember((String) session.getAttribute("id"));
		mv.addObject("memberlist", list);
		mv.setViewName("/mypage");
		return mv;
	}


	@RequestMapping("/login_process.do")
	public String login_pro(@RequestParam("id") String id, @RequestParam("pwd") String pwd, HttpSession session) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("pwd", pwd);
		String account = memberService.loginMember(map);
		if(account.equals(id)){
			session.setAttribute("id",id);
			return "redirect:main.do";
		}else{
			session.setAttribute("idfail",id);
			return "redirect:login.do";
		}
	}

	@RequestMapping("/logout.do")
	public String logout(HttpSession session){
		session.removeAttribute("id");
		session.invalidate();
		return "redirect:main.do";
	}
	
	@RequestMapping("/deleteMember.do")
	public String deleteMember(HttpSession session){
		String id = (String) session.getAttribute("id");
		//id넘겨줘서 쿼리문 실행
		memberService.deleteMember(id);
		//session삭제
		session.removeAttribute("id");
		session.invalidate();
		return "redirect:main.do";
	}

	@RequestMapping("/updateMember.do")
	public String updateMember(@ModelAttribute("memberVO")MemberVO memberVO, HttpServletRequest request) throws Exception{
		memberService.updateMember(memberVO, request);
		return "redirect:main.do";
	}

}
