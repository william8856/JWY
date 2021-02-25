package com.jwy.service;

import java.util.List;

import com.jwy.domain.BoardVO;
import com.jwy.domain.PagingCriteria;
import com.jwy.domain.SearchCriteria;

public interface BoardService {
	public boolean insert(BoardVO vo) throws Exception;
	
	public BoardVO read(int no) throws Exception;
	
	public boolean modify(BoardVO vo) throws Exception;
	
	public boolean remove(int no) throws Exception;
	
	public List<BoardVO> listAll() throws Exception;
	
	public List<BoardVO> listCriteria(PagingCriteria cri) throws Exception;

	public int getTotalBoardCnt() throws Exception;

	public List<BoardVO> goSearch(SearchCriteria scri, PagingCriteria cri) throws Exception;

}
 