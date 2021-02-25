package com.jwy.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.jwy.domain.BoardVO;
import com.jwy.domain.PagingCriteria;
import com.jwy.domain.SearchCriteria;

@Repository
public class BoardDAOImpl implements BoardDAO {
	
	@Inject
	private SqlSession ses;
	private static String namespace = "com.jwy.mapper.BoardMapper";

	@Override
	public int insert(BoardVO vo) throws Exception {
		return ses.insert(namespace + ".insertBoard", vo);
	}

	@Override
	public BoardVO readBoard(int no) throws Exception {
		return ses.selectOne(namespace + ".readBoard", no);
	}

	@Override
	public int update(BoardVO vo) throws Exception {
		return ses.update(namespace + ".updateBoard", vo);
	}

	@Override
	public int delete(int no) throws Exception {
		return ses.update(namespace + ".deleteBoard", no);
	}

	@Override
	public List<BoardVO> listBoard() throws Exception {
		return ses.selectList(namespace + ".listBoard");
	}

	@Override
	public List<BoardVO> listBoardPaging(int page) throws Exception {
		if (page <= 0) {
			page = 1;
		}
		
		page = (page - 1) * 10;
		
		return ses.selectList(namespace + ".listBoardPaging", page);
	}

	@Override
	public List<BoardVO> listBoardCriteria(PagingCriteria cri) throws Exception {
		return ses.selectList(namespace + ".listBoardCriteria", cri);
	}

	@Override
	public int getTotalBoardCnt() throws Exception {
		return ses.selectOne(namespace + ".getTotalBoardCnt");
	}

	@Override
	public List<BoardVO> goSearch(SearchCriteria scri) throws Exception {
		return ses.selectList(namespace + ".searchBoard", scri);
	}

}
