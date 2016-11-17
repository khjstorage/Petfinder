package com.petfinder.controller;

import java.io.File;
import java.net.URLEncoder;
import java.util.HashMap;
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
	 * @return List<DisappearanceVO> list
	 * @return "disappearance/disappearancelist"
	 * @throws 
	 */
	@RequestMapping("/disappearance/list.do")
	public ModelAndView disappearancelist() {
		ModelAndView mv = new ModelAndView();
		List<DisappearanceVO> list = disappearanceService.disappearanceList();
		mv.addObject("disappearancelist", list);
		mv.setViewName("disappearance/list");
		return mv;
	}
		
		
	/**
	 * 분실정보 상세화면으로 이동한다. 
	 * 로그인된값(세션)과 게시물의 id가 다르면 수정/삭제 버튼 비활성
	 * 일치하면 idcheck 키에 permission 값을 넣는다
	 * @param @RequestParam("idx") String idx
	 * @param HttpSession session
	 * @return Map<String,Object> map 
	 * @return "disappearance/disappearance_contents"
	 * @throws Exception
	 */
	@RequestMapping("/disappearance/contents.do")
	public ModelAndView disappearance_contents(HttpSession session, @RequestParam("idx") String idx) throws Exception {
		String id = (String)session.getAttribute("id");
		String idcheck = disappearanceService.idCheck(idx);
		if(idcheck.equals(id)){
			session.setAttribute("idcheck", "permission");
		}
		ModelAndView mv = new ModelAndView();
		Map<String,Object> map = disappearanceService.selectBoardDetail(idx);
		mv.addObject("map", map.get("infoMap"));
		mv.addObject("file", map.get("fileMap"));;
		mv.setViewName("disappearance/contents");
		return mv;
	}
			
	
	/**
	 * 분실게시판 글쓰기 화면으로 이동한다.
	 * @param HttpSession session
	 * @return "disappearance/disappearance_form";
	 * @return "redirect:login.do";
	 * @throws Exception
	 */
	@RequestMapping("/disappearance/write.do")
	public String disappearance_form(HttpSession session) {
		if(session.getAttribute("id")!=null){
			return "disappearance/write";
		}else{
			return "redirect:login.do";
		}
	}
		
		
	/**
	 * 분실정보 등록하고 목록조회 화면으로 이동한다.
	 * @param @ModelAttribute("disappearanceVO")DisappearanceVO disappearanceVO 분실정보
	 * @param HttpServletRequest request 파일정보
	 * @return "redirect:disappearancelist.do";
	 * @throws Exception
	 */
	@RequestMapping("/create.do")
	public String disappearance_write(@ModelAttribute("disappearanceVO")DisappearanceVO disappearanceVO, HttpServletRequest request) throws Exception {
		disappearanceService.insertDisappearance(disappearanceVO, request);
		return "redirect:disappearance/list.do";
	}
	

	
	/**
	 * 분실정보 삭제 후 목록조회 화면으로 이동한다.
	 * @param @RequestParam("idx") String idx
	 * @return "redirect:disappearancelist.do"
	 * @throws Exception
	 */
	@RequestMapping("/delete.do")
	public String disappearance_delete(@RequestParam("idx") String idx) {
		disappearanceService.deleteDisappearance(idx);
		return "redirect:disappearance/list.do";
	}
	
	
	
	/**
	 * 분실정보 수정 화면으로 이동한다.
	 * 세션id랑 게시글의 id가 다르면 수정페이지로 못감(강제적으로 url 변경)
	 * @param @RequestParam("idx") String idx
	 * @return Map<String,Object> map 
	 * @return "disappearance/disappearance_update"
	 * @throws Exception
	 */
	@RequestMapping("/disappearance/edit.do")
	public ModelAndView disappearance_update(HttpSession session, @RequestParam("idx") String idx) throws Exception {
		ModelAndView mv = new ModelAndView();
		Map<String,Object> map = disappearanceService.selectBoardDetail(idx);
		mv.addObject("map", map);
		HashMap<String, Object> infoMap = (HashMap<String, Object>)map.get("infoMap");
		if(session.getAttribute("id").equals(infoMap.get("D_ID"))){
			mv.setViewName("disappearance/edit");
		}else{
			mv.setViewName("redirect:disappearance/list.do");
		}
		return mv;
	}
	
	
	
	/** 
	 * 분실정보 수정하고 목록조회 화면으로 이동한다.
	 * @param @ModelAttribute("disappearanceVO")DisappearanceVO disappearanceVO
	 * @param HttpServletRequest request
	 * @return "redirect:disappearancelist.do"
	 * @throws Exception
	 */
	@RequestMapping("/update.do")
	public String disappearance_update_pro(@ModelAttribute("disappearanceVO")DisappearanceVO disappearanceVO, HttpServletRequest request) throws Exception {
		disappearanceService.updateDisappearance(disappearanceVO, request);
		return "redirect:disappearance/list.do";
	}
	
	
	
	/** 
	 * 분실글의 매칭버튼을 클릭하면 실종글 정보와 일치한 게시글 화면으로 이동한다.
	 * @param @ModelAttribute("disappearanceVO")DisappearanceVO disappearanceVO
	 * @param HttpServletRequest request
	 * @return List<FindsVO> list
	 * @return "finds/finds_list"
	 * @throws Exception
	 */
	@RequestMapping("/match.do")
	public ModelAndView disappearance_match(@ModelAttribute("disappearanceVO")DisappearanceVO disappearanceVO) throws Exception {
		ModelAndView mv = new ModelAndView();
		List<FindsVO> list = disappearanceService.matchDisappearance(disappearanceVO);
		mv.addObject("findslist", list);
		mv.setViewName("finds/list");
		return mv;
	}
	
	/** 
	 * 파일 다운로드
	 * @param1 @RequestParam("idx") String idx
	 * @param2 HttpServletResponse response
	 * @throws Exception
	 */
	@RequestMapping("/download")
	public void disappearance_download(@RequestParam("idx") String idx, HttpServletResponse response) throws Exception{
		Map<String, Object> map = disappearanceService.selectFileInfo(idx);
	    String storedFileName = (String)map.get("D_STORED_FILE_NAME");
	    String originalFileName = (String)map.get("D_ORIGINAL_FILE_NAME");
	     
	    byte fileByte[] = FileUtils.readFileToByteArray(new File("C:\\dev\\image\\disappearancefile\\"+storedFileName));
	     
	    response.setContentType("application/octet-stream");
	    response.setContentLength(fileByte.length);
	    response.setHeader("Content-Disposition", "attachment; fileName=\"" + URLEncoder.encode(originalFileName,"UTF-8")+"\";");
	    response.setHeader("Content-Transfer-Encoding", "binary");
	    response.getOutputStream().write(fileByte);
	     
	    response.getOutputStream().flush();
	    response.getOutputStream().close();
	}
	

	/** 
	 * 조회기능
	 * @param @RequestParam("keyWord_search") String keyWord_search
	 * @param @RequestParam("selection_search") String selection_search)
	 * @return mv.addObject("disappearancelist", list)
	 * @return mv.setViewName("disappearance/disappearancelist")
	 * @throws Exception
	 */
	@RequestMapping("/search.do")
	public ModelAndView disappearance_search(@RequestParam("keyWord_search") String keyWord_search,	@RequestParam("selection_search") String selection_search) throws Exception {
		ModelAndView mv = new ModelAndView();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("keyWord_search", keyWord_search);
		map.put("selection_search", selection_search);
		List<DisappearanceVO> list = disappearanceService.searchDisappearance(map);
		mv.addObject("disappearancelist", list);
		mv.setViewName("disappearance/list");
		return mv;
	}
}
