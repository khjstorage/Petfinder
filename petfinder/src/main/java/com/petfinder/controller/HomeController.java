package com.petfinder.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.petfinder.service.MemberService;

@Controller
public class HomeController {

    @Resource(name="memberService")
    private MemberService memberService;
	
	@RequestMapping("/main.do")
	public String main() {
		return "/main";
	}

	@RequestMapping("/login.do")
	public String login() {
		return "/login";
	}

	@RequestMapping("/login_process.do")
	   public String login_pro(@RequestParam("id") String id, @RequestParam("pwd") String pwd, HttpSession session) {
	      String idcheck = memberService.loginMember(id, pwd);
	      if(idcheck.equals(id)){
	         session.setAttribute("id",id);
	         return "redirect:main.do";
	      }
	      else{
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

	@RequestMapping("/signup_form.do")
	public String signup_write() {
		return "/signup_form";
	}


	@RequestMapping("/about.do")
	public String about() {
		return "etc/about";
	}


}
