package com.petfinder.controller;

import java.io.File;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.petfinder.service.FindsService;
import com.petfinder.vo.DisappearanceVO;
import com.petfinder.vo.FindsVO;
/**
 * 발견정보 CRUD 요청을 처리하는 Controller 클래스
 * 
 * @author  1조
 * @since 2016.11.14
 * @version 1.0
 * @see 
 * <pre>
 *  == 개정이력(Modification Information) ==
 *   
 *      수정일       		   	수정자     		      수정내용
 *  ----------------    ------------    ---------------------------
 *   2016.11.14     		1조             		최초 생성
 *   2016.11.17				김현진	  		requestmapping 수정
 * </pre>
 */
@Controller
@RequestMapping("/finds")
public class FindsController {

	@Resource(name = "findsService")
	private FindsService findsService;

	/** 
	 * 발견목록을 조회 한다.
	 * @return1 List<FindsVO> list
	 * @return2 "Finds/findslist"
	 * @throws 
	 */
	@RequestMapping("/list.do")
	public ModelAndView findslist() {
		ModelAndView mv = new ModelAndView();
		List<FindsVO> list = findsService.findsList();
		mv.addObject("findslist", list);
		mv.setViewName("/finds/list");
		return mv;
	}

	/**
	 * 발견게시판 글쓰기 화면으로 이동한다.
	 * @param 
	 * @return "finds/finds_form";
	 * @throws 
	 */
	@RequestMapping("/write.do")
	public String finds_form() {
		return "/finds/write";
	}


	/**
	 * 발견정보 등록하고 목록조회 화면으로 이동한다.
	 * @param1 @ModelAttribute("findsVO") FindsVO findsVO 발견정보
	 * @param2 HttpServletRequest request 파일정보
	 * @return "redirect:findslist.do";
	 * @throws Exception
	 */
	@RequestMapping("/create.do")
	public String finds_write(@ModelAttribute("findsVO") FindsVO findsVO, HttpServletRequest request) throws Exception {
		findsService.insertFinds(findsVO, request);
		return "redirect:/finds/list.do";
	}

	/**
	 * 발견정보 상세화면으로 이동한다.
	 * @param HttpServletRequest request
	 * @return1 Map<String,Object> map 
	 * @return2 "finds/finds_contents"
	 * @throws Exception
	 */
	@RequestMapping("/contents.do")
	public ModelAndView finds_contents(HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView();
		Map<String, Object> map = findsService.selectBoardDetail(request.getParameter("idx"));
		mv.addObject("map", map.get("infoMap"));
		mv.addObject("file", map.get("fileMap"));
		mv.setViewName("/finds/contents");
		return mv;
	}



	/**
	 * 발견글의 패스워드 화면에서 해당 글에 패스워드가 일치하면 finds_delete_pro 이동
	 * @param @RequestParam("pwd") String pwd 
	 * @param @RequestParam("idx") String idx
	 * @return "redirect:finds_delete.do?idx="+idx
	 * @return "redirect:finds_password.do?idx="+idx
	 */
	@RequestMapping("/delete_auth.do")
	public String finds_delete_auth(@RequestParam("pwd") String pwd, @RequestParam("idx") String idx){
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("pwd", pwd);
		map.put("idx", idx);
		String account = findsService.getpassword(map);
		if(pwd.equals(account)){
			return "redirect:/finds/delete.do?idx="+idx;
		}else{
			return "redirect:/finds/contents.do?idx="+idx;
		}
	}

	/**
	 * 발견정보 삭제 후 목록조회 화면으로 이동한다.
	 * @param @RequestParam("idx") String idx
	 * @return "redirect:findslist.do"
	 * @throws Exception
	 */
	@RequestMapping("/delete.do")
	public String finds_delete_pro(@RequestParam("idx") String idx){
		findsService.deleteFinds(idx);
		return "redirect:/finds/list.do";
	}


