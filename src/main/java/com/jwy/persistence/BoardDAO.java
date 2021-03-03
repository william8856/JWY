package com.jwy.persistence;

import java.util.List;

import com.jwy.domain.BoardVO;
import com.jwy.domain.PagingCriteria;
import com.jwy.domain.SearchCriteria;

public interface BoardDAO {
	// 글 생성
	public int insert(BoardVO vo) throws Exception;
	
	// 상세글 조회
	public BoardVO readBoard(int no) throws Exception;
	
	public int update(BoardVO vo) throws Exception;
	
	public int delete(int no) throws Exception;
	
	public List<BoardVO> listBoard() throws Exception;
	
	// 페이징
	public List<BoardVO> listBoardPaging(int page) throws Exception;
	
	public List<BoardVO> listBoardCriteria(PagingCriteria cri) throws Exception;

	public int getTotalBoardCnt() throws Exception;

	public List<BoardVO> goSearch(SearchCriteria scri, PagingCriteria cri) throws Exception;
	
	// 검색 결과 글 수 가져오기
	public int getSearchCount(SearchCriteria scri);
	
	// 답글 달렸을 때 답글 수 update
	public void updateReply(int no, int amount) throws Exception;
	
	// 조회수 증가
	public void updateViewCnt(int no) throws Exception;
}
