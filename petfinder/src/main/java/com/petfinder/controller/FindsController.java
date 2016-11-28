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
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.petfinder.service.FindsService;
import com.petfinder.vo.DisappearanceVO;
import com.petfinder.vo.FindsVO;
import com.petfinder.vo.PagingVO;
/**
 * 諛쒓껄�젙蹂� CRUD �슂泥��쓣 泥섎━�븯�뒗 Controller �겢�옒�뒪
 * 
 * @author  1議�
 * @since 2016.11.14
 * @version 1.0
 * @see 
 * <pre>
 *  == 媛쒖젙�씠�젰(Modification Information) ==
 *   
 *      �닔�젙�씪       		   	�닔�젙�옄     		      �닔�젙�궡�슜
 *  ----------------    ------------    ---------------------------
 *   2016.11.14     		1議�             		理쒖큹 �깮�꽦
 *   2016.11.17				源��쁽吏�	  		requestmapping �닔�젙
 * </pre>
 */
@Controller
@RequestMapping("/finds")
public class FindsController {

	@Resource(name = "findsService")
	private FindsService findsService;

	/** 
	 * 諛쒓껄紐⑸줉�쓣 議고쉶 �븳�떎.
	 * @return1 List<FindsVO> list
	 * @return2 "Finds/findslist"
	 * @throws 
	 */
/*	@RequestMapping("/list.do")
	public ModelAndView findsList() {
		ModelAndView mv = new ModelAndView();
		List<FindsVO> list = findsService.findsList();
		mv.addObject("findslist", list);
		mv.setViewName("/finds/list");
		return mv;
	}*/
	
	
	@RequestMapping("/list.do")
	public ModelAndView disappearanceList(@ModelAttribute("PagingVO") PagingVO pagingVO, 
										  @RequestParam(value = "pageNo", required = false) String pageNo) {
		ModelAndView mv = new ModelAndView();
		pagingVO.setPageSize(6); // 한 페이지에 보일 게시글 수
		pagingVO.setPageNo(1); // 현재 페이지 번호
		if(StringUtils.isNotEmpty(pageNo)){
			pagingVO.setPageNo(Integer.parseInt(pageNo));
		}
		pagingVO.setBlockSize(5);
		pagingVO.setTotalCount(findsService.postCount()); // 게시물 총 개수
		
		//List<FindsVO> list = findsService.findsList();
		//mv.addObject("findslist", list);
		
		List<PagingVO> boardList = findsService.getBoardList(pagingVO);
		mv.addObject("paging", pagingVO);
		mv.addObject("boardList", boardList);
		mv.setViewName("/finds/list");
		return mv;
	}


	/**
	 * 諛쒓껄寃뚯떆�뙋 湲��벐湲� �솕硫댁쑝濡� �씠�룞�븳�떎.
	 * @param 
	 * @return "finds/finds_form";
	 * @throws 
	 */
	@RequestMapping("/write.do")
	public String finds_form() {
		return "/finds/write";
	}


	/**
	 * 諛쒓껄�젙蹂� �벑濡앺븯怨� 紐⑸줉議고쉶 �솕硫댁쑝濡� �씠�룞�븳�떎.
	 * @param1 @ModelAttribute("findsVO") FindsVO findsVO 諛쒓껄�젙蹂�
	 * @param2 HttpServletRequest request �뙆�씪�젙蹂�
	 * @return "redirect:findslist.do";
	 * @throws Exception
	 */
	@RequestMapping("/create.do")
	public String findsCreate(@ModelAttribute("findsVO") FindsVO findsVO, HttpServletRequest request) throws Exception {
		findsService.insertFinds(findsVO, request);
		return "redirect:/finds/list.do";
	}

	/**
	 * 諛쒓껄�젙蹂� �긽�꽭�솕硫댁쑝濡� �씠�룞�븳�떎.
	 * @param HttpServletRequest request
	 * @return1 Map<String,Object> map 
	 * @return2 "finds/finds_contents"
	 * @throws Exception
	 */
	@RequestMapping("/contents.do")
	public ModelAndView findsContents(HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView();
		Map<String, Object> map = findsService.selectBoardDetail(request.getParameter("idx"));
		mv.addObject("map", map.get("infoMap"));
		mv.addObject("file", map.get("fileMap"));
		mv.setViewName("/finds/contents");
		return mv;
	}



