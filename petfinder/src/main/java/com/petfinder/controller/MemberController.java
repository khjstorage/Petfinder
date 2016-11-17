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
/**
 * 멤버정보 CRUD 요청을 처리하는 Controller 클래스
 * 
 * @author  1조
 * @since 2016.11.14
 * @version 1.0
 * @see 
 * <pre>
 *  == 개정이력(Modification Information) ==
 *   
 *          수정일          수정자           수정내용
 *  ----------------    ------------    ---------------------------
 *   2016.11.14        1조             최초 생성
 * 
 * </pre>
 */
@Controller
public class MemberController {

	@Resource(name="memberService")
	private MemberService memberService;

	
	/** 
	 * 회원가입 페이지로 이동한다.
	 * @return 
	 * @return
	 * @throws 
	 */
	@RequestMapping("/member/register.do")
	public String register() {
		return "member/register";
	}

	
	/** 
	 * 회원가입을 신청하고 메인으로 이동한다.
	 * @return 
	 * @return
	 * @throws 
	 */
	@RequestMapping("/signup")
	public String signup(@ModelAttribute("memberVO")MemberVO memberVO, HttpServletRequest request) throws Exception{
		memberService.insertMember(memberVO, request);
		return "redirect:main.do";
	}


	/** 
	 * 로그인페이지로 이동한다.
	 * @return 
	 * @return
	 * @throws 
	 */
	@RequestMapping("/member/login.do")
	public String login() {
		return "member/login";
	}

	/** 
	 * 로그인처리를 한다. 아이디와 패스워드가 맞으면 세션값을 부여한다.
	 * @return 
	 * @return
	 * @throws 
	 */
	@RequestMapping("/loginProcess.do")
	public ModelAndView loginProcess(@RequestParam("id") String id, @RequestParam("pwd") String pwd, HttpSession session) {
		ModelAndView mv = null;
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("pwd", pwd);
		if(memberService.loginMember(map).equals(id)){
			session.setAttribute("id",id);
			return mv = new ModelAndView("redirect:main.do");
		}else{
			session.setAttribute("idfail",id);
			return mv = new ModelAndView("redirect:login.do");
		}
	}
	
	/** 
	 * 마이페이지로 이동한다.
	 * @return 
	 * @return
	 * @throws 
	 */
	@RequestMapping("/member/mypage.do")
	public ModelAndView mypage(HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();
		List<MemberVO> list = memberService.getMember((String) session.getAttribute("id"));
		mv.addObject("memberlist", list);
		mv.setViewName("member/mypage");
		return mv;
	}


	/** 
	 * 로그아웃을 처리하고, 메인페이지로 이동한다.
	 * @return 
	 * @return
	 * @throws 
	 */
	@RequestMapping("/logout.do")
	public String logout(HttpSession session){
		session.removeAttribute("id");
		session.invalidate();
		return "redirect:main.do";
	}
	
	/** 
	 * 회원탈퇴를 처리하고, 메인페이지로 이동한다.
	 * @return 
	 * @return
	 * @throws 
	 */
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

	/** 
	 * 회원정보를 수정하고, 메인페이지로 이동한다.
	 * @return 
	 * @return
	 * @throws 
	 */
	@RequestMapping("/updateMember.do")
	public String updateMember(@ModelAttribute("memberVO")MemberVO memberVO, HttpServletRequest request) throws Exception{
		memberService.updateMember(memberVO, request);
		return "redirect:main.do";
	}

}
