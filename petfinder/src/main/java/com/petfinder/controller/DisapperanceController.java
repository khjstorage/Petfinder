package com.petfinder.controller;

import java.io.File;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.petfinder.service.DisappearanceService;
import com.petfinder.vo.DisappearanceVO;
import com.petfinder.vo.FindsVO;
/**
 * 분실정보 CRUD 요청을 처리하는 Controller 클래스
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
public class DisapperanceController {

    @Resource(name="disappearanceService")
    private DisappearanceService disappearanceService;
	
	/** 
	 * 분실목록을 조회 한다.
	 * @return1 List<DisappearanceVO> list
	 * @return2 "disappearance/disappearance_list"
	 * @throws 
	 */
	@RequestMapping("/disappearance_list")
	public ModelAndView disappearance_list() {
		ModelAndView mv = new ModelAndView();
		List<DisappearanceVO> list = disappearanceService.disappearanceList();
		mv.addObject("disappearancelist", list);
		mv.setViewName("disappearance/disappearance_list");
		return mv;
	}
	
	/**
	 * 분실게시판 글쓰기 화면으로 이동한다.
	 * @param HttpSession session
	 * @return "disappearance/disappearance_form";
	 * @return "redirect:login.do";
	 * @throws Exception
	 */
	@RequestMapping("/disappearance_form")
	public String disappearance_form(HttpSession session) {
		if(session.getAttribute("id")!=null){
			return "disappearance/disappearance_form";
		}else{
			return "redirect:login.do";
		}
	}
	
	/**
	 * 분실정보 등록하고 목록조회 화면으로 이동한다.
	 * @param1 @ModelAttribute("disappearanceVO")DisappearanceVO disappearanceVO 분실정보
	 * @param2 HttpServletRequest request 파일정보
	 * @return "redirect:disappearance_list.do";
	 * @throws Exception
	 */
	@RequestMapping("/disappearance_write")
	public String disappearance_write(@ModelAttribute("disappearanceVO")DisappearanceVO disappearanceVO, HttpServletRequest request) throws Exception {
		disappearanceService.insertDisappearance(disappearanceVO, request);
		return "redirect:disappearance_list.do";
	}
	
	
	/**
	 * 분실정보 상세화면으로 이동한다.
	 * @param @RequestParam("idx") String idx
	 * @return1 Map<String,Object> map 
	 * @return2 "disappearance/disappearance_contents"
	 * @throws Exception
	 */
	@RequestMapping("/disappearance_contents")
	public ModelAndView disappearance_contents(@RequestParam("idx") String idx) throws Exception {
		ModelAndView mv = new ModelAndView();
		Map<String,Object> map = disappearanceService.selectBoardDetail(idx);
		mv.addObject("map", map.get("infoMap"));
		mv.addObject("file", map.get("fileMap"));;
		mv.setViewName("disappearance/disappearance_contents");
		return mv;
	}
	
	/**
	 * 분실정보 삭제 후 목록조회 화면으로 이동한다.
	 * @param @RequestParam("idx") String idx
	 * @return "redirect:disappearance_list.do"
	 * @throws Exception
	 */
	@RequestMapping("/disappearance_delete")
	public String disappearance_delete(@RequestParam("idx") String idx) {
		disappearanceService.deleteDisappearance(idx);
		return "redirect:disappearance_list.do";
	}
	
	/**
	 * 분실정보 수정 화면으로 이동한다.
	 * @param @RequestParam("idx") String idx
	 * @return1 Map<String,Object> map 
	 * @return2 "disappearance/disappearance_update"
	 * @throws Exception
	 */
	@RequestMapping("/disappearance_update")
	public ModelAndView disappearance_update(@RequestParam("idx") String idx) throws Exception {
		ModelAndView mv = new ModelAndView();
		Map<String,Object> map = disappearanceService.selectBoardDetail(idx);
		mv.addObject("map", map);
		mv.setViewName("disappearance/disappearance_update");
		return mv;
	}

	/** 
	 * 분실정보 수정하고 목록조회 화면으로 이동한다.
	 * @param1 @ModelAttribute("disappearanceVO")DisappearanceVO disappearanceVO
	 * @param2 HttpServletRequest request
	 * @return "redirect:disappearance_list.do"
	 * @throws Exception
	 */
	@RequestMapping("/disappearance_update_pro")
	public String disappearance_update_pro(@ModelAttribute("disappearanceVO")DisappearanceVO disappearanceVO, HttpServletRequest request) throws Exception {
		disappearanceService.updateDisappearance(disappearanceVO, request);
		return "redirect:disappearance_list.do";
	}
	
	/** 
	 * 분실글의 매칭버튼을 클릭하면 실종글 정보와 일치한 게시글 화면으로 이동한다.
	 * @param1 @ModelAttribute("disappearanceVO")DisappearanceVO disappearanceVO
	 * @param2 HttpServletRequest request
	 * @return List<FindsVO> list
	 * @return "finds/finds_list"
	 * @throws Exception
	 */
	@RequestMapping("/disappearance_search")
	public ModelAndView disappearance_search(@ModelAttribute("disappearanceVO")DisappearanceVO disappearanceVO) throws Exception {
		ModelAndView mv = new ModelAndView();
		List<FindsVO> list = disappearanceService.searchDisappearance(disappearanceVO);
		mv.addObject("findslist", list);
		mv.setViewName("finds/finds_list");
		return mv;
	}
	
	/** 
	 * 파일 다운로드
	 * @param1 @RequestParam("idx") String idx
	 * @param2 HttpServletResponse response
	 * @throws Exception
	 */
	@RequestMapping("/disappearance_download")
	public void disappearance_download(@RequestParam("idx") String idx, HttpServletResponse response) throws Exception{
		Map<String, Object> map = disappearanceService.selectFileInfo(idx);
	    String storedFileName = (String)map.get("D_STORED_FILE_NAME");
	    String originalFileName = (String)map.get("D_ORIGINAL_FILE_NAME");
	     
	    byte fileByte[] = FileUtils.readFileToByteArray(new File("C:\\dev\\disappearancefile\\"+storedFileName));
	     
	    response.setContentType("application/octet-stream");
	    response.setContentLength(fileByte.length);
	    response.setHeader("Content-Disposition", "attachment; fileName=\"" + URLEncoder.encode(originalFileName,"UTF-8")+"\";");
	    response.setHeader("Content-Transfer-Encoding", "binary");
	    response.getOutputStream().write(fileByte);
	     
	    response.getOutputStream().flush();
	    response.getOutputStream().close();
	}
}
