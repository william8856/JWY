package com.jwy.persistence;

import java.util.List;

import com.jwy.domain.BoardVO;

public class BoardDAO {
	// 글 생성
	public boolean insert(BoardVO vo) throws Exception;
	
	// 상세글 조회
	public BoardVO readBoard(int no) throws Exception;
	
	public boolean update(BoardVO vo) throws Exception;
	
	public boolean delete(int no) throws Exception;
	
	public List<BoardVO> listBoard() throws Exception;
	
}
