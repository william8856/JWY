package com.jwy.persistence;

import java.util.List;

import com.jwy.domain.BoardVO;

public interface BoardDAO {
	// 글 생성
	public int insert(BoardVO vo) throws Exception;
	
	// 상세글 조회
	public BoardVO readBoard(int no) throws Exception;
	
	public int update(BoardVO vo) throws Exception;
	
	public int delete(int no) throws Exception;
	
	public List<BoardVO> listBoard() throws Exception;
}