	/**
	 * 諛쒓껄湲��쓽 �뙣�뒪�썙�뱶 �솕硫댁뿉�꽌 �빐�떦 湲��뿉 �뙣�뒪�썙�뱶媛� �씪移섑븯硫� finds_delete_pro �씠�룞
	 * @param @RequestParam("pwd") String pwd 
	 * @param @RequestParam("idx") String idx
	 * @return "redirect:finds_delete.do?idx="+idx
	 * @return "redirect:finds_password.do?idx="+idx
	 */
	@RequestMapping("/delete_auth.do")
	public String findsDeleteAuth(@RequestParam("pwd") String pwd, @RequestParam("idx") String idx){
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
	 * 諛쒓껄�젙蹂� �궘�젣 �썑 紐⑸줉議고쉶 �솕硫댁쑝濡� �씠�룞�븳�떎.
	 * @param @RequestParam("idx") String idx
	 * @return "redirect:findslist.do"
	 * @throws Exception
	 */
	@RequestMapping("/delete.do")
	public String findsDelete(@RequestParam("idx") String idx){
		findsService.deleteFinds(idx);
		return "redirect:/finds/list.do";
	}


	/**
	 * 諛쒓껄湲��쓽 �뙣�뒪�썙�뱶 �솕硫댁뿉�꽌 �빐�떦 湲��뿉 �뙣�뒪�썙�뱶媛� �씪移섑븯硫� �닔�젙 �솕硫댁쑝濡� �씠�룞�븳�떎.
	 * @param @RequestParam("pwd") String pwd 
	 * @param @RequestParam("idx") String idx
	 * @return "redirect:finds_update.do?idx="+idx
	 * @return "redirect:finds_password.do?idx="+idx
	 */
	@RequestMapping("/update_auth.do")
	public String findsUpdateAuth(@RequestParam("pwd") String pwd, @RequestParam("idx") String idx){
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
	 * 諛쒓껄�젙蹂� �닔�젙 �솕硫댁쑝濡� �씠�룞�븳�떎.
	 * @param HttpServletRequest request
	 * @return1 Map<String,Object> map 
	 * @return2 "finds/finds_update"
	 * @throws Exception
	 */
	@RequestMapping("/edit.do")
	public ModelAndView findsEdit(HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView();
		Map<String, Object> map = findsService.selectBoardDetail(request.getParameter("idx"));
		mv.addObject("map", map);
		mv.setViewName("/finds/edit");
		return mv;
	}

	/** 
	 * 遺꾩떎�젙蹂� �닔�젙�븯怨� 紐⑸줉議고쉶 �솕硫댁쑝濡� �씠�룞�븳�떎.
	 * @param1 @ModelAttribute("findsVO")FindsVO findsVO
	 * @param2 HttpServletRequest request
	 * @return "redirect:findslist.do"
	 * @throws Exception
	 */
	@RequestMapping("/update.do")
	public String findsUpdate(@ModelAttribute("findsVO")FindsVO findsVO, HttpServletRequest request) throws Exception {
		findsService.updateFinds(findsVO, request);
		return "redirect:/finds/list.do";
	}



	/** 
	 * �뙆�씪 �떎�슫濡쒕뱶
	 * @param1 @RequestParam("idx") String idx
	 * @param2 HttpServletResponse response
	 * @throws Exception
	 */
	@RequestMapping("/download.do")
	public void findsDownload(@RequestParam("idx") String idx, HttpServletResponse response) throws Exception{
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
	 * 諛쒓껄湲��쓽 留ㅼ묶踰꾪듉�쓣 �겢由��븯硫� �떎醫낃� �젙蹂댁� �씪移섑븳 寃뚯떆湲� �솕硫댁쑝濡� �씠�룞�븳�떎.
	 * @param1 @ModelAttribute("findsVO")FindsVO findsVO
	 * @param2 HttpServletRequest request
	 * @return List<DisappearanceVO> list
	 * @return "disappearance/disappearance_list"
	 * @throws Exception
	 */
	@RequestMapping("/match.do")
	public ModelAndView findsMatch(@ModelAttribute("findsVO")FindsVO findsVO) throws Exception{
		ModelAndView mv = new ModelAndView();
		List<DisappearanceVO> list = findsService.matchFinds(findsVO);
		mv.addObject("disappearancelist", list);
		mv.setViewName("/disappearance/list");
		return mv;
	}


	/** 
	 * 議고쉶湲곕뒫
	 * @param @RequestParam("searchtext") String searchtext	
	 * @param @RequestParam("searchoption") String searchoption
	 * @return mv.addObject("disappearancelist", list)
	 * @return mv.setViewName("disappearance/disappearance_list")
	 * @throws Exception
	 */
	@RequestMapping("/search.do")
	public ModelAndView findsSearch(@RequestParam("keyWord_search") String keyWord_search,	@RequestParam("selection_search") String selection_search) throws Exception {
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