	/**
	 * 발견글의 패스워드 화면에서 해당 글에 패스워드가 일치하면 수정 화면으로 이동한다.
	 * @param @RequestParam("pwd") String pwd 
	 * @param @RequestParam("idx") String idx
	 * @return "redirect:finds_update.do?idx="+idx
	 * @return "redirect:finds_password.do?idx="+idx
	 */
	@RequestMapping("/update_auth.do")
	public String finds_update_auth(@RequestParam("pwd") String pwd, @RequestParam("idx") String idx){
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("pwd", pwd);
		map.put("idx", idx);
		String account = findsService.getpassword(map);
		if(pwd.equals(account)){
			return "redirect:/finds/edit.do?idx="+idx;
		}else{
			return "redirect:/finds/contents.do?idx="+idx;
		}
	}


	/**
	 * 발견정보 수정 화면으로 이동한다.
	 * @param HttpServletRequest request
	 * @return1 Map<String,Object> map 
	 * @return2 "finds/finds_update"
	 * @throws Exception
	 */
	@RequestMapping("/edit.do")
	public ModelAndView finds_update(HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView();
		Map<String, Object> map = findsService.selectBoardDetail(request.getParameter("idx"));
		mv.addObject("map", map);
		mv.setViewName("/finds/edit");
		return mv;
	}

	/** 
	 * 분실정보 수정하고 목록조회 화면으로 이동한다.
	 * @param1 @ModelAttribute("findsVO")FindsVO findsVO
	 * @param2 HttpServletRequest request
	 * @return "redirect:findslist.do"
	 * @throws Exception
	 */
	@RequestMapping("/update.do")
	public String finds_update_pro(@ModelAttribute("findsVO")FindsVO findsVO, HttpServletRequest request) throws Exception {
		findsService.updateFinds(findsVO, request);
		return "redirect:/finds/list.do";
	}



	/** 
	 * 파일 다운로드
	 * @param1 @RequestParam("idx") String idx
	 * @param2 HttpServletResponse response
	 * @throws Exception
	 */
	@RequestMapping("/download.do")
	public void finds_download(@RequestParam("idx") String idx, HttpServletResponse response) throws Exception{
		Map<String, Object> map = findsService.selectFileInfo(idx);
		String storedFileName = (String)map.get("F_STORED_FILE_NAME");
		String originalFileName = (String)map.get("F_ORIGINAL_FILE_NAME");

		byte fileByte[] = FileUtils.readFileToByteArray(new File("C:\\dev\\image\\findsfile\\"+storedFileName));

		response.setContentType("application/octet-stream");
		response.setContentLength(fileByte.length);
		response.setHeader("Content-Disposition", "attachment; fileName=\"" + URLEncoder.encode(originalFileName,"UTF-8")+"\";");
		response.setHeader("Content-Transfer-Encoding", "binary");
		response.getOutputStream().write(fileByte);

		response.getOutputStream().flush();
		response.getOutputStream().close();
	}


	/** 
	 * 발견글의 매칭버튼을 클릭하면 실종글 정보와 일치한 게시글 화면으로 이동한다.
	 * @param1 @ModelAttribute("findsVO")FindsVO findsVO
	 * @param2 HttpServletRequest request
	 * @return List<DisappearanceVO> list
	 * @return "disappearance/disappearance_list"
	 * @throws Exception
	 */
	@RequestMapping("/match.do")
	public ModelAndView finds_match(@ModelAttribute("findsVO")FindsVO findsVO) throws Exception{
		ModelAndView mv = new ModelAndView();
		List<DisappearanceVO> list = findsService.matchFinds(findsVO);
		mv.addObject("disappearancelist", list);
		mv.setViewName("/disappearance/list");
		return mv;
	}


	/** 
	 * 조회기능
	 * @param @RequestParam("searchtext") String searchtext	
	 * @param @RequestParam("searchoption") String searchoption
	 * @return mv.addObject("disappearancelist", list)
	 * @return mv.setViewName("disappearance/disappearance_list")
	 * @throws Exception
	 */
	@RequestMapping("/search.do")
	public ModelAndView finds_search(@RequestParam("keyWord_search") String keyWord_search,	@RequestParam("selection_search") String selection_search) throws Exception {
		ModelAndView mv = new ModelAndView();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("keyWord_search", keyWord_search);
		map.put("selection_search", selection_search);
		List<FindsVO> list = findsService.searchFinds(map);
		mv.addObject("findslist", list);
		mv.setViewName("/finds/list");
		return mv;
	}




}
