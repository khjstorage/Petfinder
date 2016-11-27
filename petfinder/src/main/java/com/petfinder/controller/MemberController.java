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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.petfinder.service.MemberService;
import com.petfinder.vo.MemberVO;
/**
 * 硫ㅻ쾭�젙蹂� CRUD �슂泥��쓣 泥섎━�븯�뒗 Controller �겢�옒�뒪
 * 
 * @author  1議�
 * @since 2016.11.14
 * @version 1.0
 * @see 
 * <pre>
 *  == 媛쒖젙�씠�젰(Modification Information) ==
 *   
 *          �닔�젙�씪          �닔�젙�옄           �닔�젙�궡�슜
 *  ----------------    ------------    ---------------------------
 *   2016.11.14        1議�             理쒖큹 �깮�꽦
 * 
 * </pre>
 */
@Controller
@RequestMapping("/member")
public class MemberController {

	@Resource(name="memberService")
	private MemberService memberService;

	
	/** 
	 * @param 
	 * @return
	 * @throws 
	 */
	@RequestMapping("/register.do")
	public String register() {
		return "/member/register";
	}

	
	/** 
	 * @param 
	 * @return
	 * @throws 
	 */
	@RequestMapping("/signup")
	public String signup(@ModelAttribute("memberVO")MemberVO memberVO, HttpServletRequest request) throws Exception{
		memberService.insertMember(memberVO, request);
		return "redirect:/main.do";
	}


	/** 
	 * @return 
	 * @return
	 * @throws 
	 */
	@RequestMapping("/login.do")
	public String login() {
		return "/member/login";
	}

	/** 
	 * 로그인
	 * @param 
	 * @return
	 * @throws 
	 */
	@RequestMapping("/loginProcess.do")
	public ModelAndView loginProcess(@RequestParam("id") String id, @RequestParam("pwd") String pwd, HttpSession session) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("pwd", pwd);
		if(memberService.loginMember(map).size()==1){
			session.setAttribute("id",id);
			return new ModelAndView("redirect:/main.do");
		}else{
			session.setAttribute("idfail",id);
			return new ModelAndView("redirect:/member/login.do");
		}
	}
	
	/** 
	 * @return 
	 * @return
	 * @throws 
	 */
	@RequestMapping("/mypage.do")
	public ModelAndView mypage(HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();
		List<MemberVO> list = memberService.getMember((String) session.getAttribute("id"));
		mv.addObject("memberlist", list);
		mv.setViewName("/member/mypage");
		return mv;
	}


	/** 
	 * @return 
	 * @return
	 * @throws 
	 */
	@RequestMapping("/logout.do")
	public String logout(HttpSession session){
		session.removeAttribute("id");
		session.invalidate();
		return "redirect:/main.do";
	}
	
	/** 
	 * @return 
	 * @return
	 * @throws 
	 */
	@RequestMapping("/delete.do")
	public String delete(HttpSession session){
		String id = (String) session.getAttribute("id");
		memberService.deleteMember(id);
		session.removeAttribute("id");
		session.invalidate();
		return "redirect:/main.do";
	}

	/** 
	 * @return 
	 * @return
	 * @throws 
	 */
	@RequestMapping("/update.do")
	public String update(@ModelAttribute("memberVO")MemberVO memberVO, HttpServletRequest request) throws Exception{
		memberService.updateMember(memberVO, request);
		return "redirect:/main.do";
	}
	
	/** 
	 * 
	 * @return 
	 * @return
	 * @throws 
	 */
	@RequestMapping("/duplication.do")
	@ResponseBody
	public int duplication(HttpServletRequest request){
		String duplicationId = request.getParameter("id");
		List<MemberVO> list = memberService.duplication(duplicationId);
		if(list.size()==0){
			return -1;
		}else{
			return 1;
		}
	}

}
