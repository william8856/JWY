package com.jwy.springProj;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jwy.domain.BoardVO;
import com.jwy.domain.PagingCriteria;
import com.jwy.domain.PagingParam;
import com.jwy.domain.SearchCriteria;
import com.jwy.service.BoardService;

@Controller
@RequestMapping("/board/*")  // /board/ 의 하위 모든 URI에 대해 현재 클래스가 동작함을 의미
public class BoardController {
	@Inject
	private BoardService service;
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String registerGet(BoardVO vo, Model model) {
		// 글 등록 페이지 호출
		logger.info("/register.. get 호출");
		return "/board/registerBoard";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String registerPost(BoardVO vo, RedirectAttributes rttr) throws Exception {
		// 글 작성 페이지에서 submit버튼 클릭시
		logger.info("/register.. post 호출");
		logger.info(vo.toString());
		
		if(service.insert(vo)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/board/listCri";
	}
	
	@RequestMapping(value="/listAll", method=RequestMethod.GET)
	public void listAll(Model model) throws Exception {
		logger.info("/listAll.. get 호출");
		List<BoardVO> lst = service.listAll();
		model.addAttribute("boardList", lst);
	}
	
	@RequestMapping(value="/read", method=RequestMethod.GET)
	public void readBoard(@RequestParam("no") int no, Model model) throws Exception {
		// @RequestParam("no") int no -> int no = request.getParameter("no");
		logger.info("/read.. get 호출");
		System.out.println("no : " + no);
		model.addAttribute("board", service.read(no));
	}
	
	@RequestMapping(value="/remove", method=RequestMethod.GET)
	public String deleteBoard(@RequestParam("no") int no, RedirectAttributes rttr) throws Exception {
		logger.info("/remove.. get 호출");
		if(service.remove(no)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/board/listCri";
	}
	
	@RequestMapping(value="/modi", method=RequestMethod.GET)
	public void modiBoard(@RequestParam("no") int no, Model model) throws Exception {
		logger.info("/modi.. get 호출");
		model.addAttribute("board", service.read(no));
	}
	
	@RequestMapping(value="/modi", method=RequestMethod.POST)
	public String upadateBoard(BoardVO vo, RedirectAttributes rttr) throws Exception {
		logger.info("/modi.. post 호출");
		System.out.println(vo.toString());
		if(service.modify(vo)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/board/listCri";
	}
	
	@RequestMapping(value="/listCri", method=RequestMethod.GET)
	public void listAll(PagingCriteria cri, Model model) throws Exception {
		logger.info("페이징 이용한 전체 목록 출력");
		model.addAttribute("boardList", service.listCriteria(cri));  // 게시물 데이터
		
		logger.info(cri.toString());
		PagingParam pp = new PagingParam();
		pp.setCri(cri);
		pp.setTotalCount(service.getTotalBoardCnt());  // 게시물 갯수
		logger.info(pp.toString());
		
		model.addAttribute("pagingParam", pp);  // 페이징 처리를 위한 파라메터 객체
	}
	
	@RequestMapping(value="/search", method=RequestMethod.GET)
	public String search(SearchCriteria scri, PagingCriteria cri, Model model) throws Exception {
		System.out.println("검색 시작");
		System.out.println(scri.toString());
		model.addAttribute("boardList", service.goSearch(scri, cri));
		
		PagingParam pp = new PagingParam();
		pp.setCri(cri);
		pp.setTotalCount(service.getTotalBoardCnt());
		model.addAttribute("pagingParam", pp);
		
		return "/board/listCri";
	}
}
